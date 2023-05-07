	document.getElementById("nombrePiloto").addEventListener("blur",comprobarNombre);
	document.getElementById("apellidosPiloto").addEventListener("blur",comprobarApellidos);
	document.getElementById("dniPiloto").addEventListener("blur",comprobarDni);
	document.getElementById("imgPiloto").addEventListener("blur",comprobarImg);
	document.getElementById("emailPiloto").addEventListener("blur",comprobarEmail);
	document.getElementById("fechaNacimiento").addEventListener("blur",comprobarEdad);
	
	document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);

function validarFormulario(){
	let resultado = false;

	resultado = comprobarEdad() &&
				comprobarNombre() &&
				comprobarApellidos() &&
				comprobarDni() &&
				comprobarImg() &&
				comprobarEmail();

	return resultado;
}

function comprobarNombre(){
	let nombre = formPilotos.nombrePiloto;
	let correcto = nombre.value!="";
	
	if(correcto){
		nombre.nextElementSibling.hidden = true;
	}else{
		nombre.nextElementSibling.hidden = false;
	}
	
	return correcto;
}

function comprobarApellidos(){
	let apellidos = formPilotos.apellidosPiloto;
	let correcto = apellidos.value!="";
	
	if(correcto){
		apellidos.nextElementSibling.hidden = true;
	}else{
		apellidos.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarDni(){
	let dni = formPilotos.dniPiloto;
	let correcto = dni.value!="";
	
	if(correcto){
		
		dni.value = dni.value.toUpperCase();
		let numDNI = dni.value.substring(0,8); 
		let letraDNI = dni.value.substring(8);

		let letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
		 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

		correcto = (numDNI > 0 && numDNI < 99999999) && (letras[numDNI%23]==letraDNI);
		
		if(correcto){
			dni.nextElementSibling.hidden = true;
		}else{
			dni.nextElementSibling.hidden = false;
		}
	}
	
	
	return correcto;
}
function comprobarImg(){
	return true;
}
function comprobarEmail(){
	let corrreo = formPilotos.emailPiloto;
	let correcto = corrreo.value!="";
	
	if(correcto){
		corrreo.nextElementSibling.hidden = true;
	}else{
		corrreo.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarEdad(){
	let fecha = formPilotos.fechaNacimiento;
	let correcto = fecha.value!="";
	
	if(correcto){
		let fechaDate = fecha.valueAsDate;
		let hoy = new Date();

		let anyos = hoy.getYear()-fechaDate.getYear();		
		
		correcto = anyos>=6;
		
	}
	
	if(correcto){
		fecha.parentNode.nextElementSibling.hidden = true;
	}else{
		fecha.parentNode.nextElementSibling.hidden = false;
	}
	
	return correcto;
}