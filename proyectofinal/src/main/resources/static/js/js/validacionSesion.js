	document.getElementById("fechaSesion").addEventListener("blur",comprobarReserva);
	document.getElementById("participantes").addEventListener("blur",comprobarEdades);
	
	document.querySelectorAll(".errorForm").forEach(p => p.hidden = true);

function validarFormulario(){
	let resultado = false;

	resultado = comprobarReserva() &&
				comprobarEdades();

	return resultado;
}
function comprobarReserva(){
	let fecha = formSesiones.fechaSesion;
	let correcto = fecha.value!="" && Date.parse(fecha.value) > Date.now();
	
	if(correcto){
		fecha.parentNode.nextElementSibling.hidden = true;
	}else{
		fecha.parentNode.nextElementSibling.hidden = false;
	}
	
	return correcto;
}
function comprobarEdades(){
	let pilotosElegidos = [];
	
	for (let option of document.getElementById('participantes').options){
        if (option.selected) {
            pilotosElegidos.push(option.value);
        }
    }
	
	let edadMinima = document.getElementById(formSesiones.kart.value).innerHTML;
	let formularioParticipantes = document.getElementById("participantes");
	let fechasNacimiento = [];
	let hoy = new Date();
	let correcto = true;
	
	for (let piloto of pilotosElegidos){
		fechasNacimiento.push(new Date(document.getElementById(piloto).innerHTML));
	}
	
	for (let fechaN of fechasNacimiento){
		if(hoy.getFullYear() - fechaN.getFullYear() < edadMinima){
			correcto = false;
		}
	}
	
	if(correcto){
		formularioParticipantes.nextElementSibling.hidden = true;
	}else{
		formularioParticipantes.nextElementSibling.hidden = false;
	}
	
	return correcto;
	
}