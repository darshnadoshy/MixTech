import React, { Component } from 'react';

class Playlists extends Component {
    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <h1>My Playlists</h1>
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

export default Playlists;