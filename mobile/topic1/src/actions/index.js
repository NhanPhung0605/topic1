import callApi from '../utils/api';
import * as ConfigServer from '../constants/ConfigServer';

export function login(login) {
  return callApi(ConfigServer.USER_LOGIN, 'POST', login).then((res) => res);
}
export function scanningForm(param) {
  return callApi(ConfigServer.FORM_SCAN, 'GET', null, param).then((res) => res);
}
export function addForm(body) {
  return callApi(ConfigServer.ADD_FORM, 'POST', body).then((res) => res);
}

export function uploadFile(file) {
  return callApi(ConfigServer.UPLOAD_FILE, 'POST', file).then((res) => res);
}
