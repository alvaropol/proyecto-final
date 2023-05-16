let mensajeErrorFecha = document.getElementById("mensajeErrorFecha");
let mensajeErrorTelefono = document.getElementById("mensajeErrorTelefono");
let mensajeErrorEmail = document.getElementById("mensajeErrorEmail");
let mensajeErrorNombre = document.getElementById("mensajeErrorNombre");
let mensajeErrorApellidos = document.getElementById("mensajeErrorApellidos");
let mensajeErrorDni = document.getElementById("mensajeErrorDni");

function validarFormularioEntero() {
	let validado = true;

	validado = validarNombre() &&
		validarApellidos() &&
		validarEmail() &&
		validarTelefono() &&
		validarFecha() &&
		validarDNI();
	return validado;
}


function validarFecha() {
	let fechaNacimiento = new Date(document.getElementById("fechaNacimiento").value);
	let hoy = new Date();
	let edadMinima = new Date();
	edadMinima.setFullYear(edadMinima.getFullYear() - 3);

	if (!fechaNacimiento || isNaN(fechaNacimiento) || fechaNacimiento > hoy || fechaNacimiento > edadMinima) {
		mensajeErrorFecha.style.display = "block";
		return false;
	}
	mensajeErrorFecha.style.display = "none";
	return true;

}

function validarTelefono() {

	let telefono = document.getElementById("phone").value;
	let patronTelefono = /^[0-9]{9}$/;

	if (!patronTelefono.test(telefono)) {
		mensajeErrorTelefono.style.display = "block";
		return false;
	}
	mensajeErrorTelefono.style.display = "none";
	return true;

}

function validarNombre() {
	let nombre = document.getElementById("nombre").value;
	if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(nombre)) {
		mensajeErrorNombre.style.display = "block";
		return false;
	}
	mensajeErrorNombre.style.display = "none";
	return true;
}

function validarApellidos() {
	let apellidos = document.getElementById("apellidos").value;
	if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/.test(apellidos)) {
		mensajeErrorApellidos.style.display = "block";
		return false;
	}
	mensajeErrorApellidos.style.display = "none";
	return true;
}

function validarEmail() {
	let email = document.getElementById("email").value;
	if (!/^\S+@\S+\.\S+$/.test(email)) {
		mensajeErrorEmail.style.display = "block";
		return false;
	}
	mensajeErrorEmail.style.display = "none";
	return true;
}

function validarDNI() {
	let dni = document.getElementById("dni").value;
  if (!/^\d{8}[A-Z]$/.test(dni)) {
	  mensajeErrorDni.style.display = "block";
    return false;
  }
  mensajeErrorDni.style.display = "none";
  return true;
}

let formulario = document.getElementById("formularioSocio");
formulario.addEventListener("submit", function(event) {
	if (validarFormularioEntero()) {

	} else {
		event.preventDefault();
	}
});

