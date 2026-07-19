import React from 'react';

export const ListofPlayers = ({ players }) => (
  <div>
    {players.map((item, index) => (
      <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
    ))}
  </div>
);