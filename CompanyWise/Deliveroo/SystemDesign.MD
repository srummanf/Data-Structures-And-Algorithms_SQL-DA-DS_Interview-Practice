# Sample System Design Question asked in Deliveroo

## Designing a system to allow users to claim 6 million burgers in 10 minutes is a significant challenge that requires careful consideration of scalability, load balancing, request handling, caching, and rate limiting. Below is a high-level system design to handle this scenario.

### 1. System Requirements

- Allow users to claim 6 million burgers in 10 minutes.
- Handle high volume of requests efficiently.
- Ensure even distribution of requests across servers.
- Manage incoming requests and process them efficiently.
- Reduce response times using caching.
- Prevent abuse using rate limiting.

### 2. High-Level Architecture

#### 2.1 Components

1. **Load Balancer**: Distributes incoming requests across multiple servers to ensure even load.
2. **Application Servers**: Handle the business logic for processing burger claims.
3. **Queue System**: Manages incoming requests and ensures they are processed efficiently.
4. **Database**: Stores user information, claim status, and other necessary data.
5. **Cache**: Reduces response times by storing frequently accessed data.
6. **Rate Limiter**: Prevents abuse by limiting the number of requests per user or IP.

### 3. Detailed Design

#### 3.1 Load Balancer

- Use a load balancer (e.g., AWS ELB, NGINX) to distribute requests evenly across application servers.
- Ensure high availability by configuring multiple load balancers in different regions.

#### 3.2 Application Servers

- Deploy multiple instances of the application servers to handle the high volume of requests.
- Use containerization (e.g., Docker) and orchestration tools (e.g., Kubernetes) to manage the deployment and scaling of servers.
- Implement auto-scaling to handle traffic spikes during the 10-minute window.

#### 3.3 Queue System

- Use a distributed queue system (e.g., RabbitMQ, Kafka) to manage incoming requests.
- Ensure the queue system can handle the peak load and process requests in a FIFO manner.
- Workers will pull requests from the queue and process them asynchronously.

#### 3.4 Database

- Use a distributed database (e.g., Amazon DynamoDB, Google Cloud Spanner) to handle high write and read throughput.
- Optimize the schema for fast writes and reads, ensuring minimal latency.
- Implement database sharding to distribute the load across multiple instances.

#### 3.5 Cache

- Use an in-memory caching system (e.g., Redis, Memcached) to store frequently accessed data.
- Cache user sessions, claim statuses, and other read-heavy data to reduce database load and response times.

#### 3.6 Rate Limiter

- Implement a rate limiting mechanism (e.g., using API Gateway or custom middleware) to prevent abuse.
- Limit the number of claims per user/IP to a reasonable number within the 10-minute window.

### 4. Workflow

1. **User Request**: A user sends a request to claim a burger.
2. **Load Balancer**: The load balancer distributes the request to one of the application servers.
3. **Rate Limiting**: The application server checks if the user has exceeded the rate limit.
4. **Queue System**: Valid requests are added to the queue for processing.
5. **Processing**: Workers pull requests from the queue and process the burger claim.
6. **Database Update**: The worker updates the database with the claim status.
7. **Cache Update**: Frequently accessed data is updated in the cache.
8. **Response**: The user receives a response indicating the success or failure of the claim.

### 5. Diagram

```plaintext
                    +--------------------+
                    |  Load Balancer     |
                    +--------+-----------+
                             |
    +------------------------+------------------------+
    |                        |                        |
+---+---+              +-----+-----+              +---+---+
| App 1 |              |  App 2    |              | App 3 |
+-------+              +-----------+              +-------+
    |                        |                        |
    +------------------------+------------------------+
                             |
                      +------+------+
                      | Queue System |
                      +------+------+
                             |
                     +-------+-------+
                     |               |
                +----+----+     +----+----+
                | Worker 1 |     | Worker 2 |
                +---------+      +---------+
                     |                |
             +-------+-------+ +------+------+
             |               | |             |
      +------+-----+   +-----+------+   +-----+------+
      | Database   |   | Cache System |   | Rate Limiter |
      +------------+   +--------------+   +-------------+
```

