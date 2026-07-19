# React Hands-on: Creating the First React Application

## Objective

The objective of this hands-on exercise is to create a React application using **Create React App**, modify the default application, and display a custom message on the browser.

The application demonstrates the basic setup of a React Single Page Application (SPA) and verifies that the React development environment is configured correctly.

---

## Prerequisites

Before starting the exercise, ensure the following software is installed:

- Node.js
- npm (comes with Node.js)
- Visual Studio Code

---

## Technologies Used

- React
- JavaScript
- Node.js
- npm
- Create React App

---

## Project Structure

```text
myfirstreact/
├── node_modules/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├── manifest.json
│   └── robots.txt
├── src/
│   ├── App.css
│   ├── App.js
│   ├── App.test.js
│   ├── index.css
│   ├── index.js
│   ├── logo.svg
│   ├── reportWebVitals.js
│   └── setupTests.js
├── .gitignore
├── package.json
├── package-lock.json
└── README.md
```

---

## Steps Performed

### 1. Create a React Application

```bash
npx create-react-app myfirstreact
```

### 2. Navigate to the Project Directory

```bash
cd myfirstreact
```

### 3. Open the Project in Visual Studio Code

```bash
code .
```

### 4. Modify `src/App.js`

Replace the default code with the following:

```jsx
function App() {
  return (
    <div className="App">
      <h1>welcome to the first session of React</h1>
    </div>
  );
}

export default App;
```

### 5. Run the Application

```bash
cd myfirstreact
npm install
npm start
```

---

## Application URL

Open the following URL in a web browser:

```
http://localhost:3000
```

---

## Expected Output

```text
welcome to the first session of React
```

---

## Features

- Created a React application using Create React App
- Modified the default React component
- Displayed a custom heading
- Executed the application using the React development server
- Verified the output in the browser

---

## Result

The React application was successfully created and executed. The default React page was modified to display the required heading:

```text
welcome to the first session of React
```

The application runs successfully on **http://localhost:3000**, confirming that the React development environment is configured correctly and the objectives of the hands-on exercise have been achieved.

---

## Conclusion

This hands-on exercise demonstrates the basic workflow of developing a React Single Page Application (SPA) using Create React App. It covers project creation, component modification, application execution, and browser verification, providing a foundation for developing React-based web applications.