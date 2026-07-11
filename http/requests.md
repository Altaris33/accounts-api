
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
GET http://localhost:8080/api/fetch?mobileNumber=4354456778
Accept: application/json
```

## Update Account Details

```http
PUT http://localhost:8080/api/update
Content-Type: application/json

{
    "name": "Captain Falcon New Account",
    "email": "captain-new@fzero.com",
    "mobileNumber": "4354456778",
    "accountDto": {
        "accountNumber": 227924,
        "accountType": "Savings",
        "branchAddress": "123 Main Street, New York"
    }
}
```

## Delete Account & Customer

```http
DELETE http://localhost:8080/api/delete?mobileNumber=4354456778
Content-Type: application/json
```