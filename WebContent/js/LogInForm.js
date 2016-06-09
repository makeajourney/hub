"use strict";
$(document).ready(function(){
    $(".toggle-button").click(function() {
        if ($(".toggle-button")[0].innerHTML === "Sign UP") {
            $(".toggle-button")[0].innerHTML = "Log IN";
            $("#password-form2").css("display", "inline-block");
            $("#sign-button")[0].value = "SIGNUP";
        } else {
            $(".toggle-button")[0].innerHTML = "Sign UP";
            $("#password-form2").css("display", "");
            $("#password-form2")[0].value = "";
            $("#sign-button")[0].value = "LOGIN";
        }
    });
});