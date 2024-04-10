//Funcion de inicio después de la carga de la pagina
document.addEventListener('DOMContentLoaded', function() {
	var currentUrl = window.location.href;
	llamada();
	
	if (currentUrl.includes('Index.html')) {
		slider();
	}
	if (currentUrl.includes('login.html')) {
		validarLoginForm();
		errorAlLoguear();
	}
	if (currentUrl.includes('modificarUser.html')) {
		modificarUsuario();
	}
	if (currentUrl.includes('altaUsuario.html')) {
		validarFormularioU();
	}
	if (currentUrl.includes('modificarSlider.html')) {
		updateSlider();
	}
});

//Variables globales 
const ajax = new XMLHttpRequest();
var ruta = "http://localhost:8080/NexusCom/fotos/fotosArticulos/";
let id_carrito;

//Funciones para comprobar la sesion
function llamada() {
	let myurl = 'ComprobarSesion';

	myRand = parseInt(Math.random() * 9999);
	modurl = myurl + '?rand=' + myRand;
	ajax.open("GET", modurl, true);
	ajax.setRequestHeader('Content-Type', 'application/json');
	ajax.onreadystatechange = respuesta;

	ajax.send(null);
}

function respuesta() {
	if (ajax.readyState == 4) {
		if (ajax.status == 200) {
			try {
				let responseJSON = JSON.parse(ajax.responseText);
				let nombre = responseJSON.nombre;
				let privilegios = responseJSON.privilegios;
				id_carrito = responseJSON.id_carrito;
				var botonInis = document.getElementById("iniciarSesion");
				var botonSal = document.getElementById("cerrarSesion");
				var carritoNav = document.getElementById("carrito")
				if (nombre !== null && nombre !== undefined) {
					document.getElementById("sesion").innerHTML += '<h5>Bienvenido/a ' + nombre + '</h5><a href="areaPersonal.html">Tu area personal</a>';
					botonInis.style.display = "none";
					botonSal.style.display = "block";
					carritoNav.style.display = "block";
				} else {
					document.getElementById("sesion").innerHTML += '<h6>Bienvenido/a Invitado/a</h6>';
					botonInis.style.display = "block";
					botonSal.style.display = "none";
					carritoNav.style.display = "none";
				}
				mostrarPanelAdministracion(privilegios);
				mostrarContenidoCarrito(id_carrito);
			} catch (error) {
				console.error("Error al analizar la respuesta JSON:", error);
			}
		}
	}
}


// Función para mostrar el enlace al panel de administracion y su hipervínculo
function mostrarPanelAdministracion(privilegios) {
	var objeto = document.getElementById("objeto");
	var hipervinculo = document.getElementById("hipervinAdm");

	if (privilegios !== null && privilegios >= 20) {
		objeto.style.display = "block";
		hipervinculo.style.display = "block";
	} else {
		objeto.style.display = "none";
		hipervinculo.style.display = "none";
	}
}

//Función para mostrar el contenido del carrito

//document.getElementById("carritoDesplegable").addEventListener("click", mostrarContenidoCarrito);

function mostrarContenidoCarrito(id_carrito) {
	document.getElementById("carritoDesplegable").addEventListener("click", mostrarContenidoCarrito);
	// Aquí puedes realizar una llamada AJAX para obtener el contenido del carrito desde el servidor
	// y luego mostrar los artículos en una ventana emergente o en un panel desplegable.
	// Puedes usar la función obtenerEnJSON(idCarrito) del DAO en Java para obtener el contenido del carrito en formato JSON
	// 1. Realiza la llamada AJAX para obtener el contenido del carrito en formato JSON
	// 2. Parsea el JSON recibido en un objeto JavaScript
	// 3. Muestra los artículos en una ventana emergente o en un panel desplegable utilizando el objeto JavaScript

	fetch(`CarritoServlet?id_carrito=${id_carrito}`)
		.then(response => response.json())
		.then(data => {

			const carritoD = document.getElementById('carritoDesplegable');
			carritoD.innerHTML = ''; // Limpiamos el contenido previo

			data.forEach(item => {
				const elemento = document.createElement('div');
				elemento.className = 'itemCarrito';
				elemento.innerHTML = `
          <img src="${item.imagen}">
          <div>${item.nombre}</div>
          <div>${item.precio}€</div>
          <button onclick="eliminarDelCarrito(${item.id})">Eliminar</button>
        `;
				carritoD.appendChild(elemento);
			});

			// También puedes mostrar el total, el número de elementos, etc.
			//const total = data.reduce((sum, item) => sum + item.precio, 0);
			// ...

		})
		.catch(error => {
			console.error(error);
		});
}

