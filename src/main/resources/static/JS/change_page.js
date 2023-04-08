/*-------------------------------------------------------------------------------------------------------------------*/
let buttonTournaments = document.getElementById("tournaments_button");
buttonTournaments.addEventListener("click", function(){
    window.location.replace("../HTML/tournaments.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
let buttonMultimedia = document.getElementById("multimedia_button");
buttonMultimedia.addEventListener("click", function(){
    window.location.replace("../HTML/multimedia.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
let buttonHome = document.getElementById("home_button");
buttonHome.addEventListener("click", function(){
    window.location.replace("../index.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/


let buttonSup = document.getElementById("support_button");
buttonSup.addEventListener("click", function(){
    window.location.replace("../HTML/support.html");
});

buttonSup.addEventListener("click", function() {
    setTimeout(function() {
    window.location.replace("../HTML/support.html");
    }, 3000); // El número 3000 representa el tiempo en milisegundos (3 segundos)
});
let buttonLogin = document.getElementsByName("login_button");
buttonLogin.addEventListener("click", function(){
    window.location.replace("../HTML/login.html");
});
/*buttonSup.addEventListener("click", function(){
    setTimeout(function() {
        window.location.replace("../HTML/support.html");
    }, 3000);
});*/

let buttonShop = document.getElementById("shop_button");
buttonShop.addEventListener("click", function(){
    window.location.replace("../shop");
});

let buttonAddProduct = document.getElementById("button_add_new_product");
buttonAddProduct.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_product.html");
});


/*let buttonRegister = document.getElementById("signin_button");
buttonRegister.addEventListener("click", function(){
    window.location.replace("../HTML/signin.html");
});

let buttonLogIn = document.getElementById("login_button");
buttonLogIn,addEventListener("click", function(){
    this.window.location.replace("../HTML/login.html");
})*/

