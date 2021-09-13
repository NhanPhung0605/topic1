import React, {Component} from 'react';
import Styles from './Welcome.style';
import {Text, View} from 'react-native';

class Welcome extends Component {
  render() {
    return (
      <View style={Styles.container}>
        <Text style={Styles.textTitle}> Welcome</Text>
      </View>
    );
  }
}
export default Welcome;
