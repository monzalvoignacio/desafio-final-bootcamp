**Aguante fury vieja**

## Parts controller
**POST - Create new part**
	api/v1/parts/
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







