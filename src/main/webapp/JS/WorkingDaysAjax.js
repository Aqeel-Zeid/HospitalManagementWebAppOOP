console.log("Hello World")

$(document).ready(function() {
    console.log("Hii");

    $('#dateField').change
    ( function () {
        //console.log( $('#dateField').prop("value"))
        if($("#dateField").prop("value"))
        {
            //$('#AjaxResponse').show();
            $.ajax({
                url: 'WorkingDayAjaxServlet',
                data:
                    {
                        AjaxDate : $("#dateField").prop("value")
                    },
                success: function (responseText)
                {
                    $('#Availabledays').html(responseText);
                    //console.log(responseText);
                }
            })
        }
    });

});