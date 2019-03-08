import React, {Component} from 'react'
import {View, Button, Image, Text, TextInput, StyleSheet, ToastAndroid} from "react-native"

const styles = StyleSheet.create({
    container : {
        flex : 1,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'gray',
    },

    logo : {
        height: 80,
        width: 80,
        marginTop: 100,
        backgroundColor: '#000000',
    },

    itemContainer : {
        flexDirection: 'row',
        justifyContent: 'center',
        backgroundColor: 'gray',
        alignItems: 'center',
    },

    input : {
        width: 200,
        height: 50,
        margin: 5,
        backgroundColor: '#ffffff',
    },

    title: {
        width: 50,
        height: 50,
        fontSize: 15,
        color:'#ffffff',
        margin:5,
        fontWeight: 'bold',
        textAlign:'center',
        justifyContent:'center',
    },

    button: {
        width: 200,
        height: 50,
        marginTop: 20,
        backgroundColor:'black',
    }

});

export default class Login extends Component {

    static navigationOptions = {
        title: 'Welcome'
    };

    constructor (props) {
        super(props)
        this.state = {
            account:'',
            password:'',
        }
    }

    render() {
        return(
            <View style={styles.container}>
                <Image style={styles.logo} />
                <View style={styles.container}>
                    <View style={styles.itemContainer}>
                        <Text style={styles.title}>账号:</Text>
                        <TextInput style={styles.input} onChangeText = {(acc) => this.onAccountEnd(acc)}></TextInput>
                    </View>
                    <View style={styles.itemContainer}>
                        <Text style={styles.title}>密码:</Text>
                        <TextInput style={styles.input} onChangeText = {(pwd) => this.onPasswordEnd(pwd)}></TextInput>
                    </View>

                    <Button type='button' title ='登陆' onPress = {() => {
                        this.onLoginPress();
                    }}/>
                </View>
            </View>
        );
    }

    onAccountEnd(acc) {
        this.setState({
            account: acc,
        });
        ToastAndroid.show(acc, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    }

    onPasswordEnd(pwd) {
        this.setState({
            password:pwd,
        })
        ToastAndroid.show(pwd, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
    }

    onLoginPress() {
        this.loginWithFetch();       
        // this.getMoviesFromApiAsyn();
        // this.loginWithXMLHttpReuest();
    }

    getMoviesFromApiAsyn() {
        return fetch('https://facebook.github.io/react-native/movies.json')
                .then((response) => response.json())
                .then((responsejson) => {
                    ToastAndroid.show(JSON.stringify(responsejson), ToastAndroid.LONG, ToastAndroid.BOTTOM);
                    return response.movies;
                })
                .catch((error) => {
                    ToastAndroid.show(JSON.stringify(error), ToastAndroid.LONG, ToastAndroid.BOTTOM);
                });
    }

    loginWithXMLHttpReuest() {
        var url = "https://112.74.142.227/v5/user?client_id=9529b01d71f00672750b9c94063402c2&token=0.notoken";
        var date = new Date().getTime();   
        var bodies = JSON.stringify({
            "body":{ 
              "app_core":1,
              "app_did":"c3b7fd012ac8403dTPG5T18323021582",
              "app_lang":"ZH-HANS-CN",
              "client_id":"9529b01d71f00672750b9c94063402c2",
              "client_type":1,
              "location":",",
              "phone_code":"86",
              "push_id":"",
              "terminal_check":0,
              "terminal_device_id":"c3b7fd012ac8403dTPG5T18323021582",
              "terminal_device_name":"HWI-AL00",
              "terminal_device_type":"268.0.0",
              "user_name":"18740476836",
              "user_pass":"123456",
              "user_type":2
            },
            "dana_time":date,
            "app_did":"c3b7fd012ac8403dTPG5T18323021582",
            "cmd":"UserLogin",
            "page":0,
            "page_size":0,
            "request_id":0
          });

        var httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = function() {
            console.log("readystatus = " + httpRequest.readyState)
            console.log("status = " + httpRequest.status)
            console.log("responseText = " + httpRequest.responseText)
            console.log("responsejson = " + httpRequest.responsejson);
            console.log("response = " + httpRequest.response);
        };
        httpRequest.open('POST', url, true);
        httpRequest.setRequestHeader("Content-Type", "application/json");
        httpRequest.send(bodies);
    }

    loginWithFetch() {
        var url = "https://112.74.142.227/v5/user?client_id=9529b01d71f00672750b9c94063402c2&token=0.notoken";
        var date = new Date().getTime();
        var user_name = this.state.account;
        var user_pass = this.state.password;
        var bodies = JSON.stringify({
            "body":{ 
              "app_core":1,
              "app_did":"c3b7fd012ac8403dTPG5T18323021582",
              "app_lang":"ZH-HANS-CN",
              "client_id":"9529b01d71f00672750b9c94063402c2",
              "client_type":1,
              "location":",",
              "phone_code":"86",
              "push_id":"",
              "terminal_check":0,
              "terminal_device_id":"c3b7fd012ac8403dTPG5T18323021582",
              "terminal_device_name":"HWI-AL00",
              "terminal_device_type":"268.0.0",
              "user_name":user_name,
              "user_pass":user_pass,
              "user_type":2
            },
            "dana_time":date,
            "app_did":"c3b7fd012ac8403dTPG5T18323021582",
            "cmd":"UserLogin",
            "page":0,
            "page_size":0,
            "request_id":0
          });
        // console.log(bodies);
        return fetch(url, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: bodies,
        })
        .then((response) => response.json())
        .then((responsejson) => {
            if(responsejson.code == 0) {
                console.log("response : ");
                console.log(responsejson);
                this.props.navigation.navigate('Home');
                ToastAndroid.show("success", ToastAndroid.SHORT, ToastAndroid.BOTTOM);

            } else{
                ToastAndroid.show(responsejson.code_msg, ToastAndroid.SHORT, ToastAndroid.BOTTOM);
            }

        })
        .catch(error => {
            console.error(error);
        });
    }
}