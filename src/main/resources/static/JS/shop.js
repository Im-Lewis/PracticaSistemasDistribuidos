function filtrar(){
    let tags = document.getElementsByClassName('tag');
    let prices = document.getElementsByClassName('tag_price');
    let products = document.getElementsByClassName("product");
    let select = document.getElementById('filter_type_product');
    let opciones = select.querySelectorAll('option');
    let textSelected = opciones[select.selectedIndex].textContent;
    let numberMin = document.getElementById('input_numberMin');
    let numberMax = document.getElementById('input_numberMax');

    console.log(numberMin.value);
    console.log(numberMax.value);
    
    for(let i=0; i<tags.length; i++){
        let textTag = tags[i].textContent;
        let textPrice = prices[i].textContent;
        if (textTag != textSelected){
            products[i].style.display = 'none';
        }
        if ((textPrice < numberMin) || (textPrice > numberMax)){
            products[i].style.display = 'none';
        }
    }
}
// Navegation buttons
let button = document.getElementById("support_button");
button.addEventListener("click", function(){
    window.location.replace("../HTML/support.html");
});