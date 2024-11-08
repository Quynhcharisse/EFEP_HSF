let email_field = document.getElementById("contact-email");
let email_error = document.getElementById("email-error");
let password_field = document.getElementById("contact-password");
let password_error = document.getElementById("password-error");

const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>])[A-Za-z\d!@#$%^&*(),.?":{}|<>]{8,16}$/;


function validateEmail() {
    if (!email_field.value.match(emailRegex)) {
        email_error.innerHTML = "Email is invalid";
        return false;
    }

    email_error.innerHTML = "";
    return true;
}

function validatePassword() {
    if (!password_field.value.match(passwordRegex)) {
        password_error.innerHTML = "Password must be 8 to 16 characters, contains at least 1 uppercase letter, 1 special character and 1 number";
        return false;
    }

    password_error.innerHTML = "";
    return true;
}