$(document).ready(function() {
    // Get the product ID from the query string
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var productId = urlParams.get('id');

    // Make a GET request to retrieve the product details from the server
    $.ajax({
        url: 'http://localhost:8080/getProduct?id=' + productId,
        type: 'GET',
        success: function(product) {
            var productDetails = $('#product-details');

            // Create the product card dynamically
            var card = $('<div class="col-md-4">' +
                '<div class="product-card">' +
                '<img src="' + product.photoUrl + '" alt="' + product.name + '" class="zoom-image">' +
                '<h4>' + product.name + '</h4>' +
                '<p>Price: $' + product.price + '</p>' +
                '</div>' +
                '</div>');

            // Add the card to the product details section
            productDetails.append(card);
        },
        error: function(xhr, status, error) {
            console.log('Error retrieving product details:', error);
        }
    });
});
