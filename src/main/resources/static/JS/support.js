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
function removeWarning(){
    let conteinerWarning = document.getElementById('warning_message');
    conteinerWarning.style.display = 'none';

}
function addWarningMessage(){
    document.getElementById('warning_message').style.visibility = "visible";
}