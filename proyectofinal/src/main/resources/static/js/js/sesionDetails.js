let selectorPiloto = document.getElementById("pilotoVueltas");

selectorPiloto.addEventListener('change',showLaps);
document.addEventListener("DOMContentLoaded", showLaps);

function showLaps(evento){
	let tablasVueltas = document.querySelectorAll("#tablaVueltas tbody");
	
	for (let tabla of tablasVueltas){
		if(tabla.id == evento.currentTarget.value){
			tabla.hidden = false;
		}else{
			tabla.hidden = true;
		}
	}
}

showLaps();