### 6. Additional Considerations

1. **Monitoring and Logging**: Implement robust monitoring and logging to track system performance, errors, and user activity.
2. **Scalability**: Ensure all components can scale horizontally to handle increased load.
3. **Fault Tolerance**: Implement failover mechanisms and redundancy to ensure high availability.
4. **Security**: Secure all endpoints and ensure data protection, especially during peak loads.

### 7. Conclusion

This high-level design provides a scalable and efficient system to handle 6 million burger claims in 10 minutes. By using load balancing, a queue system, caching, and rate limiting, the system can manage high volumes of requests while maintaining performance and preventing abuse.

# How would you find the root cause of a slow API?

To diagnose and find the root cause of a slow API, you need to take a structured and systematic approach. Here’s a detailed guide on how to do it:

### 1. **Monitor and Measure Performance**

#### 1.1 Use APM Tools

- Implement Application Performance Monitoring (APM) tools like New Relic, Datadog, Dynatrace, or Prometheus to monitor the API’s performance.
- These tools can provide insights into response times, error rates, throughput, and resource utilization.

#### 1.2 Logging

- Ensure comprehensive logging is in place. Logs should include timestamps, request and response payloads, execution times, and error messages.
- Use structured logging and centralized logging systems (e.g., ELK stack, Splunk) to easily search and analyze logs.

### 2. **Analyze Metrics and Logs**

#### 2.1 Identify Slow Requests

- Look for patterns in slow requests. Determine if they occur at specific times, for specific endpoints, or for specific users.
- Identify the 95th or 99th percentile of response times to focus on the worst-performing requests.

#### 2.2 Trace Requests

- Use distributed tracing tools like Jaeger or Zipkin to trace the lifecycle of a request across services and components.
- Identify where the most time is being spent in the request lifecycle.

### 3. **Isolate the Bottleneck**

#### 3.1 Breakdown by Components

- **Database**: Check for slow queries, locking issues, or high latency in database access. Use query profiling tools (e.g., EXPLAIN in SQL databases) and database monitoring tools.
- **Third-Party Services**: Identify if third-party APIs or services are causing delays. Measure the latency of these external calls.
- **Network Issues**: Check for high latency or packet loss in network communication. Use network monitoring tools to analyze network performance.
- **Application Code**: Profile the application code to find inefficient algorithms, excessive loops, or blocking operations.

#### 3.2 Resource Utilization

- **CPU and Memory**: Check for high CPU or memory usage. Use tools like top, htop, or APM tools to monitor resource utilization.
- **Disk I/O**: Identify if disk read/write operations are slow. Use tools like iostat to monitor disk performance.
- **Concurrency Issues**: Look for thread contention, deadlocks, or insufficient worker threads.

### 4. **Optimization Strategies**

#### 4.1 Database Optimization

- Optimize slow queries with indexing, query rewriting, or denormalization.
- Implement caching strategies to reduce database load (e.g., Redis, Memcached).
- Use database connection pooling to manage database connections efficiently.

#### 4.2 Code Optimization

- Profile and refactor code to eliminate performance bottlenecks.
- Use asynchronous processing for I/O-bound operations.
- Optimize algorithms and data structures for better performance.

#### 4.3 Network Optimization

- Use a Content Delivery Network (CDN) to reduce latency for static assets.
- Implement HTTP/2 to improve network performance.
- Optimize payload sizes by compressing data and using efficient serialization formats (e.g., JSON vs. Protocol Buffers).

### 5. **Scalability and Load Balancing**

- Ensure horizontal scaling is in place to handle increased load. Use auto-scaling groups to dynamically scale resources.
- Distribute load evenly across servers using load balancers (e.g., AWS ELB, NGINX).
- Implement rate limiting and throttling to prevent abuse and ensure fair resource distribution.

