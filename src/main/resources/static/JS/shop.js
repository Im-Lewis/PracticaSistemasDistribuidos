function filtrar(){
    let tags = document.getElementsByClassName('tag');
    let products = document.getElementsByClassName("product");
    let select = document.getElementById('filter_type_product');
    let opciones = select.querySelectorAll('option');
    let textSelected = opciones[select.selectedIndex].textContent;
    
    for(let i=0; i<tags.length; i++){
        let textTag = tags[i].textContent;
        if (textTag != textSelected){
            products[i].style.display = 'none';
        }
        console.log(textTag);
    }
}
// Navegation buttons
let button = document.getElementById("support_button");
button.addEventListener("click", function(){
    window.location.replace("../HTML/support.html");
});