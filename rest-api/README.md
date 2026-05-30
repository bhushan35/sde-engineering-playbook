# REST API

This section covers RESTful API design, implementation, security, versioning, and best practices commonly asked in backend interviews.

## Topics

### REST Fundamentals
- What is REST?
- REST Constraints
- Resource-Oriented Design
- Stateless Communication
- Client-Server Architecture

### HTTP Methods
- GET
- POST
- PUT
- PATCH
- DELETE
- OPTIONS
- HEAD

### HTTP Status Codes
- 2xx Success
- 3xx Redirection
- 4xx Client Errors
- 5xx Server Errors

### Request & Response Design
- Request Headers
- Query Parameters
- Path Variables
- Request Body
- Response Body
- Content Negotiation

### API Design Best Practices
- Resource Naming
- URI Design
- Pagination
- Filtering
- Sorting
- Search APIs
- Idempotency

### API Security
- Authentication
- Authorization
- JWT
- OAuth 2.0
- API Keys
- HTTPS
- Rate Limiting

### API Documentation
- OpenAPI
- Swagger
- API Contracts

### API Versioning
- URI Versioning
- Header Versioning
- Content Negotiation

### Error Handling
- Standard Error Response
- Validation Errors
- Global Exception Handling
- Problem Details (RFC 7807)

### Spring Boot REST APIs
- @RestController
- @RequestMapping
- @GetMapping
- @PostMapping
- @PutMapping
- @PatchMapping
- @DeleteMapping
- ResponseEntity
- Validation

## Interview Focus

### Frequently Asked Questions

- What is REST?
- Difference between PUT and PATCH?
- Difference between POST and PUT?
- What makes an API RESTful?
- What is idempotency?
- When should we use 200, 201, 202, 204?
- Difference between authentication and authorization?
- How does JWT work?
- How do you secure REST APIs?
- How do you implement pagination?
- How do you version APIs?
- What is HATEOAS?
- How do you handle errors in REST APIs?
- How do you design APIs for microservices?

## Hands-On Examples

- CRUD APIs
- User Management API
- Product Catalog API
- Order Management API
- Authentication Service
- API Gateway Integration

## Best Practices Checklist

- Use nouns instead of verbs in URLs
- Use proper HTTP methods
- Return meaningful status codes
- Validate requests
- Secure endpoints
- Document APIs
- Implement versioning
- Provide consistent error responses
- Keep APIs backward compatible