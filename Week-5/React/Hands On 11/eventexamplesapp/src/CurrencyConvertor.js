import React, { Component } from 'react';

export class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: '',
      currency: ''
    };
    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleAmountChange(event) {
    this.setState({ amount: event.target.value });
  }

  handleCurrencyChange(event) {
    this.setState({ currency: event.target.value });
  }

  handleSubmit() {
    const euroValue = this.state.amount * 80;
    alert("Converting to Euro Amount is " + euroValue);
  }

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>

        <div>
          <label>Amount: </label>
          <input
            type="text"
            value={this.state.amount}
            onChange={this.handleAmountChange}
          />
        </div>

        <div>
          <label>Currency: </label>
          <input
            type="text"
            value={this.state.currency}
            onChange={this.handleCurrencyChange}
          />
        </div>

        <button onClick={this.handleSubmit}>Submit</button>
      </div>
    );
  }
}