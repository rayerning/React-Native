/**
 * 
 * @flow
 */
import React, { Component } from "react";
import {Image, FlatList, StyleSheet, Text, View } from "react-native";

var REQUEST_URL = 'https://raw.githubusercontent.com/facebook/react-native/0.51-stable/docs/MoviesExample.json';

export default class MoviesList extends Component {

    constructor (props) {
        super(props);
        this.state = {
            movies: null,
        };

        this.fetchData = this.fetchData.bind(this);
    }

    componentDidMount() {
        this.fetchData();
    }
    
    fetchData() {
        fetch(REQUEST_URL)
        .then((response) => response.json)
        .then((responseJson) => {
            this.setState({
                movies : responseJson.movies,
            });
        })
    }

    render() {
        if(!this.state.movies) {
            return this.renderLoadingView();
        }

        var movie = this.state.movies[0];
        return this.renderMovie(movie);
    }

    renderLoadingView() {
        return (
            <View style={styles.container}>
                <Text>
                    正在加载电影数据……
                </Text>
            </View>
        );
    }

    renderMovie(movie) {
        return (
            <View style={styles.container}>
                <Image source={{uri:movie.posters.thumbnail}}
                style={styles.thumbnail}/>
                <View style = {styles.rightContainer}>
                    <Text style={styles.title}>{movie.title}</Text>
                    <Text style={styles.year}>{movie.year}</Text>
                </View>
            </View>
        );
    }

    renderMovieList() {
        return(
            <FlatList
            data={this.state.data}
            renderItem={this.renderMovie}
            keyExtractor={item => item.id}
            />
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

function timeout_fetch(fetch_promise, timeout = 10000) {
    let timeout_fn = null;

    let timeout_promise = new Promise(function (resolve, reject) {
        timeout_fn = function () {
            reject("timeout promise");
        }
    });

    let abortable_promise = Promise.race([fetch_promise, timeout_promise]);
    
    setTimeout(() => {
       timeout_fn(); 
    }, timeout);

    return abortable_promise
}