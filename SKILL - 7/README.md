# Course CRUD API

Spring Boot REST API for managing university courses with complete CRUD operations using `ResponseEntity`.

## Course Fields
- `courseId`
- `title`
- `duration`
- `fee`

## Endpoints
- `POST /courses` - Add course
- `PUT /courses/{courseId}` - Update course
- `DELETE /courses/{courseId}` - Delete course
- `GET /courses` - View all courses
- `GET /courses/{courseId}` - View course by id
- `GET /courses/search/{title}` - Search courses by title

## Status Codes Used
- `201 CREATED`
- `200 OK`
- `404 NOT_FOUND`
- `400 BAD_REQUEST`

## Run
```bash
mvn spring-boot:run
```

## Postman Testing
Import collection:
- `postman/course-crud.postman_collection.json`

The collection includes valid and invalid test cases for all endpoints.
