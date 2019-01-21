# spring-data-mongo
Spring data mongo example

##Create
__Post__
```
localhost:8080/create

{
	"name" : "Bruno darcolito",
	"position" : "tecnical leader",
	"salary" : 125.0
}
```

##Update
__Put__
```
localhost:8080/update/<id>

{
	"name" : "bruno darcolito da silva",
	"position" : "techinical leader",
	"salary" : 15.0
}
```

##Bring values summary
__Get__
```
localhost:8080/summary
```

##Get employee by id
__Get__
```
localhost:8080/<id>
```

##Get list of employees

__Get__
```
localhost:8080/
```