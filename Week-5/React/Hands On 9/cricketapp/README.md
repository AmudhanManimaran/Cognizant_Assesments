# cricketapp

A small React app built to practice ES6 features — arrow functions, `map()`, the spread operator, and array destructuring — using a simple cricket-themed dataset.

## What this covers

- Rendering a list of players and their scores with `Array.map()`
- Filtering players below a score threshold using an arrow function
- Merging two arrays with the spread operator (`...`)
- Splitting a merged array into odd-position and even-position groups using array destructuring
- Switching between two views on the same page using a basic `if / else` on a flag variable

## Folder structure

```
cricketapp/
├── public/
│   └── index.html
└── src/
    ├── App.js
    ├── ListofPlayers.js
    ├── Scorebelow70.js
    ├── OddPlayers.js
    ├── EvenPlayers.js
    ├── ListofIndianPlayers.js
    └── index.js
```

## How it works

`App.js` holds all the data (the players array, the two team arrays, and the merged array) and a `flag` variable.

- When `flag` is `true`, it renders the full players list and a filtered list of players scoring 70 or below.
- When `flag` is `false`, it renders the odd/even player groups (pulled out with destructuring) and the merged team list.

To switch views, just change the value of `flag` in `App.js` and save — the app will reload with the other view.

## Getting started

Clone or copy the project, then install dependencies and run it:

```bash
cd cricketapp
npm install
npm start
```

The app will open at `http://localhost:3000`.

## Notes

This was built as part of a hands-on lab focused on ES6 language features rather than component architecture, so the components are intentionally kept small and simple — each one does one thing (render a list, filter a list, split an array) rather than trying to be reusable across the app.
