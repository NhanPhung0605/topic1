const {createStackNavigator} = require('react-navigation-stack');
import Welcome from '../../components/welcome/Welcome';
import Form from '../../components/form/Form';
const AppTabs = createStackNavigator({
  // welcome
  Welcome: {
    screen: Welcome,
  },
  // form
  Form: {
    screen: Form,
  },
});
export default AppTabs;
