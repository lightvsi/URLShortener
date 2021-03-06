# URLShortener
URLShortener - REST API сервис, предназначенный для сокращения URL.
Принимает на вход JSON объект с полем "url" и опциональным полем "name".

## How to build and run
```shell script
./mvnw clean install
docker-compose up —build
```

## Rest Example
Получить короткую ссылку.
```http request
POST http://localhost:8080/add
Content-Type: application/json

{
  "url": "https://www.google.ru/"
}
```

```json
{
  "url": "http://localhost:8080/zegcneB"
}
```
Получить короткую ссылку, выбранную пользователем.
```http request
POST http://localhost:8080/add
Content-Type: application/json

{
  "url": "https://www.google.ru/",
  "name":"readable-link"
}
```

```json
{
  "url": "http://localhost:8080/readable-link"
}
```
Редирект на страницу.
```http request
GET http://localhost:8080/readable-link
```
