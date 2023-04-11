/*-------------------------------------------------------------------------------------------------------------------*/
let buttonSup = document.getElementById('support_button');
let buttonShop = document.getElementById('shop_button');
let buttonLogin = document.getElementById("log_in_button");
let buttonSignin = document.getElementById("sign_in_button");
let buttonTournaments = document.getElementById("tournaments_button");
let buttonMultimedia = document.getElementById("multimedia_button");
let buttonHome = document.getElementById("home_button");
let buttonGoBack = document.getElementById("go_back_btn");
let buttonAddProduct = document.getElementById("button_add_new_product");

/*-------------------------------------------------------------------------------------------------------------------*/
buttonShop.addEventListener("click", function(){
    window.location.replace('../shop');
});
/*-------------------------------------------------------------------------------------------------------------------*/
buttonSup.addEventListener("click", function(){
    window.location.replace("../HTML/support.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonLogin.addEventListener("click", function(){
    window.location.replace("../HTML/login.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/

buttonSignin.addEventListener("click", function(){
    window.location.replace("../HTML/signin.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonTournaments.addEventListener("click", function(){
    window.location.replace("../view/tournaments");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonMultimedia.addEventListener("click", function(){
    window.location.replace("../HTML/multimedia.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonHome.addEventListener("click", function(){
    window.location.replace("../index.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonGoBack.addEventListener("click", function(){
    window.location.replace("../view/tournaments");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonSup.addEventListener("click", function() {
    window.location.replace("../HTML/support.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonAddProduct.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_product.html");
});


