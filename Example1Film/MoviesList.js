/**
 * 
 * @flow
 */
import React, { Component } from "react";
import {Image, StyleSheet, Text, View } from "react-native";

export default class MoviesList extends Component {

    render() {
        var movies = MOCKED_MOVIES_DATA[0];
        return (
            <View style={styles.container}>
                <Image source={{ uri: movies.posters.thumbnail }} style={styles.thumbnail}/>
                <View style={styles.rightContainer}>
                    <Text style={styles.title}>{movies.title}</Text>
                    <Text style={styles.year}>{movies.year}</Text>
                </View>
            </View>
        );
    }
}

var MOCKED_MOVIES_DATA = [{
    title : "标题",
    year : "2015",
    posters : {thumbnail : "http://i.imgur.com/UePbdph.jpg"},
}];

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: "#f5fcff",
    },
    thumbnail: {
        width: 53,
        height: 81,
    },
    rightContainer: {
        flex : 1,
    },
    title : {
        fontSize:20,
        marginBottom: 8,
        textAlign: 'center',
    },
    year:{
        textAlign:'center',
    },
});
