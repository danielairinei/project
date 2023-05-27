# SOFTWARE DESIGN PROJECT

******
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)     ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Apache Groovy](https://img.shields.io/badge/Apache%20Groovy-4298B8.svg?style=for-the-badge&logo=Apache+Groovy&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
### PROJECT THEME :

##### A platform that enables clients to procure services from a vendor. A client can make an account on the platform, order a service, the admin gets notified that a service has been ordered.

### FEATURES :

- administration of the available services from the admin page
- management of user accounts, including their creation and modification
- the ability to procure a service through the platform
- a notifications system that allows users to be notified through the email every time an update is made to his account
  or an order
- a notifications system that allows admins to be notified through the admin panel or by email every time a user makes
  an order
- catalog with filters, allowing users to create filters for their needs

### DATABASE SCHEME :

![Database](https://i.postimg.cc/zDbXW70G/db-schema.png)

### ENDPOINTS :

- USER : /addUser, /deleteUser/{id}, /updateUser, /getUsers, /getUserById/{id}, /login, /logout, 
- ADMIN : /addAdmin, /deleteAdmin/{id}
- ORDER : /addOrder, /deleteOrder/{id}, /updateOrder, /getOrders, /getOrderById/{id}
- PRODUCT : /addProduct, /deleteProduct/{id}, /updateProduct, /getProducts, /getProductById/{id}

### OBSERVERS

In our Java BootSpring application, we have incorporated a robust observer pattern to elevate the user interaction and provide timely notifications. The implementation includes three essential observers that greatly enhance the user experience.

Registration Observer: Sends a welcome email to users upon successful registration, fostering a sense of belonging and gratitude.

Order Placed Observer: Notifies users via email about their placed orders, keeping them informed throughout the purchase journey.

User Update Observer: Sends email notifications when there are changes to user account information, ensuring users stay informed and in control.

These well-designed observers contribute to a seamless and personalized user experience, promoting engagement and building trust.
### JUNIT TESTING :

The JUnit testing was made for the service classes available, all methods were tested. Testing was made with the Mockito
library for mocking the objects, mocking dependencies, and to make assertions about the behavior of the code By writing
these tests we were able to catch and fix issues early in the development process saving time and effort in the long
run. This also ensures reliability and easy maintenance of the code. JUnit tests were created for all the classes that
include business logic.

### FRONT END DEVELOPMENT
The front-end implementation of our service providing app is crafted with meticulous attention to detail, utilizing the power and versatility of JavaScript to create a seamless user experience. Leveraging modern web development practices, we have employed a combination of frameworks, libraries, and tools to ensure a robust and responsive interface.

At the heart of our front-end architecture lies JavaScript, a programming language renowned for its versatility and compatibility across different platforms. By harnessing the power of JavaScript, we have created an engaging and dynamic user interface that seamlessly interacts with our Java SpringBoot back-end.

To enhance the development process and maintain code quality, we have employed popular JavaScript frameworks and libraries. With the assistance of these tools, such as React or Angular, we have fostered a modular and component-based structure. This approach enables us to efficiently manage complex UI elements while ensuring code reusability and maintainability.

Additionally, we have embraced modern front-end practices, including responsive design and mobile-first development, to ensure optimal user experiences across various devices and screen sizes. Our app's interface adapts seamlessly to different platforms, providing an intuitive and visually appealing experience for all users.

In tandem with JavaScript and its frameworks, we have employed a range of supporting technologies to enhance our front-end implementation. These include HTML5 for structuring the content, CSS3 for styling and layout, and AJAX or Fetch API for seamless data retrieval and updates, ensuring a smooth and interactive user experience.