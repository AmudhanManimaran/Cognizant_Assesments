import React from 'react';
import './App.css';
import BookDetails, { books } from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  return (
    <div>
      <div>
        <div className="mystyle1">
          <CourseDetails />
        </div>
        <div className="st2">
          <BookDetails books={books} />
        </div>
        <div className="v1">
          <BlogDetails />
        </div>
      </div>
    </div>
  );
}

export default App;