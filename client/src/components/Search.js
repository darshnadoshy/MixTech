import React, { Component } from 'react';

class Search extends Component {
    constructor() {
        super()
        this.state = {
            sname: "",
            results: []  
        }
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    handleSubmit = e => {
        fetch('http:localhost:8080/search/basic', {
            method: 'GET',
            crossDomain: true,
            body:  JSON.stringify(this.state.sname),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            const songs = res.json()
            this.setState({
                results: songs.map(song => ({
                    name: song.sname,
                    album_name: song.album_name,
                    artist: song.mname,
                    danceability: song.danceability,
                    energy: song.energy,
                    key: song.key,
                    loudness: song.loudness,
                    mode: song.mode,
                    speechiness: song.speechiness,
                    acousticness: song.acousticness,
                    instrumentalness: song.instrumentalness,
                    liveness: song.liveness,
                    valence: song.valence,
                    tempo: song.tempo,
                    duration: song.duration
                })).catch(err => console.log(err))
            })
            
        })}   

    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group"> 
                            <label for="search">Search</label>
                            <input type="text" className="form-control" name="sname" placeholder="Enter song name"
                            onChange={this.handleChange}></input>
                            <button type="submit" className="btn btn-primary">Search</button>
                        </div>
                    </form>
                    <div className="container">
                        <ul className="list-group">
                            {this.state.results.map(song => 
                                <ul className="list-group-horizontal">
                                    <li className="list-group-item">{this.results.name}</li>
                                    <li className="list-group-item">{this.results.album_name}</li> 
                                    <li className="list-group-item">{this.results.artist}</li> 
                                    <li className="list-group-item">{this.results.danceability}</li> 
                                    <li className="list-group-item">{this.results.energy}</li> 
                                    <li className="list-group-item">{this.results.key}</li> 
                                    <li className="list-group-item">{this.results.loudness}</li> 
                                    <li className="list-group-item">{this.results.mode}</li> 
                                    <li className="list-group-item">{this.results.speechiness}</li> 
                                    <li className="list-group-item">{this.results.acousticness}</li> 
                                    <li className="list-group-item">{this.results.instrumentalness}</li> 
                                    <li className="list-group-item">{this.results.liveness}</li> 
                                    <li className="list-group-item">{this.results.valence}</li> 
                                    <li className="list-group-item">{this.results.tempo}</li> 
                                    <li className="list-group-item">{this.results.duration}</li>  
                                </ul>       
                            )}
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}


const style = {
    position: 'absolute',
    left: '50%',
    top: '25%',
    transform: 'translate(-50%, -50%)'
}

export default Search;