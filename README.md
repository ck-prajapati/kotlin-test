#Instructions:-

The project is based on a small Kotlin program to simulate the retail discounts which uses the following technologies:

###Tech Stack:
```
Spring Boot 2.6.2
Java 1.8
Kotlin 1.6.10
JUnit for Unit Tests
```

Build the Application Jar:
```mvn clean install```

Test Case Result:

`Tests run: 17, Failures: 0, Errors: 0, Skipped: 0`


- For run the apis at the swagger 
[http://localhost:8080/swagger-ui/index.html]()

Endpoints with request body json , example as below:-

- **Users API:** [http://localhost:8080/swagger-ui/index.html#/users-controller]()

- **Items API:** [http://localhost:8080/swagger-ui/index.html#/items-controller]()

- **Discount Calculate API**: [http://localhost:8080/swagger-ui/index.html#/retail-store-discounts-controller]()

Information for discount policy:-
• RetailStoreDiscountsService contains item types and user types and based on that it applied discount policy if applicable.
• StoreEmployeeDiscountService contains discount policy for employee of the store
• AffiliateDiscountService contains discount policy for affiliate of the store
• OldCustomerDiscountService contains discount policy for customer over two years
• HundredBillDiscountService contains discount policy for normal customer