import React, { Component } from 'react';
import Modal from 'react-responsive-modal'
import { connect } from 'react-redux'
import { getAllSongsInPlaylist } from '../actions/PlaylistActions'
import PropTypes from 'prop-types'

/**
 * Modal containing all playlist songs. Data passed down from Playlist.js component.
 */
class PlaylistSongs extends Component {
    render() {
        if (this.props.playlist == null) {
            return <div></div>
        } else {
            return (
                    <Modal open={this.props.open} onClose={this.props.onClose}>
                        <div className="modal-header"><h3>{this.props.playlist.pname}</h3></div>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Song</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.props.songs.map((song, i) => 
                                    <tr key={i}>
                                        <td>{i}</td>
                                        <td>{song.name}</td>
                                    </tr>    
                                )}
                            </tbody>
                        </table>
                    </Modal>
                );
        }
    }
}


PlaylistSongs.propTypes = {
    getAllSongsInPlaylist: PropTypes.func.isRequired,
    songs: PropTypes.array
}

const mapStateToProps = state => ({
    songs: state.playlists.songs
})

export default connect(mapStateToProps, { getAllSongsInPlaylist })(PlaylistSongs);