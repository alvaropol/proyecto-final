let mensajeErrorPrecio = document.getElementById("mensajeErrorPrecio");
let mensajeErrorNombre = document.getElementById("mensajeErrorNombre");

function validarFormularioEntero() {
	let validado = true;

	validado = validarNombre() &&
		validarPrecio();
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

function validarPrecio() {
  let precio = document.getElementById("precio").value;

  if (!/^[1-9]\d*(\.\d+)?$/.test(precio) || parseFloat(precio) < 5) {

    mensajeErrorPrecio.style.display = "block";
    return false;
  } 
    mensajeErrorPrecio.style.display = "none";
    return true;
  
}


let formulario = document.getElementById("formularioProducto");
formulario.addEventListener("submit", function(event) {
	if (validarFormularioEntero()) {

	} else {
		event.preventDefault();
	}
});