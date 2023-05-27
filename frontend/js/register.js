document.getElementById("registerForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the username and password input values
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var userData = {
        email: email,
        username: username,
        password: password
    };

    // Make an AJAX request to the login endpoint
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/addUser");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function () {
        if (xhr.status === 200) {
            alert("account created")
        } else {
            alert("registration failed");
        }
    };
    xhr.send(JSON.stringify(userData));
});