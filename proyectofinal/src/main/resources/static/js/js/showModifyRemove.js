let filas = document.querySelectorAll("tbody tr");
let botones = document.getElementById("modifyRemoveButtons");
botones.hidden= true;

for(let fila of filas) {
       fila.addEventListener("click", showButtons);
}

function showButtons(fila) {
	botones.hidden = false;
	fila.currentTarget.classList.toggle("selected");
}