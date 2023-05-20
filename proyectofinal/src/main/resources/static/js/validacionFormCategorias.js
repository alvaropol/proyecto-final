let mensajeErrorNombre = document.getElementById("mensajeErrorNombre");

function validarFormularioEntero() {
	let validado = true;

	validado = validarNombre();
	return validado;
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


let formulario = document.getElementById("formularioCategorias");
formulario.addEventListener("submit", function(event) {
	if (validarFormularioEntero()) {

	} else {
		event.preventDefault();
	}
});