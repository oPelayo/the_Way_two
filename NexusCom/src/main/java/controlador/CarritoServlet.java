package controlador;

import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoArticulo;
import dao.DaoCarrito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Articulo;
import modelo.Carrito;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CarritoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idArticulo = Integer.parseInt(request.getParameter("id_articulo"));
        int idCarrito = Integer.parseInt(request.getParameter("id_carrito"));

        try {
            DaoCarrito daoCarrito = new DaoCarrito();
            DaoArticulo daoArticulo = new DaoArticulo();

            // Obtener el carrito actual desde la base de datos
            Carrito carrito = daoCarrito.obtenerCarritoPorId(idCarrito);

            if (carrito != null) {
                // Obtener el artículo a partir del ID
                String articuloJson = daoArticulo.obtenerPorId(idArticulo);

                if (articuloJson != null) {
                    // Convertir el artículo JSON a un objeto Articulo
                    Gson gson = new Gson();
                    Articulo articulo = gson.fromJson(articuloJson, Articulo.class);


                    carrito.getCesta().add(articulo);

                    // Actualizar el carrito en la base de datos
                    daoCarrito.actualizarCarrito(carrito);
                } else {
                    System.out.println("El artículo no existe.");
                }
            } else {
                System.out.println("El carrito no existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }
}