### 6. **Continuous Monitoring and Improvement**

- Set up continuous performance testing to catch issues early. Use tools like JMeter or Gatling for load testing.
- Continuously monitor performance metrics and logs to detect and address performance degradation promptly.
- Regularly review and optimize infrastructure and application code as usage patterns and requirements evolve.

### Example Workflow

```plaintext
1. Setup Monitoring and Logging
   - Implement APM (e.g., New Relic)
   - Centralized logging (e.g., ELK stack)
   - Distributed tracing (e.g., Jaeger)

2. Analyze Performance Metrics
   - Identify slow endpoints and requests
   - Trace request lifecycle

3. Isolate Bottlenecks
   - Database: Slow queries, high latency
   - Third-Party Services: External API latency
   - Network: Latency, packet loss
   - Application Code: Inefficient algorithms, blocking operations

4. Optimize
   - Database: Indexing, query optimization, caching
   - Code: Refactoring, asynchronous processing
   - Network: CDN, HTTP/2, payload compression

5. Ensure Scalability
   - Horizontal scaling, auto-scaling groups
   - Load balancing
   - Rate limiting and throttling

6. Continuous Improvement
   - Continuous performance testing
   - Regular monitoring and optimization
```

By following these steps, you can systematically diagnose and resolve the root cause of slow API performance, ensuring a scalable and responsive system.

# What are overloaded methods and overwritten methods?

Overloaded methods and overridden methods are two important concepts in object-oriented programming (OOP) that relate to polymorphism and how methods can be defined in classes. Let's break down each concept with definitions, key points, and examples.

### Overloaded Methods

#### Definition

Method overloading occurs when multiple methods in the same class have the same name but different parameter lists (i.e., different type, number, or both of parameters). Overloading is a compile-time polymorphism.

#### Key Points

- Overloaded methods must have different parameter lists.
- They can have different return types, but the return type alone is not sufficient to distinguish overloaded methods.
- They can have different access modifiers.
- Overloading happens within the same class.

#### Example

```java
class MathUtils {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
  
    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
  
    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        MathUtils mathUtils = new MathUtils();
    
        System.out.println(mathUtils.add(2, 3));       // Calls add(int, int)
        System.out.println(mathUtils.add(2, 3, 4));    // Calls add(int, int, int)
        System.out.println(mathUtils.add(2.5, 3.5));   // Calls add(double, double)
    }
}
```

### Overridden Methods

#### Definition

Method overriding occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. Overriding is a run-time polymorphism.

#### Key Points

- Overridden methods must have the same name, return type, and parameter list as the method in the superclass.
- The overriding method can have a different access modifier, but it cannot be more restrictive than the method in the superclass.
- The overridden method can throw fewer or more specific exceptions than the method in the superclass.
- Overriding is used to provide a specific implementation for a method that is already defined in the superclass.

#### Example

```java
class Animal {
    // Method in the superclass
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Overridden method in the subclass
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();   // Calls the overridden method in Dog class
    }
}
```

### Summary

- **Overloaded Methods**: Same method name, different parameter lists, occurs in the same class. Example: `public int add(int a, int b)` and `public double add(double a, double b)`.
- **Overridden Methods**: Same method name, parameter list, and return type, occurs in superclass and subclass. Example: `public void makeSound()` in `Animal` class and `public void makeSound()` in `Dog` class.

Understanding these concepts helps in designing flexible and reusable code by leveraging polymorphism in OOP.

# System Design -- Design a service which allows user to use voucher in capacity

Designing a service that allows users to use vouchers within a defined capacity involves several components to ensure scalability, consistency, and efficiency. Here’s a high-level system design for such a service:

### 1. **System Requirements**

#### Functional Requirements

1. Users can redeem vouchers.
2. Each voucher has a limited capacity (number of uses).
3. Track the usage of each voucher.
4. Prevent overuse of vouchers.
5. Provide real-time feedback on voucher validity.

