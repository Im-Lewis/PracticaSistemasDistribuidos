let form = document.getElementById("form_new_product");
let titleOutput = document.querySelector("#title_output");
let tagOutput = document.querySelector("#tag_output");
let priceOutput = document.querySelector("#price_output");
let descOutput = document.querySelector("#desc_output");
let imageOutput = document.querySelector("#image_output");

let position = 0;
let aux = 0;
let size = 0;
let listTitles = [];
let listTags = [];
let listPrices = [];
let listDescription = [];

function añadir(){

    let nombreInput = document.getElementById('nameProduct');
    let tagInput = document.getElementById('tagProduct');
    let priceInput = document.getElementById('priceProduct');
    let descripcionInput = document.getElementById('descProduct'); 

    let inputNombre = nombreInput.value;
    let inputTag = tagInput.value;
    let inputPrice = priceInput.value;
    let inputDescripcion = descripcionInput.value;
    /*let inputImagen = form.elements.imageProduct.files[0];*/

    titleOutput.textContent = inputNombre;
    listTitles[position] = inputNombre;

    tagOutput.textContent = inputTag;
    listTags[position] = inputTag;

    priceOutput.textContent = inputPrice;
    listPrices[position] = inputPrice;

    descOutput.textContent = inputDescripcion;
    listDescription[position] = inputDescripcion;
    position = position + 1;
    size = size + 1;
    /*imageOutput.src = URL.createObjectURL(image);*/
}

function boton_izquierda(){
    let nombreInput = document.getElementById('nameProduct');
    let tagInput = document.getElementById('tagProduct');
    let priceInput = document.getElementById('priceProduct');
    let descripcionInput = document.getElementById('descProduct'); 
    aux = aux - 1;
    if (aux < 0){
        aux = size - 1;
    }

    console.log("Izquierda");
    console.log("Posicion actual: ", aux);
    console.log("Nombre: ", nombreInput.value);
    console.log("Etiqueta: ", tagInput.value);
    console.log("Precio: ", priceInput.value);
    console.log("Descripción: ", descripcionInput.value);

    titleOutput.textContent = listTitles[aux];
    tagOutput.textContent = listTags[aux];
    priceOutput.textContent = listPrices[aux];
    descOutput.textContent = listDescription[aux];
}

function boton_derecha(){
    let nombreInput = document.getElementById('nameProduct');
    let tagInput = document.getElementById('tagProduct');
    let priceInput = document.getElementById('priceProduct');
    let descripcionInput = document.getElementById('descProduct'); 
    aux = aux + 1;
    if (aux >= size){
        aux = 0;
    }

    console.log("Derecha");
    console.log("Posicion actual: ", aux);
    console.log("Nombre: ", nombreInput.value);
    console.log("Etiqueta: ", tagInput.value);
    console.log("Precio: ", priceInput.value);
    console.log("Descripción: ", descripcionInput.value);

    titleOutput.textContent = listTitles[aux];
    tagOutput.textContent = listTags[aux];
    priceOutput.textContent = listPrices[aux];
    descOutput.textContent = listDescription[aux];
}