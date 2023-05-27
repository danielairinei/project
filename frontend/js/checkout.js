const urlParams = new URLSearchParams(window.location.search);
const productId = urlParams.get('id');
var price;

// Function to fetch product data by ID and update the product card
function fetchProductById(productId) {
    $.ajax({
        url: `http://localhost:8080/getProductById/${productId}`,
        type: 'GET',
        success: function (product) {
            console.log(product.name);
            // Update the product card with the fetched product data
            price = product.price;
            $('#product-title').text(product.name);
            $('#product-price').text(product.price + '$');
            $('#product-image').attr('src', product.imageUrl);
        },
        error: function (xhr, status, error) {
            console.error('Error:', error);
        }
    });
}

// Call the fetchProductById function with the received product ID
fetchProductById(productId);

document.getElementById("checkoutForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the username and password input values
    var email = document.getElementById("email").value;
    var phoneNumber = document.getElementById("phone").value;

    var orderData = {
        userEmail: email,
        price: price,
        phoneNumber: phoneNumber,
        status: "pending",
        productId: productId
    };

    // Make an AJAX request to the login endpoint
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/createOrder");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function () {
        if (xhr.status === 200) {
            alert("Order submited")
            window.location.href = '/order-success.html';
        } else {
            alert("registration failed");
        }
    };
    xhr.send(JSON.stringify(orderData));
});