# React Hands-on 4: Component Life Cycle

## Objective

The objective of this hands-on exercise is to understand the React Component Lifecycle by creating a class component that fetches data from a REST API after the component is mounted and renders the retrieved data on the web page.

This exercise demonstrates the use of lifecycle methods such as `componentDidMount()` and `componentDidCatch()` along with the Fetch API.

---

## Prerequisites

Ensure the following software is installed:

- Node.js
- npm
- Visual Studio Code

---

## Technologies Used

- React
- JavaScript (ES6)
- Create React App
- Fetch API
- JSONPlaceholder REST API

---

## Project Structure

```text
blogapp/
├── node_modules/
├── public/
├── src/
│   ├── App.css
│   ├── App.js
│   ├── App.test.js
│   ├── Post.js
│   ├── Posts.js
│   ├── index.css
│   ├── index.js
│   ├── logo.svg
│   ├── reportWebVitals.js
│   └── setupTests.js
├── package.json
├── package-lock.json
└── README.md
```

---

## Steps Performed

### 1. Create the React Application

```bash
npx create-react-app blogapp
```

### 2. Navigate to the Project

```bash
cd blogapp
```

### 3. Open the Project in Visual Studio Code

```bash
code .
```

### 4. Create the Data Model

Created `Post.js` to represent the structure of a blog post.

Fields:

- userId
- id
- title
- body

---

### 5. Create the Posts Component

Created `Posts.js` as a React class component.

Implemented:

- Constructor
- State initialization
- `loadPosts()` method
- `componentDidMount()`
- `componentDidCatch()`
- `render()`

---

### 6. Fetch Blog Posts

The `loadPosts()` method retrieves data using the Fetch API from:

```text
https://jsonplaceholder.typicode.com/posts
```

The JSON response is converted into `Post` objects and stored in the component state.

---

### 7. Render Posts

The `render()` method displays:

- Post ID
- Post Title
- Post Body

Each post is rendered dynamically from the component state.

---

### 8. Update App Component

Modified `App.js` to render the `Posts` component.

---

### 9. Run the Application

```bash
cd blogapp
npm install
npm start
```

---

## Application URL

```
http://localhost:3000
```

---

## Lifecycle Methods Used

### constructor()

- Initializes the component.
- Creates an empty `posts` state.

### componentDidMount()

- Invoked immediately after the component is mounted.
- Calls `loadPosts()` to fetch data from the REST API.

### componentDidCatch()

- Catches rendering errors.
- Displays an alert if an error occurs.

---

## REST API Used

```text
https://jsonplaceholder.typicode.com/posts
```

The API returns dummy blog posts in JSON format.

---

## Expected Output

The browser displays:

- A heading for the page.
- A list of blog posts retrieved from the REST API.
- Each post shows:
  - Post ID
  - Title
  - Body

The data is loaded automatically after the component mounts.

---

## Features

- React Class Component
- Component Lifecycle Methods
- Fetch API integration
- REST API consumption
- Dynamic rendering using state
- Error handling with `componentDidCatch()`
- Clean and responsive presentation of blog posts

---

## Result

The application successfully retrieves blog post data from the JSONPlaceholder REST API using the Fetch API.

The `componentDidMount()` lifecycle method automatically loads the posts after the component is mounted, and the retrieved data is rendered dynamically on the page. The application also implements `componentDidCatch()` for basic error handling.

The application runs successfully on **http://localhost:3000**, demonstrating the use of React Component Lifecycle methods with external REST API integration.

---

## Conclusion

This hands-on exercise demonstrates the implementation of React Component Lifecycle methods in a class component. It covers component initialization, data fetching using the Fetch API, state management, dynamic rendering of REST API data, and basic error handling. The exercise provides a practical understanding of how React components interact with external services after mounting and forms the foundation for developing data-driven React applications.