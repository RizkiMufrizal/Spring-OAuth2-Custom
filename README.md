# Spring-OAuth2-Custom

## Cara Menjalankan :

* jalankan database mariadb
* jalankan redis
* kemudian jalankan aplikasi dengan perintah `mvn clean spring-boot:run`

## Flow Client Credentials

* Untuk mendapatkan access token, kita perlu menukarkan client id dan client secrent dengan perintah

```
curl -X POST -vu clientid:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "client_id=clientid&grant_type=client_credentials"
```

Jika berhasil maka akan muncul access token seperti berikut.

```
{
  "access_token" : "e072898c-e2d9-46d7-80de-bb6c2b8af645",
  "token_type" : "bearer",
  "expires_in" : 3596,
  "scope" : "foo read write"
}
```

## Flow Password

* untuk flow ini kita menggunakan username, password, client id dan client secret untuk mendapatkan access token dan refresh token

```
curl -X POST -vu clientid:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=admin&username=admin&grant_type=password&client_secret=secret&client_id=clientid"
```

Jika berhasil maka akan muncul access token dan refresh seperti berikut.

```
{
  "access_token" : "94b523b7-28c5-4e35-96d5-8261feccfeac",
  "token_type" : "bearer",
  "refresh_token" : "4ccb6a67-8c68-47fe-b010-77dde913a20d",
  "expires_in" : 3599,
  "scope" : "foo read write"
}
```

## Cara Akses API

```
curl "http://localhost:8080/api/bukus" \
  -H "Authorization: Bearer <client_id>:<access_token>" \
  -H "Content-Type: application/json"
```

Contohnya

```
curl "http://localhost:8080/api/bukus" \
  -H "Authorization: Bearer clientid:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY3VzdG9tb2F1dGgyIl0sInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE0ODYzOTEyNTUsImp0aSI6IjhkNzA2MjU1LWFhYzctNDI1Zi1iYjQ0LTc3MDJlYjlhYTFlNyIsImNsaWVudF9pZCI6ImNsaWVudGlkIn0.jAJTKoQsOCpXY_TE_0okO76uCQKeadI2b9VL7cFGqYc" \
  -H "Content-Type: application/json"
```

## Teknologi

* Spring Boot
* Spring Data JPA
* Spring Data Redis
* Spring Security
* Spring OAuth2
* Spring JWT
* HikariCP
