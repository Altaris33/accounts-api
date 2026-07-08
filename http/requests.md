
## Create Accounts

* /api/create
* createAccount
```http
POST http://localhost:8080/api/create
Content-Type: application/json

{
  "name": "Captain Falcon",
  "email": "captain@fzero.com",
  "mobileNumber": "4354456778"
} 
```

## Get all accounts

```http
GET http://localhost:8080/api/accounts
Accept: application/json
```
