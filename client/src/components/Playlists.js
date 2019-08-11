import React, { Component } from 'react';
import PropTypes from 'prop-types'
import Modal from 'react-responsive-modal'
import { allPlaylists, addPlaylist, deletePlaylist } from '../actions/PlaylistActions'
import { connect } from 'react-redux'
import '../css/Playlists.css'

class Playlist extends Component {
    state = {
        openModal: false,
        pname: '',
        description: ''
    }

    componentWillMount() {
        this.props.allPlaylists();
    };

    onOpenModal = () => {
        this.setState({ openModal: true })
    }

    onCloseModal = () => {
        this.setState({ openModal: false })
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value})
        console.log(this.state)
    }

    handleSubmit = (e) => {
        e.preventDefault()
        const data = {
            pname: this.state.pname,
            privacy: 0,
            description: this.state.description
        }
        this.props.addPlaylist(data)
        window.location.reload()
    }

    clickHandler = async e => {
        await this.props.deletePlaylist(e.target.value)
        window.location.reload()
    }
    render() {
        return (
            <div id="playlistContent">
                <div id="playlistTitle">
                    <h1>My Playlists</h1>
                    <button className="btn btn-outline-primary btn-sm" onClick={this.onOpenModal}>Add Playlist</button>
                </div>
                <div id="playlistTable">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Playlist</th>
                                <th scope="col">Description</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.results.map((playlist, i) => 
                                <tr key={i}>
                                    <td>{playlist.pname}</td>
                                    <td>{playlist.description}</td>
                                    <td><button className="btn btn-outline-danger btn-sm" value={playlist.pid} onClick={this.clickHandler}>Delete</button></td>
                                </tr>     
                            )}
                        </tbody>
                    </table>
                </div>
                <Modal open={this.state.openModal} onClose={this.onCloseModal}>
                    <div className="container">
                        <form onSubmit={this.handleSubmit.bind(this)}>
                            <div className="form-group">
                                <label>Playlist Name</label>
                                <input type="text" className="form-control" name="pname" onChange={this.handleChange}></input>
                            </div>
                            <div className="form-group">
                                <label>Description</label>
                                <textarea className="form-control" name="description" onChange={this.handleChange}></textarea>
                            </div>
                            <button type="submit" className="btn btn-primary">Add Playlist</button>
                        </form>
                    </div>
                </Modal>
            </div>
        );
    }
}

Playlist.propType = {
    allPlaylists: PropTypes.func.isRequired,
    addPlaylist: PropTypes.func,
    deletePlaylist: PropTypes.func,
    results: PropTypes.array
};

const mapStateToProps = state => ({
    results: state.playlists.results
});

export default connect(mapStateToProps, { allPlaylists, addPlaylist, deletePlaylist })(Playlist);