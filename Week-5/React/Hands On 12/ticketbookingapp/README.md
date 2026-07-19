# ticketbookingapp

A small React app built to practice conditional rendering — showing different pages to guest and logged-in users based on component state.

## What this covers

- Conditional rendering with plain `if` statements inside a component
- Using an element variable (`let button`) to swap between two elements based on state
- Toggling between a Guest view and a User view with Login/Logout buttons
- Controlled form inputs with `useState`

## Folder structure

```
ticketbookingapp/
├── public/
│   └── index.html
└── src/
    ├── App.js
    ├── Greeting.js
    ├── LoginButton.js
    ├── LogoutButton.js
    ├── GuestPage.js
    ├── UserPage.js
    └── index.js
```

## How it works

`App.js` keeps track of an `isLoggedIn` flag in state, along with handlers for the Login and Logout buttons.

- When `isLoggedIn` is `false`, `Greeting` renders `GuestPage` — a list of available flights, with a prompt to log in.
- When `isLoggedIn` is `true`, `Greeting` renders `UserPage` — a simple booking form with From/To fields.
- The button shown below the greeting also switches: `LoginButton` when logged out, `LogoutButton` when logged in.

`UserPage` keeps its own local state for the From/To inputs. Clicking "Book Now" reads both values and shows a confirmation alert; if either field is left empty, it alerts asking for both instead.

## Getting started

Install dependencies and run the app:

```bash
cd ticketbookingapp
npm install
npm start
```

The app will open at `http://localhost:3000`.

## Notes

The booking form doesn't persist bookings anywhere — it's a straightforward confirmation via `alert()`, since the point of this lab is conditional rendering rather than data handling. The flight list on the Guest page is static sample data rather than something fetched from an API.