#### Non-Functional Requirements

1. Scalability: Handle a large number of users and voucher redemptions.
2. Reliability: Ensure that vouchers are not over-redeemed.
3. Performance: Fast validation and redemption process.
4. Security: Prevent abuse and ensure data integrity.

### 2. **High-Level Architecture**

#### 2.1 Components

1. **API Gateway**: Entry point for all client requests, routing them to the appropriate services.
2. **Voucher Service**: Core service handling voucher validation and redemption.
3. **User Service**: Manages user information and authentication.
4. **Database**: Stores voucher data and user voucher usage.
5. **Cache**: Stores frequently accessed data to reduce load on the database and improve response times.
6. **Queue System**: Manages and processes voucher redemption requests to ensure consistency and handle spikes in traffic.
7. **Rate Limiter**: Prevents abuse by limiting the number of requests per user or IP.

### 3. **Detailed Design**

#### 3.1 API Gateway

- Routes incoming requests to the appropriate microservices.
- Handles authentication and authorization.

#### 3.2 Voucher Service

- **Endpoints**:
  - `POST /redeem`: Redeem a voucher.
  - `GET /status`: Check voucher status.
- **Logic**:
  - Validate voucher code.
  - Check voucher capacity and user eligibility.
  - Update voucher usage in the database.
  - Return success or failure response.

#### 3.3 User Service

- Manages user authentication and profile information.
- Stores user-specific voucher usage data.

#### 3.4 Database

- **Voucher Table**: Stores voucher details (code, capacity, usage count, expiration date).
- **UserVoucher Table**: Tracks individual user voucher usage to prevent multiple redemptions.

#### 3.5 Cache

- Use Redis or Memcached to store frequently accessed voucher data.
- Cache voucher usage counts to reduce database load.

#### 3.6 Queue System

- Use RabbitMQ or Kafka to manage voucher redemption requests.
- Workers process requests from the queue, ensuring consistent updates to the database.

#### 3.7 Rate Limiter

- Implement rate limiting using API Gateway features or middleware to prevent abuse.

### 4. **Workflow**

1. **Voucher Redemption**:

   1. User sends a redemption request to the API Gateway.
   2. API Gateway routes the request to the Voucher Service.
   3. Voucher Service validates the voucher code and checks the capacity from the cache or database.
   4. If valid, the service adds the request to the queue.
   5. Queue workers process the request, updating the voucher usage count in the database.
   6. Voucher Service returns the redemption result to the user.
2. **Voucher Status Check**:

   1. User sends a status check request to the API Gateway.
   2. API Gateway routes the request to the Voucher Service.
   3. Voucher Service retrieves the voucher status from the cache or database.
   4. Service returns the voucher status to the user.

### 5. **Scalability and Reliability**

- **Scalability**:

  - Deploy multiple instances of the Voucher Service and User Service behind the API Gateway.
  - Use auto-scaling to handle traffic spikes.
  - Implement read replicas for the database to handle read-heavy operations.
- **Reliability**:

  - Use distributed locks or transactions to prevent race conditions during voucher redemption.
  - Ensure the queue system is robust and can handle retries for failed requests.

### 6. **Security**

- Secure communication using HTTPS.
- Implement OAuth or JWT for user authentication.
- Validate all input data to prevent injection attacks.
- Use RBAC (Role-Based Access Control) to limit access to sensitive endpoints.

### Diagram

```plaintext
                    +--------------------+
                    |    API Gateway     |
                    +--------+-----------+
                             |
    +------------------------+-----------------------+
    |                        |                       |
+---+---+              +-----+-----+             +---+---+
|User Svc|             |Voucher Svc|             | Rate  |
|        |             |           |             |Limiter|
+--------+             +-----------+             +-------+
    |                        |                       |
    +------------------------+-----------------------+
                             |
                         +---+---+
                         | Cache |
                         +---+---+
                             |
                      +------+------+
                      | Queue System |
                      +------+------+
                             |
                          +--+--+
                          | DB   |
                          +------+
```

