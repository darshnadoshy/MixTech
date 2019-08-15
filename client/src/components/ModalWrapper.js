import React, { Component } from 'react';
import Modal from 'react-responsive-modal'
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { incompleteMatches, addNewMatch, addToExistingMatch } from '../actions/MatchActions'
import { allPlaylists, addToExistingPlaylist } from '../actions/PlaylistActions'
import Matches from './Matches';


/**
 * Component displaying all audio feature values of selected song. Data
 * passed down from Search.js or AdvancedSearch.js.
 * Can add new match, add to incomplete match or add to a new playlist.
 */
class ModalWrapper extends Component {
    /**
     * State keeping track of which modal to open.
     */
    state = {
        openAddMatches: false, 
        openAddPlaylists: false,
        selectedMatch: -1, // the match to add to
        selectedPlaylist: -1 // the playlist to add to
    }
    
    /**
     * Load all incomplete matches and playlist before rendering.
     */
    componentWillMount() {
        this.props.incompleteMatches()
        this.props.allPlaylists()
    }

    /**
     * Opens the match modal.
     */
    onOpenMatches = async e => {
        this.setState({ openAddMatches: true});
    }

    /**
     * Closes the match modal.
     */
    onCloseMatches = () => {
        this.setState({ openAddMatches: false });
    }

    /**
     * Opens the playlist modal.
     */
    onOpenPlaylists = async e => {
        this.setState({ openAddPlaylists: true});
    }

    /**
     * Closes the playlist modal.
     */
    onClosePlaylists = () => {
        this.setState({ openAddPlaylists: false });
    }

    /**
     * Adds this song to a new match connects to MatchActions
     */
    handleNewMatch = async () => {
        await this.props.addNewMatch(this.props.song)
        await this.props.incompleteMatches()
        await this.onCloseMatches()
    }

    /**
     * Handles radio buttons for list of matches.
     */
    handleMatchChange = async (e) => {
        await this.setState({ selectedMatch: e.target.selected })
    }

    /**
     * Adds this song to the selected incomplete match.
     * Connects to MatchActions.
     */
    handleMatchSubmit = async (e) => {
        e.preventDefault()
        const req = {
            matchID: this.state.selectedMatch,
            songID: this.props.song.id 
        }
        await this.props.addToExistingMatch(req)
        await this.props.incompleteMatches()
        await this.onCloseMatches()
    }

    /**
     * Handles radio buttons for list of playlists.
     */
    handlePlaylistChange = async (e) => {
        await this.setState({ selectedPlaylist: e.target.selected })
    }

    /**
     * Adds this song to the selected playlist.
     * Connects to PlaylistActions.
     */
    handlePlaylistSubmit = async (e) => {
        e.preventDefault()
        const req = {
            playlistID: this.state.selectedPlaylist,
            songID: this.props.song.id
        }
        await this.props.addToExistingPlaylist(req)
        await this.props.allPlaylists()
        await this.onClosePlaylists()
    }
    
