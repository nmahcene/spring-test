
#Some validation and refactoring are necessary, it is just to demonstrate the  flow 
#Sum bugs, not all scenario are tested



Tests :



@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
curl http://localhost:8081/users?companieId=111&permission=EMPLOYEE&state=true 



@PostMapping(value = "/addUser/{companyId}" , produces = MediaType.APPLICATION_JSON_VALUE )

Tested with Postman :  

{
	"name" : "userWrapper",
	"user" : {
		"type" : "admin",
        "name": "Noureddine",
        "active": "false",
        "birthday": null,
        "permission": "ADMIN"
	}
}


curl --header "Content-Type: application/json" --request POST --data '{"name" : "userWrapper",	"user" : {"type" : "admin","name": "Noureddine","active": "false","birthday": null,"permission": "ADMIN"}}'  http://localhost:8081/addUser/111