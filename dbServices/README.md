This project is .

## Building

You need Java (1.8 or higher) and Maven (3.0.5 or higher):

mvn clean install

<app starts and listens on port 9000>

# Setting up:
================
Create default user [user/password] with role "USER" using following endpoint.

		http://localhost:9000/addUser

Create admin user [admin/password] with role "ADMIN" using following endpoint.

		http://localhost:9000/addUser

Access admin section : 
=====================

C:\Users\prajeesh.t>curl -H "Accept: application/json" my-client-with-secret:secret@localhost:9000/oauth/token -d "grant_type=password&client_id=my-client-with-secret&username=admin
&password=admin"
{"access_token":"f7e406ed-a08a-47cb-948c-a57ffa234771","token_type":"bearer","expires_in":43199,"scope":"read"}

C:\Users\prajeesh.t>curl -H "Authorization: Bearer f7e406ed-a08a-47cb-948c-a57ffa234771" localhost:9000/admin/

[{"id":1,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568768000,"updatedAt":1517568768000},{"id":2,"name":" append","createdBy":null,"updatedBy":null,"createdA
t":1517568792000,"updatedAt":1517568915000},{"id":3,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568814000,"updatedAt":1517568814000},{"id":4,"name":" append",
"createdBy":null,"updatedBy":null,"createdAt":1517568845000,"updatedAt":1517568845000},{"id":5,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568855000,"updatedA
t":1517568855000},{"id":6,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568873000,"updatedAt":1517568873000},{"id":7,"name":" append","createdBy":null,"updatedB
y":null,"createdAt":1517569971000,"updatedAt":1517569971000},{"id":8,"name":" append","createdBy":"user","updatedBy":"user","createdAt":1517571222000,"updatedAt":1517571222000}]

Access User section : 
=====================

C:\Users\prajeesh.t>curl -H "Accept: application/json" my-client-with-secret:secret@localhost:9000/oauth/token -d "grant_type=password&client_id=my-client-with-secret&username=min&p
assword=min"
{"access_token":"3d1876e1-bbb8-49fe-8a0a-4ccebe1f8d80","token_type":"bearer","expires_in":43199,"scope":"read"}

C:\Users\prajeesh.t>curl -H "Authorization: Bearer 3d1876e1-bbb8-49fe-8a0a-4ccebe1f8d80" localhost:9000/db/

[{"id":1,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568768000,"updatedAt":1517568768000},{"id":2,"name":" append","createdBy":null,"updatedBy":null,"createdA
t":1517568792000,"updatedAt":1517568915000},{"id":3,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568814000,"updatedAt":1517568814000},{"id":4,"name":" append",
"createdBy":null,"updatedBy":null,"createdAt":1517568845000,"updatedAt":1517568845000},{"id":5,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568855000,"updatedA
t":1517568855000},{"id":6,"name":" append","createdBy":null,"updatedBy":null,"createdAt":1517568873000,"updatedAt":1517568873000},{"id":7,"name":" append","createdBy":null,"updatedB
y":null,"createdAt":1517569971000,"updatedAt":1517569971000},{"id":8,"name":" append","createdBy":"user","updatedBy":"user","createdAt":1517571222000,"updatedAt":1517571222000}]
C:\Users\prajeesh.t>

```
