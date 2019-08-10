import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { allPlaylists } from '../actions/PlaylistActions'
import { connect } from 'react-redux'
import '../css/Playlists.css'

class Playlist extends Component {

    componentWillMount() {
        this.props.allPlaylists();
    };
    render() {
        return (
            <div id="playlistContent">
                <div id="playlistTitle">
                    <h1>My Playlists</h1>
                </div>
                <div id="playlistTable">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Playlist</th>
                                <th scope="col">Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.results.map(playlist => 
                                <tr>
                                    <td>{playlist.pname}</td>
                                    <td>{playlist.description}</td>
                                </tr>     
                            )}
                        </tbody>
                    </table>
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
    results: state.playlists.results
});

export default connect(mapStateToProps, { allPlaylists })(Playlist);