//Funciónes del Slider 
function slider() {
	const slides = document.querySelectorAll('.slide');
	let currentSlide = 0;

	// Mostrar la primera diapositiva
	slides[currentSlide].classList.add('active');

	// Función para activar la diapositiva actual y desactivar las demás
	function showSlide() {
		slides.forEach(slide => slide.classList.remove('active'));
		slides[currentSlide].classList.add('active');
	}

	// Función para avanzar a la siguiente diapositiva
	function nextSlide() {
		currentSlide++;
		if (currentSlide >= slides.length) {
			currentSlide = 0;
		}
		showSlide();
	}

	// Función para iniciar el slider y las transiciones
	function startSlider() {
		setInterval(() => {
			nextSlide();
		}, 6000);
	}

	startSlider();
}

function updateSlider() {

	const imageUrls = ['http://localhost:8080/NexusCom/fotos/fotosBanner/banner-yeti-1920x600px-Cuylas-maig--2021.jpg', 'http://localhost:8080/NexusCom/fotos/fotosBanner/Banner-Hoka Transport1920x600px_Cuylas.jpg', 'http://localhost:8080/NexusCom/fotos/fotosBanner/Banner-Theragun-pro-G5-1920x600px-Cuylás-abril-2023-N.JPG'];
	updateSliderImages(imageUrls);
	// Manejador de eventos para el envío del formulario
	document.getElementById('sliderForm').addEventListener('submit', function(event) {
		event.preventDefault();

		const imageUrls = [];
		const foto1 = document.getElementById('image1').files[0];
		const foto2 = document.getElementById('image2').files[0];
		const foto3 = document.getElementById('image3').files[0];

		// Crear objetos URL para obtener las URL de las imágenes seleccionadas
		const imageURL1 = URL.createObjectURL(foto1);
		const imageURL2 = URL.createObjectURL(foto2);
		const imageURL3 = URL.createObjectURL(foto3);

		// Agregar las URL de las imágenes al array
		imageUrls.push(imageURL1, imageURL2, imageURL3);

		updateSliderImages(imageUrls);

		document.getElementById('sliderForm').reset();
	});
}

// Función para actualizar las imágenes del slider
function updateSliderImages(imageUrls) {
	const slides = document.querySelectorAll('.slide');

	for (let i = 0; i < slides.length; i++) {
		slides[i].style.backgroundImage = `url(${imageUrls[i]})`;
	}
}

//Funciones para el buscador con la var ruta

//Mostrar todo
function obtenerArticulos() {
	fetch('Listado')
		.then(res => res.json())
		.then(res => pintar(res));
}
//Funcion fetch del buscador
function obtenerPorNombre() {
	const formB = document.getElementById("formBuscador");
formB.addEventListener("submit", obtenerPorNombre);
	let nombre = document.getElementById("inputBuscador").value;

	fetch("Listado?buscar=" + nombre)
		.then(res => res.json())
		.then(res => pintar(res));
	event.preventDefault();
}
function obtenerPorFamilia(event) {
  var nombre = event.target.getAttribute('value');

  fetch("ListadoFamilias?buscar=" + nombre)
    .then(res => res.json())
    .then(res => pintar(res));
}

var menuItems = document.querySelectorAll('nav ul li a');

menuItems.forEach(function(item) {
  item.addEventListener('click', obtenerPorFamilia);
});

// Agregar el manejador de eventos al formulario
//const formB = document.getElementById("formBuscador");
//formB.addEventListener("submit", obtenerPorNombre);

// Funcion para pintar todos los Articulos en su casilla del listado con nombre precio y boton para añadir al carrito
function pintar(datos) {
	if (typeof datos === 'string') {
		datos = JSON.parse(datos); // Convertir la cadena JSON a un objeto JSON
	}
	const contenedor = document.getElementById('listado');
	contenedor.innerHTML = ''; // Limpiamos el contenido previo

	for (let i = 0; i < datos.length; i++) {//Bucle para recorrer los articulos
		const articulo = datos[i];
		const elemento = document.createElement('div');
		elemento.className = 'item'; //Agregar un nombre de clase al elemento

		elemento.innerHTML = `	                   
	                        
	                <img src="${ruta}${articulo.foto}">
	                <div>${articulo.nombre}</div>
	                <div>${articulo.precio_v}€</div> 
	                <button onclick="incluirAlCarrito(${articulo.id_articulo})">Añadir al Carrito</button>                     
	            `;

		contenedor.appendChild(elemento);
	}

	contenedor.className = "caja";
}

//Añadir Articulos al carrito
function incluirAlCarrito(id_articulo) {

	fetch('CarritoServlet', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: `id_articulo=${id_articulo}&id_carrito=${id_carrito}`
	})

		.then(response => {
			if (!response.ok) {
				throw new Error('Error al realizar la solicitud');
			}
			return response.json();
		})
		.then(data => {
			// Lógica para manejar la respuesta JSON

			window.location.reload();
		})
		.catch(error => {
			// Manejo de errores
			console.error(error);
		});

}

