import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { allPlaylists } from '../actions/PlaylistActions'
import { connect } from 'react-redux'
import '../css/Playlists.css'

class Playlist extends Component {
    constructor() {
        super();
        this.state = {
            uid: "",
        }
    }

    componentDidMount() {
        const query = {uid: this.state.uid};
        this.props.allPlaylists(query);
    };

    render() {
        return (
            <div id="playlistContent">
                <div className="container">
                    <div className="container">
                        <h1>My Playlists</h1>
                    </div>
                </div>

                <div className="container" id="results">
                    {this.props.results.map(playlist =>
                        <div>
                            <div className="row align-items-start">
                                <div className="col"><h4>Playlist</h4></div>
                                <div className="col"><h4>Description</h4></div>
                            </div>
                            <div className="row align-items-start border bg-light">
                                <div className="col"><h4>{playlist.pname}</h4></div>
                                <div className="col"><h4>{playlist.description}</h4></div>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        );
    }
}

Playlist.propType = {
    allPlaylists: PropTypes.func.isRequired,
    results: PropTypes.array
};

const mapStateToProps = state => ({
    results: state.SearchResults.results
});

export default connect(mapStateToProps, { allPlaylists })(Playlist);