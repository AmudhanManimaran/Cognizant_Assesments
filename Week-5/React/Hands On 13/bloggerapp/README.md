# bloggerapp

A small React app built to practice conditional rendering, using three components — Course Details, Book Details, and Blog Details — laid out side by side on one page.

## What this covers

- Multiple ways of writing conditional rendering: if/else, the logical `&&` operator, and returning `null` to skip rendering
- Element variables — building a piece of JSX in a variable first, then rendering it inside a component
- Rendering lists with `map()` and using `key` correctly
- Extracting repeated markup into separate components

## Folder structure

```
bloggerapp/
├── public/
│   └── index.html
└── src/
    ├── App.js
    ├── App.css
    ├── CourseDetails.js
    ├── BookDetails.js
    ├── BlogDetails.js
    └── index.js
```

## How it works

`App.js` lays out three components side by side: `CourseDetails`, `BookDetails`, and `BlogDetails`, each in its own styled column with a green divider between them.

- `CourseDetails` lists a couple of courses with their dates, built as an element variable (`coursedet`) before being rendered.
- `BookDetails` receives a `books` array as a prop and maps over it to display each book's name and price.
- `BlogDetails` maps over a `blogs` array, but skips rendering any entry that has no content (returning `null`), and uses the `&&` operator to conditionally show an author or date line only when one is present.

## Getting started

Install dependencies and run the app:

```bash
cd bloggerapp
npm install
npm start
```

The app will open at `http://localhost:3000`.

## Notes

All the data (courses, books, blogs) is hardcoded directly in each component rather than pulled from an API, since the focus of this lab is on conditional rendering patterns rather than data fetching.
