import React, { Component } from 'react';
import '../css/Matches.css'

class Matches extends Component {
    render() {
        return (
            <div id="matchesContent">
                <div className="container" style={style}>
                    <h1>My Matches</h1>
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

export default Matches;