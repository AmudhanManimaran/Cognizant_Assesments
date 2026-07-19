# officespacerentalapp

A small React app built to practice JSX fundamentals — creating elements and attributes with JSX, rendering data with JavaScript expressions, and applying conditional inline styling.

## What this covers

- Creating a JSX element for the page heading
- Using an attribute (`src`) to render an image via JSX
- Displaying a single object's data (Name, Rent, Address) using JSX expressions
- Looping through an array of objects with `map()` to render a list
- Applying conditional CSS so the rent shows in red when it's 60000 or below, and green when it's above 60000

## Folder structure

```
officespacerentalapp/
├── public/
│   └── index.html
└── src/
    ├── App.js
    ├── App.css
    └── index.js
```

## How it works

`App.js` defines a single office object (`ItemName`) that's rendered directly on the page, along with an array of similar office objects rendered below it using `map()`.

Each entry's rent is checked against a threshold of 60000. Based on that, a CSS class (`textRed` or `textGreen`) is applied to the rent value, so the color updates automatically depending on the amount.

## Getting started

Install dependencies and run the app:

```bash
cd officespacerentalapp
npm install
npm start
```

The app will open at `http://localhost:3000`.

## Notes

This was built as part of a hands-on lab focused on JSX syntax and inline styling rather than component structure, so the app intentionally stays in a single file. The color logic is kept as plain if/else on the rent value, since the goal here was demonstrating conditional styling, not building a reusable utility.
