let buttonSup = document.getElementById("support_button");
buttonSup.addEventListener("click", function() {
    setTimeout(function() {
    window.location.replace("../HTML/support.html");
    }, 3000); // El número 3000 representa el tiempo en milisegundos (3 segundos)
});
/*buttonSup.addEventListener("click", function(){
    setTimeout(function() {
        window.location.replace("../HTML/support.html");
    }, 3000);
});*/

let buttonShop = document.getElementById("shop_button");
buttonShop.addEventListener("click", function(){
    window.location.replace("../HTML/shop.html");
});

let buttonAddProduct = document.getElementById("button_add_new_product");
buttonAddProduct.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_product.html");
});

let buttonRegister = document.getElementById("signin_button");
buttonRegister.addEventListener("click", function(){
    window.location.replace("../HTML/signin.html");
})