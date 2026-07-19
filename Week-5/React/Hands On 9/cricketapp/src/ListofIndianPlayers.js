import React from 'react';

export const ListofIndianPlayers = ({ IndianPlayers }) => (
  <div>
    {IndianPlayers.map((player, index) => (
      <li key={index}>Mr. {player}</li>
    ))}
  </div>
);