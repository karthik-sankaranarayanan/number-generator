# number-generator

Write a spring boot application that generates a sequence of numbers in the decreasing order till 0. 
Simulate that the function to generate a  number takes a random time – say between 10 to 30 seconds .
Inputs: step, goal

REST APIs:
* POST- /api/generate -- Inputs: goal and step  -- Response: 202 ACCEPTED { "task": "UUID of the task"}
* GET - /api/tasks/{UUID of the task}/status -- Response: { "result": "SUCCESS/IN_PROGRESS/ERROR" }
* GET - /api/tasks/{Task UUID of the task}?action=get_numlist -- Response: { "result" : "10,8,6,4,2,0" }
* POST - /api/bulkGenerate -- Inputs: array of goal, step -- Response: 202 ACCEPTED { "task: "UUID of the task"}
* GET - /api/tasks/{UUID of the task}?action=get_numlist -- Response: { "results": [ "10, 8, 6, 4, 2, 0", "100, 97, ...." ] }

* a. Documentation is done using SWAGGER UI (localhost:8080/swagger-ui.html should point to the SWAGGER UI)
* b. Deployed into AWS Fargate (built a Docker image and then pushed to Docker Hub. Post that, I used that image in deploying to AWS Fargate as a container in Amazon ECS)
* c. Public IP on AWS fargate: http://18.191.128.45:8080/ (returns the title of the project)
* d. http://18.191.128.45:8080/swagger-ui.html (returns Swagger Doc)
* e. The above 5 REST API calls can be tested using Swagger UI. 