### 7. **Additional Considerations**

- **Monitoring and Logging**: Implement comprehensive monitoring and logging to track system performance and detect issues.
- **Testing**: Conduct thorough testing, including unit tests, integration tests, and load tests to ensure the system can handle high traffic and edge cases.
- **Documentation**: Provide clear documentation for API endpoints and usage guidelines.

By following this design, you can build a robust, scalable, and efficient voucher redemption system that meets the outlined requirements.

# design a system that would be able to handle millions of requests in a short time (and keep track of results per user)

Designing a system that can handle millions of requests in a short time while keeping track of results per user involves considering several factors: scalability, performance, reliability, and consistency. Here's a high-level system design to achieve this:

### 1. **System Requirements**

#### Functional Requirements

1. Handle millions of requests concurrently.
2. Track results per user.
3. Ensure real-time processing and feedback.
4. Provide user authentication and authorization.

#### Non-Functional Requirements

1. Scalability: The system should scale horizontally to handle increased load.
2. Performance: The system should process requests with low latency.
3. Reliability: The system should be highly available and fault-tolerant.
4. Consistency: Ensure data consistency for user results.
5. Security: Secure user data and communication.

### 2. **High-Level Architecture**

#### 2.1 Components

1. **API Gateway**: Entry point for all client requests, routing them to appropriate services.
2. **Authentication Service**: Handles user authentication and authorization.
3. **Request Processing Service**: Core service that processes user requests.
4. **Results Service**: Manages and stores the results for each user.
5. **Database**: Stores user data and results.
6. **Cache**: Stores frequently accessed data to reduce load on the database and improve response times.
7. **Queue System**: Manages and processes incoming requests efficiently.
8. **Load Balancer**: Distributes incoming requests evenly across servers.
9. **Monitoring and Logging**: Tracks system performance and logs for debugging and auditing.

### 3. **Detailed Design**

#### 3.1 API Gateway

- **Responsibilities**:
  - Route requests to the appropriate services.
  - Handle authentication and authorization.
  - Implement rate limiting to prevent abuse.

#### 3.2 Authentication Service

- **Responsibilities**:
  - Validate user credentials.
  - Issue and validate JWT tokens for authenticated sessions.
  - Ensure secure communication (HTTPS).

#### 3.3 Request Processing Service

- **Responsibilities**:
  - Process user requests and perform necessary computations or actions.
  - Store intermediate and final results in the Results Service.
  - Use asynchronous processing for intensive tasks.

#### 3.4 Results Service

- **Responsibilities**:
  - Manage user-specific results.
  - Provide APIs to fetch results for authenticated users.
  - Ensure data consistency and availability.

#### 3.5 Database

- **Choice**:
  - Use a distributed SQL database (e.g., Amazon Aurora, Google Cloud Spanner) for structured data and ACID transactions.
  - Use a NoSQL database (e.g., MongoDB, Cassandra) for scalable, schema-less data storage.
- **Schema**:
  - **Users**: `user_id (PK)`, `username`, `password_hash`, `email`, etc.
  - **Results**: `result_id (PK)`, `user_id (FK)`, `request_id`, `result_data`, `timestamp`, etc.

#### 3.6 Cache

- **Choice**: Use Redis or Memcached for in-memory caching.
- **Responsibilities**:
  - Cache frequently accessed data (e.g., user profiles, recent results).
  - Reduce read load on the database.

#### 3.7 Queue System

- **Choice**: Use RabbitMQ or Apache Kafka for message queuing.
- **Responsibilities**:
  - Queue incoming requests for asynchronous processing.
  - Ensure reliable message delivery and processing.

#### 3.8 Load Balancer

- **Choice**: Use a cloud-based load balancer (e.g., AWS ELB, Google Cloud Load Balancer).
- **Responsibilities**:
  - Distribute incoming requests across multiple instances of services.
  - Ensure high availability and fault tolerance.

