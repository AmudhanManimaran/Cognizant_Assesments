import React from 'react';

function App() {
  const element = "Office Space";

  const sr = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=400";
  const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;

  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };

  // Conditional color logic exactly as per the hint
  let colors = [];
  if (ItemName.Rent <= 60000) {
    colors.push('textRed');
  } else {
    colors.push('textGreen');
  }

  // Array of office objects for the list/loop requirement
  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Harborview Corporate Park", Rent: 72000, Address: "Chennai" },
    { Name: "Greenfield Tech Tower", Rent: 48000, Address: "Chennai" },
    { Name: "Riverside Executive Suites", Rent: 81000, Address: "Chennai" }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>{element}, at Affordable Range</h1>

      {jsxatt}

      <h1>Name: {ItemName.Name}</h1>
      <h3 className={colors[0]}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>

      <hr />

      {officeList.map((item, index) => {
        let itemColor = item.Rent <= 60000 ? 'textRed' : 'textGreen';
        return (
          <div key={index} style={{ marginBottom: '15px' }}>
            <h1>Name: {item.Name}</h1>
            <h3 className={itemColor}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;