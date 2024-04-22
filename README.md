
# documentação da api: 
[https://wesley-sds2.herokuapp.com/swagger-ui.html](https://ds-deliver-backend-4b04bda63579.herokuapp.com/swagger-ui.html)

![image](https://user-images.githubusercontent.com/59511225/132137826-9caea7e5-990f-4b01-8be7-377811c14dce.png)

# Diagrama de classes
```mermaid
classDiagram
    class Order {
        -String address
        -int id
        -double latitude
        -double longitude
        -Moment moment
        -List<Product> products
        -String status
    }
    class Moment {
        -long epochSecond
        -int nano
    }
    class Product {
        -String description
        -int id
        -String imageUri
        -String name
        -double price
    }

    Order "1" *-- "1" Moment
    Order "1" *-- "*" Product
```



app: https://dsdelivery-wes.netlify.app/