#### 3.9 Monitoring and Logging

- **Tools**: Use Prometheus and Grafana for monitoring, and ELK stack (Elasticsearch, Logstash, Kibana) for logging.
- **Responsibilities**:
  - Monitor system performance and health.
  - Log requests, errors, and system events for debugging and auditing.

### 4. **Workflow**

1. **Request Handling**:

   1. User sends a request to the API Gateway.
   2. API Gateway authenticates the user using the Authentication Service.
   3. Authenticated request is routed to the Request Processing Service.
   4. Request Processing Service processes the request, storing intermediate results if necessary.
   5. Final result is stored in the Results Service.
   6. User receives a response with the result or a reference to fetch the result later.
2. **Result Fetching**:

   1. User requests their results via the API Gateway.
   2. API Gateway authenticates the user.
   3. Authenticated request is routed to the Results Service.
   4. Results Service fetches the user's results from the cache or database.
   5. Results are returned to the user.

### Diagram

```plaintext
                          +--------------------+
                          |    API Gateway     |
                          +---------+----------+
                                    |
      +-----------------------------+-----------------------------+
      |                             |                             |
+-----+-----+               +--------+--------+            +------+-+
| Auth Svc  |               | Request Processing Svc |      | Rate   |
|           |               |                        |      | Limiter|
+-----------+               +--------+--------+      |      +--------+
                                    |                |           |
                          +---------+---------+      |     +----+----+
                          | Results Service   |      |     | Cache   |
                          +---------+---------+      |     +----+----+
                                    |                |          |
                             +------+-------+        |     +----+----+
                             | Database      |<------+     | Queue   |
                             +------+-------+              +----+----+
                                    |                           |
                          +---------+---------+                 |
                          | Monitoring & Logging |<-------------+
                          +----------------------+
```

### 5. **Scalability and Reliability**

- **Scalability**:

  - Deploy multiple instances of each service behind the API Gateway.
  - Use auto-scaling groups to handle dynamic load.
  - Partition the database to distribute the load.
  - Implement caching for frequently accessed data.
- **Reliability**:

  - Use distributed systems and replication for high availability.
  - Implement failover mechanisms for critical services.
  - Ensure idempotent operations to handle retries gracefully.

### 6. **Security**

- Secure communication using HTTPS.
- Implement OAuth 2.0 or JWT for user authentication.
- Validate all input data to prevent injection attacks.
- Use RBAC (Role-Based Access Control) for sensitive operations.

### 7. **Continuous Improvement**

- Regularly monitor system performance and optimize bottlenecks.
- Conduct load testing to ensure the system can handle peak loads.
- Update and patch services to address security vulnerabilities.

By following this design, you can build a robust, scalable, and efficient system capable of handling millions of requests in a short time while tracking results per user effectively.

# How would you verify that service has a memory leak, - Composition vs Inheritence, - Coding part : parsing logs according to get information required in the task (and computational complexity),

### How to Verify a Service Has a Memory Leak

To verify that a service has a memory leak, follow these steps:

1. **Monitoring and Profiling**:

   - Use monitoring tools to track memory usage over time (e.g., Prometheus, Grafana).
   - Use profiling tools to analyze memory usage (e.g., JProfiler, YourKit, VisualVM).
2. **Identify Symptoms**:

   - Gradual increase in memory usage over time without corresponding decrease.
   - Frequent garbage collection with little memory being freed.
   - OutOfMemoryError exceptions.
3. **Heap Dump Analysis**:

   - Capture heap dumps at different intervals.
   - Compare the heap dumps to identify objects that are not being freed.
   - Use tools like Eclipse MAT (Memory Analyzer Tool) to analyze heap dumps.
4. **Code Review**:

   - Look for common sources of memory leaks: unclosed resources, static collections growing indefinitely, circular references, etc.
