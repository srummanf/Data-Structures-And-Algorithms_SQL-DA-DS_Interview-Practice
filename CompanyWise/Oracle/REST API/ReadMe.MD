
# **Axios: A Comprehensive Guide**

## **Table of Contents**

1. [Introduction to Axios](#introduction-to-axios)
2. [Installing Axios](#installing-axios)
3. [Basic Usage](#basic-usage)
4. [Handling Responses](#handling-responses)
5. [Error Handling](#error-handling)
6. [Advanced Usage](#advanced-usage)
7. [Interceptors](#interceptors)
8. [Cancellation](#cancellation)
9. [Concurrent Requests](#concurrent-requests)
10. [Custom Instances](#custom-instances)
11. [Configuration](#configuration)

---

## **Introduction to Axios**

Axios is a promise-based HTTP client for the browser and Node.js. It provides a simple API for making HTTP requests and supports features like interceptors, cancellation, and concurrent requests.

> "Axios is a powerful and easy-to-use library that simplifies HTTP requests and responses."

---

## **Installing Axios**

To use `axios`, you need to install it in your project. You can install it via npm or yarn.

```bash
npm install axios
```

or

```bash
yarn add axios
```

---

## **Basic Usage**

Axios provides methods for making HTTP requests. Here’s how to use it for common HTTP methods:

### **GET Request**

```javascript
const axios = require('axios');

axios.get('https://jsonplaceholder.typicode.com/posts')
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
```

### **POST Request**

```javascript
axios.post('https://jsonplaceholder.typicode.com/posts', {
    title: 'foo',
    body: 'bar',
    userId: 1
  })
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
```

### **PUT Request**

```javascript
axios.put('https://jsonplaceholder.typicode.com/posts/1', {
    title: 'foo',
    body: 'bar',
    userId: 1
  })
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
```

### **DELETE Request**

```javascript
axios.delete('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
```

---

## **Handling Responses**

Axios responses contain several properties including `data`, `status`, `statusText`, `headers`, and `config`.

### **Example Response Object**

```javascript
axios.get('https://jsonplaceholder.typicode.com/posts/1')
  .then(response => {
    console.log('Status:', response.status);
    console.log('Status Text:', response.statusText);
    console.log('Headers:', response.headers);
    console.log('Data:', response.data);
  });
```

| Property       | Description                              |
| -------------- | ---------------------------------------- |
| `data`       | The response body from the server.       |
| `status`     | The HTTP status code of the response.    |
| `statusText` | The HTTP status message of the response. |
| `headers`    | The headers of the response.             |
| `config`     | The configuration of the request.        |

---

## **Error Handling**

Handling errors with `axios` involves catching errors using `.catch()` or `try/catch` blocks in asynchronous functions.

### **Using `.catch()`**

```javascript
axios.get('https://jsonplaceholder.typicode.com/invalid-url')
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error.response ? error.response.data : error.message);
  });
```

### **Using `try/catch`**

```javascript
async function fetchData() {
  try {
    const response = await axios.get('https://jsonplaceholder.typicode.com/invalid-url');
    console.log('Data:', response.data);
  } catch (error) {
    console.error('Error:', error.response ? error.response.data : error.message);
  }
}

fetchData();
```

---

## **Advanced Usage**

### **Interceptors**

Interceptors allow you to modify requests or responses before they are handled by `.then()` or `.catch()`.

#### **Request Interceptor**

```javascript
axios.interceptors.request.use(config => {
  console.log('Request:', config);
  return config;
}, error => {
  return Promise.reject(error);
});
```

#### **Response Interceptor**

```javascript
axios.interceptors.response.use(response => {
  console.log('Response:', response);
  return response;
}, error => {
  return Promise.reject(error);
});
```

### **Cancellation**

You can cancel requests using `CancelToken`.

```javascript
const CancelToken = axios.CancelToken;
const source = CancelToken.source();

axios.get('https://jsonplaceholder.typicode.com/posts', {
  cancelToken: source.token
}).then(response => {
  console.log('Data:', response.data);
}).catch(thrown => {
  if (axios.isCancel(thrown)) {
    console.log('Request canceled', thrown.message);
  } else {
    console.error('Error:', thrown);
  }
});

// Cancel the request
source.cancel('Operation canceled by the user.');
```

### **Concurrent Requests**

Axios allows you to make multiple requests concurrently using `axios.all` and `axios.spread`.

```javascript
const request1 = axios.get('https://jsonplaceholder.typicode.com/posts/1');
const request2 = axios.get('https://jsonplaceholder.typicode.com/posts/2');

axios.all([request1, request2])
  .then(axios.spread((response1, response2) => {
    console.log('Response 1:', response1.data);
    console.log('Response 2:', response2.data);
  }))
  .catch(error => {
    console.error('Error:', error);
  });
```

### **Custom Instances**

You can create custom instances of axios with default configurations.

```javascript
const instance = axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
  timeout: 1000,
  headers: {'X-Custom-Header': 'foobar'}
});

instance.get('/posts')
  .then(response => {
    console.log('Data:', response.data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
```

### **Configuration**

Configuration options for `axios` requests include `headers`, `params`, `timeout`, and `auth`.

#### **Example Configuration**

```javascript
axios({
  method: 'get',
  url: 'https://jsonplaceholder.typicode.com/posts',
  params: {
    userId: 1
  },
  headers: {
    'Authorization': 'Bearer token'
  }
}).then(response => {
  console.log('Data:', response.data);
}).catch(error => {
  console.error('Error:', error);
});
```

---

This guide provides a solid foundation for using `axios` from basic requests to more advanced features like interceptors, cancellation, and concurrent requests. You can adapt these concepts to suit your needs in various projects.




# Why I have 2 data in my query ?

The `data.data` structure appears because of how the response object is structured when using libraries like Axios to make HTTP requests.

### **Understanding `data.data`:**

1. **Outer `data`:**

   - The first `data` refers to the property of the response object that Axios returns. When you make a request with Axios, it wraps the actual response body inside an object, and one of the properties of this object is `data`. This `data` contains the body of the HTTP response.
   - Example:

     ```javascript
     axios.get('https://example.com/api')
       .then(response => {
         console.log(response.data);
       });
     ```

     Here, `response.data` holds the actual response body from the server.
2. **Inner `data`:**

   - The second `data` refers to the data that is contained within the body of the HTTP response itself. This happens when the server's response body is an object that has a property named `data`. It's a common pattern in APIs to wrap the actual payload within a `data` field, especially in RESTful APIs.
   - Example:

     ```json
     {
       "status": "success",
       "data": [
         { "id": 1, "name": "Item 1" },
         { "id": 2, "name": "Item 2" }
       ]
     }
     ```

     In this case, if you made an Axios request, `response.data.data` would refer to the array of items.

### **Applying to Your Example:**

In your code:

```javascript
data.data.forEach(match => {
  const team1Goals = parseInt(match.team1goals);
  const team2Goals = parseInt(match.team2goals);
  if (team1Goals === team2Goals) {
    totalDraws++;
  }
});
```

- **`data`:** The first `data` is the Axios response object’s `data` property.
- **`data.data`:** The second `data` is the actual data you are interested in, which is likely an array of matches.

So, `data.data` means you are accessing the `data` property of the object contained within the response body, which is common when APIs structure their responses with an outer object that includes metadata (like `status`) and the actual data (like `data`).

### **Simplified:**

- The first `data` comes from Axios.
- The second `data` comes from the structure of the API response itself.


# Sample Questions

Here's the solution using `axios` for the previous code, along with the solutions for the two new questions:

### 1. **Converting the `node-fetch` Code to `axios`**

```javascript
const axios = require('axios');

async function getTotalGoals(team, year) {
    let totalGoals = 0;

    try {
        // Fetch goals for matches where the team is the home team (team1)
        totalGoals += await fetchGoals(`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team1=${team}`, team);

        // Fetch goals for matches where the team is the away team (team2)
        totalGoals += await fetchGoals(`https://jsonmock.hackerrank.com/api/football_matches?year=${year}&team2=${team}`, team);
    } catch (error) {
        console.error("Error fetching goals:", error);
    }

    return totalGoals;
}

async function fetchGoals(url, team) {
    let goals = 0;
    let page = 1;

    while (true) {
        try {
            const response = await axios.get(`${url}&page=${page}`);
            const data = response.data;

            data.data.forEach(match => {
                if (url.includes('team1') && match.team1 === team) {
                    goals += parseInt(match.team1goals);
                } else if (url.includes('team2') && match.team2 === team) {
                    goals += parseInt(match.team2goals);
                }
            });

            if (page >= data.total_pages) {
                break;
            }

            page++;
        } catch (error) {
            console.error(`Error fetching page ${page}:`, error);
            break;
        }
    }

    return goals;
}

// Example usage
getTotalGoals('Barcelona', 2011).then(totalGoals => {
    console.log(`Total goals scored by Barcelona in 2011: ${totalGoals}`);
}).catch(error => {
    console.error("Error:", error);
});
```

### 2. **Practice Questions**

#### **Question 1: POST Request to Add a New Match**

**Function:**

```javascript
const axios = require('axios');

async function addNewMatch(matchDetails) {
    const { team1goals, team2goals } = matchDetails;

    if (team1goals + team2goals > 5) {
        try {
            const response = await axios.post('https://jsonmock.hackerrank.com/api/football_matches', matchDetails);
            console.log("Match added successfully:", response.data);
        } catch (error) {
            console.error("Error adding match:", error);
        }
    } else {
        console.log("Match not added. Combined goals must be more than 5.");
    }
}

// Example usage
addNewMatch({
    year: 2011,
    team1: 'Barcelona',
    team2: 'Real Madrid',
    team1goals: 3,
    team2goals: 3
});
```

#### **Question 2: PUT Request to Update Match Goals**

**Function:**

```javascript
const axios = require('axios');

async function updateMatchGoals(matchId, updatedGoals) {
    const { year, team1goals, team2goals } = updatedGoals;

    if (year === 2011 && team1goals < 3 && team2goals < 3) {
        try {
            const response = await axios.put(`https://jsonmock.hackerrank.com/api/football_matches/${matchId}`, updatedGoals);
            console.log("Match updated successfully:", response.data);
        } catch (error) {
            console.error("Error updating match:", error);
        }
    } else {
        console.log("Match not updated. Conditions not met.");
    }
}

// Example usage
updateMatchGoals(1, {
    year: 2011,
    team1goals: 2,
    team2goals: 1
});
```

These examples show how to use `axios` for GET, POST, and PUT requests, while incorporating conditions to control when these requests are made.
