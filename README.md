
# TestJava2020 Zara
Description: Create a web service with an endpoint for finding the price of a product from a brand at a specific point in time.


## About Solution
Details:
- Manage Timezone: set default time zone UTC.
- Add two key entities I think would fit in this kind of application, one is Brand, and the other is the Product itself. Only with fields that I'm going to use in this exercise.


## API Reference

#### Get Find price

```http
  GET /zaratest/price/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `product_id` | `Long` | **Required**. Product Id|
| `brand_id` | `Long` | **Required**. Brand Id|
| `application_date` | `String Date Time` | **Required**. Date Time current price. Format: yyyy-MM-dd'T'HH:mm:ss |


## Example deployed API
Base endpoint: https://testzaraapp.onrender.com/zaratest/price/

**GET**
```cURL
curl --location --request GET 'https://testzaraapp.onrender.com/zaratest/price/' \
--header 'Content-Type: application/json' \
--data '{
    "product_id": 35455,
    "brand_id": 1,
    "application_date": "2020-06-14T16:00:00"
}'
```

## Guide

[Guide](https://github.com/JuanFarizo/zaratest/blob/main/guide.txt)

## Tech Stack
**Server:** Spring, Spring Boot

**DB:** H2 In Memory database
