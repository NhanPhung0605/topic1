import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';
import {CONFIG_SERVER} from '../constants/ActionTypes';

export default async function callApi(endpoint, method, body, param) {
  const URL = await AsyncStorage.getItem(CONFIG_SERVER);
  return axios({
    method: method,
    url: `${URL}/${endpoint}`,
    data: body,
    params: param,
  }).catch((err) => {
    console.log(err);
  });
}
