function mostrarOcultarRespuesta1() {
    var texto = document.getElementById("text_answer1");
    if (texto.style.display === "none") {
      texto.style.display = "block";
    } else {
      texto.style.display = "none";
    }
  }
function mostrarOcultarRespuesta2() {
    var texto = document.getElementById("text_answer2");
    if (texto.style.display === "none") {
        texto.style.display = "block";
    } else {
        texto.style.display = "none";
    }
}
function mostrarOcultarRespuesta3() {
    var texto = document.getElementById("text_answer3");
    if (texto.style.display === "none") {
        texto.style.display = "block";
    } else {
        texto.style.display = "none";
    }
}
function mostrarOcultarRespuesta4() {
    var texto = document.getElementById("text_answer4");
    if (texto.style.display === "none") {
        texto.style.display = "block";
    } else {
        texto.style.display = "none";
    }
}

/* Rich text of the form */
let defaultWeight = 16;
let inputUrl = document.getElementById('inputComment');

let stateBold = 0;
let stateUnderline = 0;
let stateCursive = 0;
let stateCrossOut = 0;

function decreaseFont(){
    if (defaultWeight-1 > 4){
        defaultWeight = defaultWeight - 1;
        inputUrl.style.fontSize = defaultWeight + "px";
    }
}

function increaseFont(){
    if (defaultWeight+1 < 30){
        defaultWeight = defaultWeight + 1;
        inputUrl.style.fontSize = defaultWeight + "px";
    }
}

function setBold(){
    if (stateBold == 0){
        inputUrl.style.fontWeight = "bold";
        stateBold = 1;
    }
    else{
        inputUrl.style.fontWeight = "";
        stateBold = 0;
    }
}

function setUnderline(){
    if (stateUnderline == 0){
        inputUrl.style.textDecoration = "underline";
        stateUnderline = 1;
    }
    else{
        inputUrl.style.textDecoration = "none";
        stateUnderline = 0;
    }
}

function setCursive(){
    if (stateCursive == 0){
        inputUrl.style.fontStyle = "italic";
        stateCursive = 1;
    }
    else{
        inputUrl.style.fontStyle = "";
        stateCursive = 0;
    }
}

function crossOutFont(){
    if (stateCrossOut === 0){
        inputUrl.style.textDecoration = "line-through";
        stateCrossOut = 1;
    }
    else{
        inputUrl.style.textDecoration = "";
        stateCrossOut = 0;
    }
}

/* Function that remove the message*/
function removeWarning(){
    let conteinerWarning = document.getElementById('warning_message');
    conteinerWarning.style.display = 'none';

}
/* Function that add the message and check if all the input text are ok*/
function addWarningMessage(){
    let nameInputText = document.getElementById('inputName');
    let emailInputText = document.getElementById('inputEmail');
    let commentInputText = document.getElementById('inputComment');

    let email = emailInputText.value;
    let arrayEmail = email.split("@");

    if (!containOnlyLetters(nameInputText.value)){
        let message = document.getElementById('alert_container');
        message.innerHTML = '<div class="alert alert-danger d-flex align-items-center alert_container" role="alert"><svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg><div>Error al introducir el nombre. Es posible que no hayas introducido texto o hayas introducido un carácter que no es correcto.</div></div>';
    }
    else if (arrayEmail.length != 2 || arrayEmail[1] != "gmail.com"){
        let message = document.getElementById('alert_container');
        message.innerHTML = '<div class="alert alert-danger d-flex align-items-center alert_container" role="alert"><svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg><div>Error al introducir el correo electrónico. El formato del correo debe ser el siguiente: "correo@gmail.com" donde "correo" puede variar.</div></div>';
    }
    else{
        let message = document.getElementById('alert_container');
        message.innerHTML = '<div class="alert alert-success d-flex align-items-center alert_container" role="alert"><svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg><div>Solicitud enviada correctamente a nuestro equipo de trabajo. Pronto recibirás respuesta. ¡Gracias!</div></div>';
    }
}
function containOnlyLetters(str) {
    return /^[a-zA-Z]+$/.test(str);
}