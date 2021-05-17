## Funcionamiento
**Autenticacion**
La autenticacion funciona con Basic Auth. Existe un usuario con username `ignacio` y contraseña `password`.
**Postman**
Se adjunta el archivo `final_challenge.postman_collection.json` con una coleccion de postman con todos los endpoints necesarios.

## Parts controller
**POST - Create new part**
	api/v1/parts/
```
{
  "description": "Estereo Ford Fiesta base",
  "stock": 18,
  "partCode": "00000004",
  "providerId": 1,
  "netWeight": 12,
  "longDimension": 10,
  "widthDimension": 9,
  "talDimension": 4,
  "lastModification": "2021-05-12",
  "discountTypeId": 1,
  "normalPrice": 16000,
  "urgentPrice": 23000
}
```

**PATCH - Update stock**

	api/v1/parts?partCode=00000001&quantity=32
	*Query string parameters:*
 - partCode: string
 - quantity: integer
 
 **GET - Parts list**

	/api/v1/parts/list?queryType=P&date=1996-01-21&order=1
	*Query string parameters:*
 - queryType: string
 - date: YYYY-MM-DD (**not required**)
 - order: integer (**not required**)

## Orders Controller

**POST - Generate new order**

	api/v1/parts/orders/
```
{
  "centralHouseId": 1,
  "consessionarieId": 1,
  "shippingType": "Mercado Envios",
  "parts": [
    {
      "partCode": "00000002",
      "description": "Paragolpes de Fiat 147",
      "quantity": 2,
      "accountType": "Repuestos",
      "reason": "I hit a tree at 40mph. Car's good though"
    }
  ]
}
```
  **GET - Fetch order**

​/api​/v1​/parts​/orders​/{orderId}
	*Query string parameters:*
 - orderId: integer 
*Note: orderId is composed by the dealer number(D), the central house number(C), and the order code(O). It must respect the following format: *
DDDD-CCCC-OOOOOOOO
*Should any number have less than four digits, it must be completed with zeros. E.G: 0001-0001-00000025*

**GET - List all orders**

/api/v1/parts/orders/list?dealerNumber=1&deliveryStatus=D&order=0
	*Query string parameters:*
 - dealerNumber: integer
 - deliveryStatus: string (**not required**)
 - order: integer (**not required**)

**PATCH - Update order status**

/api/v1/parts/orders/update_status?orderStatus=D&orderNumberCM=25
	*Query string parameters:*
 - orderStatus: string
 - orderNumberCM: integer



## Users Controller

**POST - Create new user - Requires admin role**

api/v1/users/new/
*x-www-form-encoded parameters:*
- username: string
- password: string

**PATCH - Update user role - Requires admin role**

_Switches between admin and regular roles_

/api/v1/users/changeRole
*Query string parameters:*
- username: string

## Requerimiento 6
**POST - Create new concessionarie**

api/v1/concessionaries
*x-www-form-encoded parameters:*
- centralHouseId: int
```
{
    "name": "Name",
    "phone": "123123123",
    "address": "Address",
    "country": "Uruguay"
}
```

**GET - List concessionaries for a central house**

api/v1/concessionaries
*x-www-form-encoded parameters:*
- centralHouseId: int

**DELETE - Delete concessionarie**

api/v1/concessionaries/{concessionarieId}

**PATCH - Update concessionarie**

api/v1/concessionaries
*x-www-form-encoded parameters:*
- centralHouseId: int
```
{
    "id": 9,
    "name": "Name",
    "phone": "123123123",
    "address": "Address",
    "country": "Uruguay"
}
```




