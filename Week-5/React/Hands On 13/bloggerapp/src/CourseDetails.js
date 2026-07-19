import React from 'react';

const courses = [
  { id: 1, name: "Angular", date: "4/5/2021" },
  { id: 2, name: "React", date: "6/3/20201" }
];

const coursedet = (
  <ul>
    {courses.map((course) => (
      <div key={course.id}>
        <h3>{course.name}</h3>
        <p>{course.date}</p>
      </div>
    ))}
  </ul>
);

function CourseDetails() {
  return (
    <div>
      <h1>Course Details</h1>
      {coursedet}
    </div>
  );
}

export default CourseDetails;