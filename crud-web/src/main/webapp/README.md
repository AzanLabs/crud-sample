# crud-sample

Priest Modal :

(
	"id":"1001",
	"firstName":"sankar",
	"lastName":"Nar..",
	"gender":"M",
	"qualification":"...",
	"currentChurch":"coop",
	"experience":"...",
	"emailId":"xxx@yyy.com",
	"phoneNo":123456789,
	"about":"..........................."
)

EndPoints:

Method					URl							params					Returns						Explanation
---------------------------------------------------------------------------------------------------------
GET			./crud/rest/priest/all				nil							List of Priests				get all priests

POST		./crud/rest/priest/create			Priest Modal				saved Priest modal with 	create the priest
												without id(json format)		id  (json format)

UPDATE		./crud/rest/priest/update			priest Modal with id 		updated complete priest		update the priest
												and fields to update		modal in (json format)		
												in (json format)			
												
DELETE		./crud/rest/priest/{priest_id}		nil							deleted priest modal		delete the priest
																			(json format)
--------------------------------------------------------------------------------------------------------------------------

POST		.crud/rest/image/upload				multipart-form data			uploaded file name			upload the priest profile pic
												including file and id of 
												the priest. file input 
												should be named "file"
												and id input should be
												named "id"  		
																							
GET			./crud/rest/image/{priest_id}		nil							image/png					only png files are allowed. 
																										returns image/png file


