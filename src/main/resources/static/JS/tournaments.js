/*-------------------------------------------------------------------------------------------------------------------*/
let buttonCreateTournament = document.getElementById('create_tournament_btn');
let buttonDeleteTournament = document.getElementById('delete_tournament_button');
let buttonGoBackOrganizer = document.getElementById('go_back_btn_organizer');
let buttonGoBackUser = document.getElementById('go_back_btn_user');
let buttonCreateOrganizer = document.getElementById('create_organizer_btn');
let buttonCreateUser = document.getElementById('create_user_btn');

/*-------------------------------------------------------------------------------------------------------------------*/
buttonCreateTournament.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_tournaments.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonDeleteTournament.addEventListener("click", function(){
    window.location.replace("../delete/{id}");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonGoBackOrganizer.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_organizer.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonGoBackUser.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_user.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonCreateOrganizer.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_organizer.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/
buttonCreateUser.addEventListener("click", function(){
    window.location.replace("../HTML/add_new_user.html");
});

/*-------------------------------------------------------------------------------------------------------------------*/




