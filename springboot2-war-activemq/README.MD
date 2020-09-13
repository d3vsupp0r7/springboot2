# springboot2-war-activemq

# String message example
## GET Request
http://localhost:8080/springboot2-war-activemq/api/message/aa

# Object message example
## POST Request
http://localhost:8080/springboot2-war-activemq/obj/message

**Header params:** Content-Type | application/json

**JSON Request Example for POST command**
```json
{"@id":1,"name":"Apple",
	"products":[
		{"@id":1,"name":"Iphone 7","company":1},
		{"@id":2,"name":"IPadPro","company":1}
	]
}
```

# JMS Example
## Active MQ
**ActiveMQ server url:**  
http://localhost:8161/admin/queues.jsp

**Default ActiveMQ uid and pass**
**uid :** admin  
**pass:** admin 

