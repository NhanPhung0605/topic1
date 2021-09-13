import Login from '../components/login/Login';
import {createStackNavigator} from 'react-navigation-stack';
import {createSwitchNavigator, createAppContainer} from 'react-navigation';
import AppTabs from './Tabs/AppTabs';

const AuthNavigatorConfig = {
  initialRouteName: 'Login',
  header: null,
  headerMode: 'none',
};
const RouteAuthConfigs = {
  Login: Login,
};

const RouteAppConfig = {
  AppTabs: {
    screen: AppTabs,
  },
};

const StackNavigatorConfig = {
  headerMode: 'none',
};

const AuthNavigator = createStackNavigator(
  RouteAuthConfigs,
  AuthNavigatorConfig,
);
const AppNavigator = createStackNavigator(RouteAppConfig, StackNavigatorConfig);

const RootAppNavigator = createSwitchNavigator(
  {
    Auth: AuthNavigator,
    App: AppNavigator,
  },
  {
    initialRouteName: 'Auth',
  },
);
export default createAppContainer(RootAppNavigator);