5. **Test with Load Simulation**:

   - Simulate a load on the service and monitor memory usage.
   - Run the service under load for an extended period to observe memory behavior.
6. **Logging**:

   - Add logging to track object creation and destruction.
   - Log memory usage metrics periodically.

### Composition vs Inheritance

- **Composition**:

  - **Definition**: Building complex objects by combining simpler ones.
  - **When to Use**: Prefer composition over inheritance when:
    - The relationship is "has-a" rather than "is-a".
    - You want to change behavior at runtime.
    - You need to reduce coupling between classes.
  - **Advantages**:
    - More flexible and maintainable.
    - Promotes code reuse without the downsides of tight coupling.
    - Easier to test.
- **Inheritance**:

  - **Definition**: Deriving a new class from an existing class.
  - **When to Use**: Use inheritance when:
    - The relationship is "is-a".
    - You want to share behavior across multiple classes.
  - **Advantages**:
    - Allows for polymorphism and method overriding.
    - Can lead to cleaner and more concise code in certain scenarios.
  - **Disadvantages**:
    - Can lead to tight coupling and brittle code.
    - Increases the complexity of the class hierarchy.

### Parsing Logs for Information (Coding Part)

Here’s an example of parsing logs to extract specific information. Assume we have logs in the format:

```
[INFO] 2024-07-29 12:00:00 - UserID: 123 - Action: Login
[ERROR] 2024-07-29 12:01:00 - UserID: 123 - Action: FailedLogin
[INFO] 2024-07-29 12:02:00 - UserID: 456 - Action: Logout
```

We want to parse these logs and extract the number of actions per user.

#### Code Example in Python

```python
import re
from collections import defaultdict

log_pattern = re.compile(r'\[(\w+)\] (\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}) - UserID: (\d+) - Action: (\w+)')

def parse_logs(logs):
    user_actions = defaultdict(list)
    for log in logs:
        match = log_pattern.match(log)
        if match:
            log_level, timestamp, user_id, action = match.groups()
            user_actions[user_id].append((timestamp, action))
    return user_actions

# Sample logs
logs = [
    "[INFO] 2024-07-29 12:00:00 - UserID: 123 - Action: Login",
    "[ERROR] 2024-07-29 12:01:00 - UserID: 123 - Action: FailedLogin",
    "[INFO] 2024-07-29 12:02:00 - UserID: 456 - Action: Logout"
]

user_actions = parse_logs(logs)
for user_id, actions in user_actions.items():
    print(f"User {user_id}:")
    for timestamp, action in actions:
        print(f"  - {timestamp}: {action}")
```

#### Computational Complexity

- The time complexity of this log parsing is O(n), where n is the number of log entries.
- The space complexity is O(m), where m is the number of unique users.

### Similar LeetCode Problems

Here are some similar LeetCode problems related to string parsing and log analysis:

1. [Log Storage System (LeetCode 635)](https://leetcode.com/problems/design-log-storage-system/)
2. [Most Common Word (LeetCode 819)](https://leetcode.com/problems/most-common-word/)
3. [Group Anagrams (LeetCode 49)](https://leetcode.com/problems/group-anagrams/)
4. [Subdomain Visit Count (LeetCode 811)](https://leetcode.com/problems/subdomain-visit-count/)
5. [Valid Parentheses (LeetCode 20)](https://leetcode.com/problems/valid-parentheses/)
6. [Evaluate Reverse Polish Notation (LeetCode 150)](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
7. [Minimum Window Substring (LeetCode 76)](https://leetcode.com/problems/minimum-window-substring/)
8. [Word Pattern (LeetCode 290)](https://leetcode.com/problems/word-pattern/)
9. [Basic Calculator II (LeetCode 227)](https://leetcode.com/problems/basic-calculator-ii/)
10. [Longest Substring Without Repeating Characters (LeetCode 3)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

These problems involve various aspects of string manipulation, parsing, and efficient data processing, providing a solid practice ground for log parsing and similar tasks.
