# Motion Support
Full-stack IT helpdesk web app, built using NextJS, Spring Boot and MongoDB

## Installation
### Front-end

```
npm install
npm run dev
```

### Back-end
+ Open project using IntelliJ IDEA
+ Run src/main/java/com/tonyq/motionbackend/MotionBackendApplication.java
+ API will open on localhost:8080

### Database
+ Install [Docker](https://www.docker.com/)
+ Install [MongoDB Compass](https://www.mongodb.com/products/tools/compass), this tool provides GUI for database interaction
+ Pull the MongoDB Community image
```
docker pull mongodb/mongodb-community-server
```
+ Open Docker, run the MongoDB container at port 27017