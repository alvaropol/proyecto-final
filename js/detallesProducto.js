function changeImage(element) {

    var main_prodcut_image = document.getElementById('main_product_image');
    main_prodcut_image.src = element.src;
    

}

let numeroAleatorio = Math.floor(Math.random() * 500) + 1;

document.getElementById("numeroAleatorio").innerHTML = numeroAleatorio+" valoraciones";