import React, { Component } from 'react';
import { CurrencyConvertor } from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };

    // Binding "this" so it refers to the component instance inside the handlers
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
  }

  // Increment button: updates counter AND says hello with a static message
  increment() {
    const newCount = this.state.count + 1;
    this.setState({ count: newCount });
    alert("Hello! Member " + newCount);
  }

  decrement() {
    this.setState({ count: this.state.count - 1 });
  }

  // Takes "welcome" as an argument, as required by the spec
  sayWelcome(message) {
    alert(message);
  }

  // Synthetic event handler — React wraps the native click event in a SyntheticEvent
  handleOnPress = (event) => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1>Event Examples</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>

        <br /><br />
        <button onClick={this.handleOnPress}>Click on me</button>

        <hr />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;