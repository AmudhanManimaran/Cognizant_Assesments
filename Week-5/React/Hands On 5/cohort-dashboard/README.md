# React Hands-on: Component Styling Using CSS Modules and Inline Styles

## Objective

The objective of this hands-on exercise is to understand and implement component styling in React using **CSS Modules** and **Inline Styles**. The application demonstrates how to apply scoped CSS to React components and dynamically change styles based on component properties.

---

## Prerequisites

Before starting the exercise, ensure the following software is installed:

- Node.js
- npm (comes with Node.js)
- Visual Studio Code

---

## Technologies Used

- React
- JavaScript (ES6)
- CSS Modules
- Inline Styling
- Node.js
- npm

---

## Project Structure

```text
cohorttracker/
├── src/
│   ├── App.js
│   ├── App.css
│   ├── CohortDetails.js
│   ├── CohortDetails.module.css
│   ├── index.js
│   └── ...
├── public/
├── package.json
├── package-lock.json
└── README.md
```

---

## Steps Performed

### 1. Install Project Dependencies

Open the terminal inside the project directory and install all required packages.

```bash
npm install
```

---

### 2. Create CSS Module

Created a CSS Module named:

```
src/CohortDetails.module.css
```

The CSS module defines:

- Card styling
- Border
- Border radius
- Padding
- Margin
- Width
- `<dt>` font styling

---

### 3. Modify the CohortDetails Component

Updated the existing `CohortDetails.js` component to:

- Import the CSS Module
- Apply scoped styling using `className={styles.box}`
- Display cohort information
- Apply conditional inline styling to the heading

```jsx
<h3
    style={{
        color:
            props.currentStatus === "Ongoing"
                ? "green"
                : "blue"
    }}
>
    {props.cohortName}
</h3>
```

The heading color changes dynamically based on the cohort status.

---

### 4. Execute the Application

Run the React development server.

```bash
cd cohort-dashboard
npm install
npm start
```

---

## Application URL

```
http://localhost:3000
```

---

## Expected Output

The application displays a page titled:

```
Cohorts Details
```

Three cohort information cards are displayed.

### Card Details

**Card 1**

- Cohort: INTADMDF10 -.NET FSD
- Started On: 22-Feb-2022
- Current Status: Scheduled
- Coach: Aathma
- Trainer: Jojo Jose

Heading Color:

```
Blue
```

---

**Card 2**

- Cohort: ADM21JF014 -Java FSD
- Started On: 10-Sep-2021
- Current Status: Ongoing
- Coach: Apoorv
- Trainer: Elisa Smith

Heading Color:

```
Green
```

---

**Card 3**

- Cohort: CDBJF21025 -Java FSD
- Started On: 24-Dec-2021
- Current Status: Ongoing
- Coach: Aathma
- Trainer: John Doe

Heading Color:

```
Green
```

---

## Features

- React Functional Component
- CSS Modules for scoped styling
- Dynamic Inline Styling
- Conditional rendering based on component properties
- Reusable component design
- Responsive card layout
- Clean separation of structure and styling

---

## Result

The React application was successfully executed using the provided starter project. The `CohortDetails` component was styled using **CSS Modules**, ensuring that styles remain locally scoped to the component. Inline styling was implemented to dynamically change the cohort title color based on the current status, where **Ongoing** cohorts are displayed in **green** and **Scheduled** cohorts are displayed in **blue**. The application successfully renders all cohort details in separate styled cards, matching the expected output of the hands-on exercise.

---

## Conclusion

This hands-on exercise demonstrates how React supports component-level styling through **CSS Modules** and dynamic styling using **Inline Styles**. It illustrates how reusable React components can be styled independently while applying conditional formatting based on runtime data. The implementation successfully fulfills all the objectives of the hands-on exercise and provides a foundation for building modular and maintainable React user interfaces.