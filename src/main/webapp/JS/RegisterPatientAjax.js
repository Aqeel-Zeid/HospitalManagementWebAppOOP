//addAllergy


$(document).ready(function() {


    $('#addAllergy').click
    ( function () {

            console.log("Hii");
            var myElement = $("<div id = \"AllergyDiv\">" +
                "                <label>Allergy</label><input type=\"text\" name=\"AllergyName\"><br>" +
                "                <label>Description</label><input type=\"text\" name=\"AllergyDescription\"><br>" +
                "                </div>   ");
            $("#AjaxResponse").append(myElement);



    });





});