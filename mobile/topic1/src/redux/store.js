import {applyMiddleware, compose, createStore} from 'redux';
const enhancerList = [];
const devToolsExtension = window && window.__REDUX_DEVTOOLS_EXTENSION__;
import appReducers from './../reducers/index';
import thunk from 'redux-thunk';

if (typeof devToolsExtension === 'function') {
  enhancerList.push(devToolsExtension());
}
const composedEnhancer = compose(applyMiddleware(thunk));

const initStore = () => createStore(appReducers, {}, composedEnhancer);

module.exports = {
  initStore,
};
