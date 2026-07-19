# eventexamplesapp

A small React app built to practice event handling — click events, passing arguments to handlers, the `this` keyword, and React's synthetic events.

## What this covers

- Handling click events with `onClick`
- Using `this` inside class component methods (bound in the constructor)
- Passing an argument into an event handler
- Using React's synthetic event system
- Managing component state with a simple counter
- A separate `CurrencyConvertor` component with its own state and form inputs

## Folder structure

```
eventexamplesapp/
├── public/
│   └── index.html
└── src/
    ├── App.js
    ├── CurrencyConvertor.js
    └── index.js
```

## How it works

`App.js` holds a counter in state along with a few buttons:

- **Increment / Decrement** — updates the counter up or down
- Incrementing also shows an alert with the current count, e.g. "Hello! Member 1"
- **Say Welcome** — calls a handler with `"welcome"` passed in as an argument
- **Click on me** — wired to React's synthetic click event, shows an alert confirming the click

Below that, `CurrencyConvertor.js` is a separate component with its own `Amount` and `Currency` input fields. Submitting the form converts the entered amount and shows the result in an alert.

## Getting started

Install dependencies and run the app:

```bash
cd eventexamplesapp
npm install
npm start
```

The app will open at `http://localhost:3000`.

## Notes

Everything here uses plain `alert()` for feedback rather than rendering messages on the page, since the focus of this lab was event handling itself rather than UI design. The currency conversion is a simple fixed-rate calculation, not a live exchange rate lookup.
