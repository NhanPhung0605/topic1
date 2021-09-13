import axios from 'axios';
import * as ConfigServer from './../constants/ConfigServer';

export default function callApi(endpoint, method, body) {
  return axios({
    method: method,
    url: `${ConfigServer.API_URL}/${endpoint}`,
    data: body,
  }).catch((err) => {
    console.log(err);
  });
}
