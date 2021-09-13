import Login from './src/components/login/Login';
import Welcome from './src/components/Welcome/Welcome';

const routes = [
  {
    path: '/login',
    exact: false,
    main: () => <Login />,
  },
  {
    path: '/welcome',
    exact: false,
    main: () => <Welcome />,
  },
];
export default routes;
