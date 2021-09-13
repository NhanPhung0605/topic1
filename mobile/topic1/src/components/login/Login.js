import React, {Component} from 'react';
import {Text, TextInput, TouchableOpacity, View} from 'react-native';
import Styles from './Login.style';
import callApi from '../../utils/api';
import * as ConfigServer from '../../constants/ConfigServer';
import AsyncStorage from '@react-native-async-storage/async-storage';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      errorMessage: '',
      password: '',
    };
  }

  onChange = (value, prop) => {
    const state = this.state;
    state[prop] = value;
    this.setState(state);
  };

  onLogin = () => {
    const {username, password} = this.state;
    const login = {
      username: username,
      password: password,
    };
    const {navigation} = this.props;
    callApi(ConfigServer.USER_LOGIN, 'POST', login).then((res) => {
      if (res.status === 200) {
        const {token, username} = res.data;
        const userInfo = {
          username,
          token,
        };
        AsyncStorage.setItem('userInfo', JSON.stringify(userInfo));
        navigation.navigate('Welcome');
      } else {
        this.setState({
          errorMessage: 'Username or Password does not existed.',
        });
      }
    });
  };

  render() {
    return (
      <View style={Styles.container}>
        <Text style={{color: 'red'}}>{this.state.errorMessage}</Text>
        <Text style={Styles.textTitle}>Login</Text>

        <View style={Styles.inputContainer}>
          <TextInput
            style={Styles.inputs}
            placeholder={'Username'}
            autoCapitalize="none"
            onChangeText={(value) => this.onChange(value, 'username')}
            value={this.state.username}
          />
        </View>
        <View style={Styles.inputContainer}>
          <TextInput
            style={Styles.inputs}
            autoCapitalize="none"
            placeholder={'Password'}
            secureTextEntry={true}
            onChangeText={(value) => this.onChange(value, 'password')}
            value={this.state.password}
          />
        </View>
        <TouchableOpacity
          style={[Styles.buttonContainer, Styles.loginButton]}
          onPress={() => this.onLogin()}>
          <Text style={Styles.loginText}>Login</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
export default Login;
