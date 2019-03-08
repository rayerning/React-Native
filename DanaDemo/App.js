/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 * @lint-ignore-every XPLATJSCOPYRIGHT1
 */

import React, {Component} from 'react';
import Login from './login/Login';
import HomePage from './login/HomePage';
import {createStackNavigator, createAppContainer} from 'react-navigation';

const AppNavigator = createStackNavigator({
  LoginPage: {screen : Login},
  Home: {screen : HomePage}
},{
  initialRouteName: "LoginPage"
});

const AppContainer = createAppContainer(AppNavigator);

export default class App extends Component {
  render() {
    return <AppContainer /> ;
  }
}


// import React from "react";
// import { View, Text, Button } from "react-native";
// import { createStackNavigator, createAppContainer } from "react-navigation";

// class HomeScreen extends React.Component {
//     render() {
//         return (
//             <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
//                 <Text>Home Screen</Text>
//                 <Button
//                     title="Go to Details"
//                     onPress={() => this.props.navigation.navigate('Details')}
//                 />
//             </View>
//         );
//     }
// }

// class DetailsScreen extends React.Component {
//     render() {
//         return (
//             <View style={{ flex: 1, alignItems: "center", justifyContent: "center" }}>
//                 <Text>Details Screen</Text>
//                 <Button
//                     title="Go to Home"
//                     onPress={() => this.props.navigation.navigate('Home')}
//                 />
//                 <Button
//                     title="Go to Details... again... = F5刷新"
//                     onPress={() => this.props.navigation.push('Details')}
//                 />
//                 <Button
//                     title="Go back"
//                     onPress={() => this.props.navigation.goBack()}
//                 />
//             </View>
//         );
//     }
// }

// const AppNavigator = createStackNavigator({
//     Home: HomeScreen,
//     Details: DetailsScreen
// },{
//     initialRouteName: "Home"
// });

// const AppContainer = createAppContainer(AppNavigator);

// export default class App extends React.Component {
//     render() {
//         return <AppContainer />;
//     }
// }