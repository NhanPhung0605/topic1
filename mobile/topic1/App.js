/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {Component} from 'react';
import {Provider} from 'react-redux';
import {initStore} from './src/redux/store';
import RootAppNavigator from './src/navigates';

const store = initStore();

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <RootAppNavigator />
      </Provider>
    );
  }
}

export default App;
