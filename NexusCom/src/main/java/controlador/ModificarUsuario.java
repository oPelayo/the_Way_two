package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import dao.DBconexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        // Obtén los datos del formulario enviados por JavaScript
        String nombre = "";
        String apellidos = "";
        String nif = "";
        String direccion = "";
        int codigoPostal = 0;
        String telefono = "";
        String email = "";

        try {
        	con = DBconexion.getConnection();
            JSONObject jsonObject = new JSONObject(sb.toString());
            nombre = jsonObject.getString("nombre");
            apellidos = jsonObject.getString("apellidos");
            nif = jsonObject.getString("nif");
            direccion = jsonObject.getString("direccion");
            codigoPostal = jsonObject.getInt("codigo_postal");
            telefono = jsonObject.getString("telefono");
            email = jsonObject.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Realiza la actualización en la base de datos
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE usuario SET nombre=?, apellidos=?, nif=?, direccion=?, codigo_postal=?, telefono=? WHERE email=?");
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, nif);
            ps.setString(4, direccion);
            ps.setInt(5, codigoPostal);
            ps.setString(6, telefono);
            ps.setString(7, email);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            // Envía una respuesta al cliente
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (rowsAffected > 0) {
                out.print("¡Datos actualizados!");
            } else {
                out.print("No se pudieron actualizar los datos, revisa la información.");
            }
            out.flush();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
	public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
