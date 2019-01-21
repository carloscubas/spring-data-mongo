# spring-data-mongo
Spring data mongo example

## Create
```
Post: localhost:8080/create
{
	"name" : "Bruno darcolito",
	"position" : "tecnical leader",
	"salary" : 125.0
}
```

## Update
```
Put: localhost:8080/update/<id>
{
	"name" : "bruno darcolito da silva",
	"position" : "techinical leader",
	"salary" : 15.0
}
```

## Bring summary values
```
Get: localhost:8080/summary
```

## Get employee by id
```
Get: localhost:8080/<id>
```

## Get list of employees
```
Get: localhost:8080/
```