    render() {
        if (this.props.song == null) {
            return <div></div>
        } else {
            return (
                <div>
                    <Modal open={this.props.open} onClose={this.props.onClose}>
                        <div className="modal-header"><h3>{this.props.song.name} from {this.props.song.album_name}</h3></div>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th scope="col">Feature</th>
                                    <th scope="col">Value</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Key</td>
                                    <td>{whichKey(this.props.song.key)}</td>
                                </tr>
                                <tr>
                                    <td>Mode</td>
                                    <td>{whichMode(this.props.song.mode)}</td>
                                </tr>
                                <tr>
                                    <td>Tempo (BPM)</td>
                                    <td>{this.props.song.tempo}</td>
                                </tr>
                                <tr>
                                    <td>Duration</td>
                                    <td>{this.props.song.duration}</td>
                                </tr>
                                <tr>
                                    <td>Danceability</td>
                                    <td>{this.props.song.danceability}</td>
                                </tr>
                                <tr>
                                    <td>Energy</td>
                                    <td>{this.props.song.energy}</td>
                                </tr>
                                <tr>
                                    <td>Valence</td>
                                    <td>{this.props.song.valence}</td>
                                </tr>
                                <tr>
                                    <td>Loudness</td>
                                    <td>{this.props.song.loudness}</td>
                                </tr>
                                <tr>
                                    <td>Liveness</td>
                                    <td>{this.props.song.liveness}</td>
                                </tr>
                                <tr>
                                    <td>Acousticness</td>
                                    <td>{this.props.song.acousticness}</td>
                                </tr>
                                <tr>
                                    <td>Time Signature</td>
                                    <td>{this.props.song.timesignature}</td>
                                </tr>
                                <tr>
                                    <td>Speechiness</td>
                                    <td>{this.props.song.speechiness}</td>
                                </tr>
                                <tr>
                                    <td>Instrumentalness</td>
                                    <td>{this.props.song.instrumentalness}</td>
                                </tr>
                            </tbody>
                        </table>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" onClick={this.onOpenMatches}>Add to Matches</button>
                            <button type="button" className="btn btn-primary" onClick={this.onOpenPlaylists}>Add to Playlists</button>
                        </div>
                    </Modal>
                    <Modal open={this.state.openAddMatches} onClose={this.onCloseMatches}>
                        <div className="modal-header">
                            <h4>Incomplete Matches</h4>
                        </div>
                        <form onSubmit={this.handleMatchSubmit}>
                            <table className="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Song 1</th>
                                        <th scope="col">    </th>
                                    </tr>
                                </thead>
                                <tbody>  
                                    {this.props.incompleteResults.map((match, i) => 
                                        <tr key={i}>
                                            <td>
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio" name="song" selected={match.matchID}
                                                    onChange={this.handleMatchChange}></input>
                                                    <label className="form-check-label">{match.song1}</label>
                                                </div>
                                            </td>
                                            <td>...</td>
                                        </tr>  
                                    )}
                                </tbody>
                            </table>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" onClick={this.handleNewMatch}>Add New Match</button>
                                <button type="submit" className="btn btn-primary">Add to selected Match</button>
                            </div>
                        </form>
                    </Modal>
                    <Modal open={this.state.openAddPlaylists} onClose={this.onClosePlaylists}>
                        <div className="modal-header">
                            <h4>Incomplete Matches</h4>
                        </div>
                        <form onSubmit={this.handlePlaylistSubmit}>
                            <table className="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Playlist</th>
                                        <th scope="col">Description</th>
                                    </tr>
                                </thead>
                                <tbody>  
                                    {this.props.playlists.map((playlist, i) => 
                                        <tr key={i}>
                                            <td>
                                                <div className="form-check">
                                                    <input className="form-check-input" type="radio" name="song" selected={playlist.pid}
                                                    onChange={this.handlePlaylistChange}></input>
                                                    <label className="form-check-label">{playlist.pname}</label>
                                                </div>
                                            </td>
                                            <td>{playlist.description}</td>
                                        </tr>  
                                    )}
                                </tbody>
                            </table>
                            <div className="modal-footer">
                                <button type="submit" className="btn btn-primary">Add to selected Playlist</button>
                            </div>
                        </form>
                    </Modal>
                </div>
            );
        }
    }
    
}

/**
 * Helper function for which mode,
 * Major or Minor.
 * @param {*} value 
 */
const whichMode = (value) => {
    switch(value) {
        case 0: return 'Minor'
        case 1: return 'Major'
        default: return ''
    }
}

/**
 * Helper function for readability of keys.
 * @param value - key value
 */
const whichKey = (value) => {
    switch(value) {
        case 0: return 'C'
        case 1: return 'C#/Db'
        case 2: return 'D'
        case 3: return 'D#/Eb'
        case 4: return 'E'
        case 5: return 'F'
        case 6: return 'F#/Gb'
        case 7: return 'G'
        case 8: return 'G#/Ab'
        case 9: return 'A'
        case 10: return 'A#/Bb'
        case 11: return 'B'
        default: return ''
    }
}

Matches.propTypes = {
    incompleteMatches: PropTypes.func,
    allPlaylists: PropTypes.func,
    addNewMatch: PropTypes.func,
    addToExistingMatch: PropTypes.func,
    addToExistingPlaylist: PropTypes.func,
    incompleteResults: PropTypes.array,
    playlists: PropTypes.array
}

const mapStateToProps = state => ({
    incompleteResults: state.matches.incompleteResults,
    playlists: state.playlists.results
})

export default connect(mapStateToProps, { incompleteMatches, addNewMatch, addToExistingMatch, allPlaylists, addToExistingPlaylist })(ModalWrapper);