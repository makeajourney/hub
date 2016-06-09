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

function checkPassword() {
	var password1 = document.getElementById('password-form')
	var password2 = document.getElementById('password-form2')
	if (password2.value != "") {
		if (password1.value == password2.value) {
			return true; 
		} else {
			alert('Passwords are not equal. Please retry.');
			password1 = "";
			password2 = "";
			return false;
		}
	}
	
}