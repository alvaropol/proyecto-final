	document.getElementById("nombreKart").addEventListener("blur",comprobarNombre);
	document.getElementById("descripcionKart").addEventListener("blur",comprobarDescripcion);
	document.getElementById("imgKart").addEventListener("blur",comprobarImg);
	document.getElementById("PrecioSesion").addEventListener("blur",comprobarPrecio);
	document.getElementById("EdadMinima").addEventListener("blur",comprobarEdad);
	document.getElementById("cc").addEventListener("blur",comprobarSpecs);
	document.getElementById("cv").addEventListener("blur",comprobarSpecs);
	document.getElementById("kmh").addEventListener("blur",comprobarSpecs);

	document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);
	
function validarFormulario(){
	let resultado = false;

	resultado = comprobarNombre() &&
				comprobarDescripcion() &&
				comprobarImg() &&
				comprobarPrecio() &&
				comprobarEdad();

	return resultado;
}

function comprobarNombre(){
	let nombre = formKarts.nombreKart;
	let correcto = nombre.value!="";
	
	if(correcto){
		nombre.nextElementSibling.hidden = true;
	}else{
		nombre.nextElementSibling.hidden = false;
	}
	
	return correcto;
}

function comprobarDescripcion(){
	let desc = formKarts.descripcionKart;
	let correcto = desc.value.length >= 25;
	
	if(correcto){
		desc.nextElementSibling.hidden = true;
	}else{
		desc.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarImg(){
	let img = formKarts.imgKart;
	let correcto = img.value!="";
	
	if(correcto){
		img.nextElementSibling.hidden = true;
	}else{
		img.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarEdad(){
	let edad = formKarts.EdadMinima;
	let correcto = edad.value!="" &&  !isNaN(edad.value) && Number.isInteger(+edad.value) && edad.value >= 6;
	
	if(correcto){
		edad.nextElementSibling.hidden = true;
	}else{
		edad.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarPrecio(){
	let precio = formKarts.PrecioSesion;
	let correcto = precio.value!="" &&  !isNaN(precio.value) && precio.value > 0;
	
	if(correcto){
		precio.nextElementSibling.hidden = true;
	}else{
		precio.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarSpecs(){
	let caballos = formKarts.cv;
	let cilindrada = formKarts.cc;
	let vpunta = formKarts.kmh;
	let mensaje = document.getElementById("mensajeSpecs");
	let correcto = !isNaN(caballos.value) && caballos.value >= 0 && caballos.value <= 100 &&
				!isNaN(cilindrada.value) && cilindrada.value >= 0 &&
				!isNaN(vpunta.value) && vpunta.value >= 0;
	
	if(correcto){
		mensaje.hidden = true;
	}else{
		mensaje.hidden = false;
	}
	
	return correcto;
}