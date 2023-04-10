function filtrar(){
    let tags = document.getElementsByClassName('tag'); // Array which contains all the tags.
    let prices = document.getElementsByClassName('tag_price'); // Array which contains all the prices.
    let products = document.getElementsByClassName("product"); // Array which contains all the products.
    let select = document.getElementById('filter_type_product'); // Array which contains all the tags.
    let opciones = select.querySelectorAll('option'); // Array which contains all the content of the type of product box.
    let textSelected = opciones[select.selectedIndex].textContent; // The content of the type of product that is shown first.
    let numberMin = document.getElementById('input_numberMin');
    let numberMax = document.getElementById('input_numberMax');

    
    for(let i=0; i<tags.length; i++){
        let textTag = tags[i].textContent; // The String of the tag
        let textPrice = prices[i].textContent; // The String of the price
        let price = textPrice.split(" $"); // The content of the price, that is a String, we have to separate it into two strings since it has the $ symbol at the end
        let priceRounded = parseInt(price);
        if ((priceRounded < numberMin.value) || (priceRounded > numberMax.value)){ // Comparing the range
            products[i].style.display = 'none';
        }
        if (textTag != textSelected){
            products[i].style.display = 'none';
        }
    }
}
// Navegation buttons
let button = document.getElementById("support_button");
button.addEventListener("click", function(){
    window.location.replace("../HTML/support.html");
});