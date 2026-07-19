import React from 'react';

const blogs = [
  { id: 1, title: "React Learning", author: "Stephen Biz", date: "4/5/2021", content: "Welcome to learning React!" },
  { id: 2, title: "Installation", author: "Schewzdenier", date: "", content: "You can install React from npm." }
];

function BlogDetails() {
  const content = (
    <div>
      {blogs.map((blog) => {
        if (!blog.content) {
          return null;
        }
        return (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            {blog.author && <p>{blog.author}</p>}
            {blog.date && <p>{blog.date}</p>}
            <p>{blog.content}</p>
          </div>
        );
      })}
    </div>
  );

  return (
    <div>
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}

export default BlogDetails;