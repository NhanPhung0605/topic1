import React, {Component} from 'react';
import {Text, TextInput, TouchableOpacity, View} from 'react-native';
import Styles from './Login.style';
import AsyncStorage from '@react-native-async-storage/async-storage';
import Icon from 'react-native-vector-icons/FontAwesome5';
import {login} from '../../actions';
import DialogInput from 'react-native-dialog-input';
import {USER_INFO, CONFIG_SERVER} from '../../constants/ActionTypes';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      errorMessage: '',
      username: '',
      password: '',
      isDialogVisible: false,
      configServer: '',
    };
  }

  onChange = (value, prop) => {
    const state = this.state;
    state[prop] = value;
    this.setState(state);
  };

  onLogin = () => {
    const {username, password} = this.state;
    const loginDTO = {
      username: username,
      password: password,
    };
    const {navigation} = this.props;
    login(loginDTO).then((res) => {
      if (res.status === 200) {
        const {token, username} = res.data;
        const userInfo = {
          username,
          token,
        };
        AsyncStorage.setItem(USER_INFO, JSON.stringify(userInfo));
        navigation.navigate('Welcome');
      }
    });
  };

  showDialog(isShow) {
    this.setState({isDialogVisible: isShow});
  }
  sendInput(inputText) {
    AsyncStorage.setItem(CONFIG_SERVER, inputText);
    this.showDialog(false);
  }

  openSettingPopup = () => {
    this.showDialog(true);
  };

  render() {
    return (
      <View style={Styles.container}>
        <Icon
          name="cog"
          size={24}
          style={{position: 'absolute', top: 16, right: 16}}
          onPress={this.openSettingPopup}
        />
        <DialogInput
          isDialogVisible={this.state.isDialogVisible}
          title={'Input server'}
          submitInput={(inputText) => {
            this.sendInput(inputText);
          }}
          closeDialog={() => {
            this.showDialog(false);
          }}
        />
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
