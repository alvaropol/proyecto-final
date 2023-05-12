let contactForm = document.getElementById("contactForm");
contactForm.addEventListener("submit", function(event) {

	event.preventDefault();

	let inputNombre = document.getElementById("nombre");
	let inputEmail = document.getElementById("email");
	let inputMensaje = document.getElementById("mensaje");

	if (!inputNombre.validity.valid || !inputEmail.validity.valid || !inputMensaje.validity.valid) {

		alert("Por favor, rellene todos los campos del formulario.");
	} else {

		//Aqui selecciono el id del div de la caja que quiero que aparezca si rellena todo el form del mensaje, 
		//y lo pongo con estilo display:block;
		document.getElementById("thankYouMessage").style.display = "block";
		document.getElementById("submitButton").disabled = true;
	}
});


//Aqui he hecho un método que me genera un número aleatorio entre 1 y 20000 para el ID del mensaje.
let numeroAleatorio = generarNumeroAleatorio();

document.getElementById("numeroMensaje").textContent = "#" + numeroAleatorio;

function generarNumeroAleatorio() {
	let numeroAleatorio = Math.floor(Math.random() * 20000) + 1;
	return numeroAleatorio;
}