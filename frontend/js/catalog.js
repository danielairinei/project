$(document).ready(function () {
    var productsPerPage = 9; // Number of products to display per page
    var currentPage = 1; // Current page number

    // Make a GET request to retrieve the product list from the server
    $.ajax({
        url: 'http://localhost:8080/getProducts',
        type: 'GET',
        success: function (products) {
            var productList = $('#product-list');
            var totalProducts = products.length;
            var totalPages = Math.ceil(totalProducts / productsPerPage);

            // Function to display products based on the current page
            function displayProducts() {
                // Clear the product list
                productList.empty();

                // Calculate the start and end index of the products to display
                var startIndex = (currentPage - 1) * productsPerPage;
                var endIndex = startIndex + productsPerPage;

                // Select the subset of products based on the current page
                var productsToDisplay = products.slice(startIndex, endIndex);

                // Iterate over the products and create the product cards dynamically
                productsToDisplay.forEach(function (product) {
                    var card = $('<div class="col-md-4">' +
                        '<div class="product-card">' +
                        '<div class="row">' +
                        '<div class="col-md-6">' +
                        '<img src="' + product.photoUrl + '" alt="' + product.name + '" class="zoom-image">' +
                        '</div>' +
                        '<div class="col-md-6">' +
                        '<h4>' + product.name + '</h4>' +
                        '<p>Price: $' + product.price + '</p>' +
                        '</div>' +
                        '</div>' +
                        '<div class="row">' +
                        '<div class="col-md-6">' +
                        '<a class="btn btn-secondary" href="product.html">View Details</a>' +
                        '</div>' +
                        '<div class="col-md-6 text-right">' +
                        '<a class="btn btn-secondary" href="checkout.html?id=' + product.id + '">Buy Now</a>' +                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>');

                    // Add the card to the product list
                    productList.append(card);
                });
            }

            // Initial display of products
            displayProducts();

            // Function to handle the pager navigation
            function navigateToPage(page) {
                currentPage = page;
                displayProducts();
            }

            // Add pager buttons dynamically
            var pager = $('#pager');
            for (var i = 1; i <= totalPages; i++) {
                var button = $('<button type="button" class="btn btn-secondary">' + i + '</button>');
                button.click((function (page) {
                    return function () {
                        navigateToPage(page);
                    };
                })(i));
                pager.append(button);
            }
        },
        error: function (xhr, status, error) {
            console.log('Error retrieving products:', error);
        }
    });
});
