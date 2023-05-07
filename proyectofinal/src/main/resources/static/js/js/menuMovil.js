document.getElementById("burgerMenuIcon").addEventListener("click",toggleMenu);

function toggleMenu(){
	let nav = document.querySelector(".navadmin");
	
	nav.classList.toggle("desplegado");
}