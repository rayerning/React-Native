/**
 * @format
 * @lint-ignore-every XPLATJSCOPYRIGHT1
 */

import {AppRegistry} from 'react-native';
import App from './App';
import MoviesList from './MoviesList';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => MoviesList);