//Validación del formulario login
function validarLoginForm() {
	const form = document.getElementById('login');

	form.addEventListener('submit', (event) => {
		event.preventDefault();
		const username = document.getElementById('username').value;
		const password = document.getElementById('password').value;
		if (username.trim() === '' || password.trim() === '') {

			//Muestra el mensaje de error	
			alert('Nombre de usuario o contraseña no insertados');
			return;
		}
		form.submit();
	});
}

function errorAlLoguear() {
	const errorMensaje = document.getElementById("errorMensaje");
	errorMensaje.textContent = "Usuario o contraseña inválidos";

	const usernameInput = document.getElementById("username");
	const passwordInput = document.getElementById("password");

	usernameInput.value = "";
	passwordInput.value = "";

	usernameInput.focus(); // Establecer el foco en el campo de nombre de usuario
}

// Función de validación formulario alta nuevo Usuario
function validarFormularioU() {
	// Obtener el formulario
	var formulario = document.getElementById("formularioU");

	// Agregar un evento de escucha para el evento submit
	formulario.addEventListener("submit", function(event) {
		// Detener el envío del formulario
		event.preventDefault();

		// Obtener los valores de los campos del formulario
		var nombre = formulario.nombre.value;
		var apellidos = formulario.apellidos.value;
		var fechaNacimiento = formulario.fecha_nacimiento.value;
		var direccion = formulario.direccion.value;
		var codigoPostal = formulario.codigo_postal.value;
		var telefono = formulario.telefono.value;
		var email = formulario.email.value;
		var password = formulario.password.value;

		// Validar que los campos no estén vacíos
		if (nombre.trim().length === 0) {
			mostrarError("Por favor, ingresa tu nombre.");
			return;
		}

		if (apellidos.trim().length === 0) {
			mostrarError("Por favor, ingresa tus apellidos.");
			return;
		}

		if (fechaNacimiento.trim().length === 0) {
			mostrarError("Por favor, ingresa tu fecha de nacimiento.");
			return;
		}

		if (direccion.trim().length === 0) {
			mostrarError("Por favor, ingresa tu dirección.");
			return;
		}

		if (codigoPostal.trim().length === 0) {
			mostrarError("Por favor, ingresa tu código postal.");
			return;
		}

		if (telefono.trim().length === 0) {
			mostrarError("Por favor, ingresa tu teléfono.");
			return;
		}

		if (email.trim().length === 0) {
			mostrarError("Por favor, ingresa tu correo electrónico.");
			return;
		}
		if (!emailVálido(email.value)) {
			mostrarError("Por favor, escribe un correo electrónico válido");
			emailAddress.focus();
			return false;
		}

		if (password.trim().length === 0) {
			mostrarError("Por favor, ingresa tu contraseña.");
			return;
		}

		// Si todas las validaciones son exitosas, puedes enviar el formulario
		formulario.submit();
	});
	const emailVálido = email => {
		return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
	}

	// Función para mostrar mensajes de error
	function mostrarError(mensaje) {
		var mensajeError = document.getElementById("mensajeError");
		mensajeError.innerText = mensaje;
	}
}

//Funciones para la pagina modificarUsuario.

function modificarUsuario() {
	document.getElementById('formularioUM').addEventListener('submit', function(event) {
		event.preventDefault(); // Evita que se envíe el formulario automáticamente

		// Obtiene los valores ingresados en el formularioUM
		var nombre = document.getElementById('nombre').value;
		var apellidos = document.getElementById('apellidos').value;
		var nif = document.getElementById('nif').value;
		var direccion = document.getElementById('direccion').value;
		var codigo_postal = document.getElementById('codigo_postal').value;
		var telefono = document.getElementById('telefono').value;
		var email = document.getElementById('email').value;

		// Crea un objeto con los valores para enviar al servidor
		var datos = {
			nombre: nombre,
			apellidos: apellidos,
			nif: nif,
			direccion: direccion,
			codigo_postal: codigo_postal,
			telefono: telefono,
			email: email
		};

		// Realiza una petición AJAX para enviar los datos al servidor

		let myurl = 'ModificarUsuario';

		myRand = parseInt(Math.random() * 9999);
		modurl = myurl + '?rand=' + myRand;

		ajax.open('POST', 'modurl', true);
		ajax.setRequestHeader('Content-Type', 'application/json');
		ajax.onreadystatechange = function() {
			if (ajax.readyState === XMLHttpRequest.DONE && ajax.status === 200) {
				// Muestra una alerta con la respuesta del servidor
				alert(xhr.responseText);
			}
		};
		ajax.send(JSON.stringify(datos));
	});
}

//Cerrar sesión Usuario
function cerrarSesion() {

	// Enviar una solicitud AJAX para cerrar la sesión
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'CerrarSesion', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {

			// Recargar la página después de cerrar la sesión
			location.reload();
		}
	};
	xhr.send();
}


