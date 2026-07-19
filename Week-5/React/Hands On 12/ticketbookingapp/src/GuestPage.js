import React from 'react';

function GuestPage() {
  const flights = [
    { id: 1, from: "Chennai", to: "Bengaluru", time: "08:00 AM", price: "₹3,200" },
    { id: 2, from: "Chennai", to: "Delhi", time: "11:30 AM", price: "₹5,800" },
    { id: 3, from: "Chennai", to: "Mumbai", time: "04:45 PM", price: "₹4,500" }
  ];

  return (
    <div>
      <h2>Please sign up.</h2>
      <h3>Available Flights</h3>
      {flights.map((flight) => (
        <div key={flight.id} style={{ marginBottom: '10px' }}>
          <p>{flight.from} → {flight.to} | {flight.time} | {flight.price}</p>
        </div>
      ))}
      <p><em>Log in to book a ticket.</em></p>
    </div>
  );
}

export default GuestPage;