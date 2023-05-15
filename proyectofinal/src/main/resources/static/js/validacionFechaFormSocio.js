let formulario = document.getElementById("formularioSocio");
let mensajeError = document.getElementById("mensajeError");
formulario.addEventListener("submit", function(event) {
  event.preventDefault();
  let fechaNacimiento = new Date(document.getElementById("fechaNacimiento").value);
  let hoy = new Date();
  let edadMinima = new Date();
  edadMinima.setFullYear(edadMinima.getFullYear() - 3);
  if (!fechaNacimiento || isNaN(fechaNacimiento) || fechaNacimiento > hoy || fechaNacimiento > edadMinima) {
    mensajeError.style.display = "block";	
    return false;
  }
  mensajeError.style.display = "none";
  this.submit();
});