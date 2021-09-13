const {createStackNavigator} = require('react-navigation-stack');
import Welcome from '../../components/Welcome/Welcome';
const AppTabs = createStackNavigator({
  // Welcome
  Welcome: {
    screen: Welcome,
  },
});
export default AppTabs;
