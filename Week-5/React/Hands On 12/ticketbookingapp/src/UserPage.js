import React, { useState } from 'react';

function UserPage() {
  const [from, setFrom] = useState('');
  const [to, setTo] = useState('');

  const handleBookNow = () => {
    if (!from || !to) {
      alert("Please enter both From and To locations.");
      return;
    }
    alert("Ticket booked from " + from + " to " + to);
  };

  return (
    <div>
      <h2>Welcome back</h2>
      <h3>Book Your Ticket</h3>
      <div>
        <label>From: </label>
        <input
          type="text"
          placeholder="Departure city"
          value={from}
          onChange={(e) => setFrom(e.target.value)}
        />
      </div>
      <div>
        <label>To: </label>
        <input
          type="text"
          placeholder="Destination city"
          value={to}
          onChange={(e) => setTo(e.target.value)}
        />
      </div>
      <button onClick={handleBookNow}>Book Now</button>
    </div>
  );
}

export default UserPage;