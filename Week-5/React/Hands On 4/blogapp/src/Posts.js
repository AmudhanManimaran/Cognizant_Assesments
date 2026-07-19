import React, { Component } from 'react';
import { Post } from './Post';

// 1. We create a small Child Component to render individual posts.
// If this component throws an error, the parent (Posts) will catch it!
const PostItem = ({ post }) => (
    <div style={{ borderBottom: '2px solid #eee', marginBottom: '20px', paddingBottom: '10px' }}>
        <h3 style={{ color: '#0056b3', textTransform: 'capitalize' }}>
            {post.id}. {post.title}
        </h3>
        <p style={{ color: '#555', lineHeight: '1.6' }}>
            {post.body}
        </p>
    </div>
);

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    componentDidMount() {
        this.loadPosts();
    }

    // 2. This now perfectly catches errors thrown by <PostItem />
    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("An error occurred while rendering the posts: " + error.message);
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                const postList = data.map(item => 
                    new Post(item.userId, item.id, item.title, item.body)
                );
                this.setState({ posts: postList });
            })
            .catch(error => {
                alert("Failed to fetch posts: " + error.message);
            });
    }

    render() {
        if (this.state.hasError) {
            return <h2 style={{ textAlign: 'center', color: 'red' }}>Could not load posts.</h2>;
        }

        return (
            <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
                <h1 style={{ textAlign: 'center', color: '#333' }}>Latest Blog Posts</h1>
                
                {/* 3. We map through the array and render the Child Component */}
                {this.state.posts.map(post => (
                    <PostItem key={post.id} post={post} />
                ))}
            </div>
        );
    }
}

export default Posts;