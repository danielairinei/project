document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the username and password input values
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Make an AJAX request to the login endpoint
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/login");
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onload = function () {
        if (xhr.status === 200) {
            if (xhr.responseText === "success") {// Show the login result
                var userOptions = $('<li class="nav-item dropdown">' +
                    '<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">User Options</a>' +
                    '<div class="dropdown-menu" aria-labelledby="userDropdown">' +
                    '<a class="dropdown-item" href="#">Profile</a>' +
                    '<a class="dropdown-item" href="#">Settings</a>' +
                    '<div class="dropdown-divider"></div>' +
                    '<a class="dropdown-item" href="#">Logout</a>' +
                    '</div>' +
                    '</li>');

                $('#userOptions').append(userOptions);
                window.location.href = "/index.html";
            } else {
                alert(xhr.responseText);
            }
        } else {
            alert("Login failed");
        }
    };
    xhr.send("email=" + encodeURIComponent(email) + "&password=" + encodeURIComponent(password));
});

// $(document).ready(function () {
//     var loggedIn = false; // Initial value
//     // Handle the login form submission
//     $('#login-form').on('submit', function (event) {
//         event.preventDefault();

//         // Get the username and password from the form
//         var username = $('#username').val();
//         var password = $('#password').val();

//         // Make a POST request to the login API endpoint
//         $.ajax({
//             url: 'http://localhost:8080/login',
//             type: 'POST',
//             data: {
//                 username: username,
//                 password: password
//             },
//             success: function (response) {
//                 console.log("sal");
//                 // Update the loggedIn variable based on the response
//                 if (response) {
//                     loggedIn = true;
//                     // Hide the login form or perform any other necessary actions
//                     $('#login-form').hide();

//                     // Add the user options dropdown

//                 } else {
//                     // Handle unsuccessful login
//                     console.log('Login failed');
//                 }
//             },
//             error: function (xhr, status, error) {
//                 // Handle error
//                 console.log('Error:', error);
//             }
//         });
//     });
// });
