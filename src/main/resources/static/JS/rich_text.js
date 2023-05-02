let defaultWeight = 16;
let inputUrl = document.getElementById('descProduct');

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