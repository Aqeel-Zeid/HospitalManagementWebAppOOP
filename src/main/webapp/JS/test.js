console.log("Hello World");


$(document).ready(function() {
    console.log("Hii");

        $('#docField').click
        ( function () {
            if($("#docField").prop("checked", true))
            {
                $('#AjaxResponse').show();
                $.ajax({
                    url: 'SignUpAjax',
                    data:
                        {
                            ajax: "true"
                        },
                    success: function (responseText)
                        {
                             $('#AjaxResponse').html(responseText);
                            console.log(responseText);
                        }
                })
            }
        });

    $('#docField').blur
    (
        function ()
        {
            $('#AjaxResponse').hide();
        }
    )

});

