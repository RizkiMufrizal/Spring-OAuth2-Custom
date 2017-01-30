# Spring-OAuth2-Custom

## Cara Menjalankan :

* jalankan database mongodb
* database h2 berfungsi untuk menyimpan data - data client id dan client secret
* kemudian jalankan aplikasi dengan perintah `mvn clean spring-boot:run`

## Flow Client Credentials

* Untuk mendapatkan access token, kita perlu menukarkan client id dan client secrent dengan perintah

```
curl -X POST -vu fooClientIdPassword:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "client_id=fooClientIdPassword&grant_type=client_credentials"
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
curl -X POST -vu fooClientIdPassword:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "password=admin&username=admin&grant_type=password&client_secret=secret&client_id=fooClientIdPassword"
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

## Teknologi

* Spring Boot
* Spring Data MongoDB
* Spring JDBC
* Spring Security
* Spring OAuth2
* HikariCP