import React, {useState} from 'react';
import Styles from './Welcome.style';
import {
  Text,
  TouchableOpacity,
  SafeAreaView,
  ScrollView,
  View,
  StatusBar,
  Button,
} from 'react-native';
import QRCodeScanner from 'react-native-qrcode-scanner';
import {scanningForm} from '../../actions';
import Icon from 'react-native-vector-icons/FontAwesome5';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as Types from '../../constants/ActionTypes';

const Welcome = (props) => {
  const onLogout = () => {
    const {navigation} = props;
    AsyncStorage.removeItem(Types.USER_INFO);
    AsyncStorage.removeItem(Types.CONFIG_SERVER);
    navigation.navigate('Login');
  };
  const [scan, setScan] = useState(false);
  const [result, setResult] = useState();

  const onSuccess = (e) => {
    setResult(e.data);
    const {navigation} = props;
    scanningForm({formName: e.data}).then((res) => {
      navigation.navigate('Form', {data: res.data});
    });
    setScan(false);
  };

  const startScan = () => {
    setScan(true);
    setResult();
  };

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView>
        <ScrollView
          contentInsetAdjustmentBehavior="automatic"
          style={Styles.scrollView}>
          <View style={Styles.body}>
            <Icon
              name="sign-out-alt"
              size={24}
              style={{position: 'absolute', top: 16, right: 16}}
              onPress={onLogout}
            />
            {result && (
              <View style={Styles.sectionContainer}>
                <Text style={Styles.centerText}>{result}</Text>
              </View>
            )}
            {!scan && (
              <View style={Styles.sectionContainer}>
                <Button
                  title="Start Scan"
                  color="#f194ff"
                  onPress={startScan}
                />
              </View>
            )}

            {scan && (
              <View style={Styles.sectionContainer}>
                <QRCodeScanner
                  reactivate={true}
                  showMarker={true}
                  ref={(node) => {
                    this.scanner = node;
                  }}
                  onRead={onSuccess}
                  topContent={
                    <Text style={Styles.centerText}>Scan your QRCode!</Text>
                  }
                  bottomContent={
                    <TouchableOpacity
                      style={Styles.buttonTouchable}
                      onPress={() => setScan(false)}>
                      <Text style={Styles.buttonText}>Cancel Scan</Text>
                    </TouchableOpacity>
                  }
                />
              </View>
            )}
          </View>
        </ScrollView>
      </SafeAreaView>
    </>
  );
};

export default Welcome;
