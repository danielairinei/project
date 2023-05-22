$(document).ready(function() {
    // Make a GET request to retrieve the product list from the server
    $.ajax({
        url: '/getProducts',
        type: 'GET',
        success: function(products) {
            var productList = $('#product-list');

            // Iterate over the products and create the product cards dynamically
            products.forEach(function(product) {
                var card = $('<div class="col-md-4">' +
                    '<div class="product-card">' +
                    '<img src="' + product.photoUrl + '" alt="' + product.name + '">' +
                    '<h4>' + product.name + '</h4>' +
                    '<p>Price: $' + product.price + '</p>' +
                    '<a class="btn btn-secondary" href="#">View Details</a>' +
                    '</div>' +
                    '</div>');

                productList.append(card);
            });
        },
        error: function(xhr, status, error) {
            console.log('Error retrieving products:', error);
        }
    });
});
