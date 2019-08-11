import React, { Component } from 'react';
import Modal from 'react-responsive-modal'
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { incompleteMatches } from '../actions/MatchActions'
import Matches from './Matches';


class ModalWrapper extends Component {
    state = {
        openAddMatches: false,
        openAddPlaylists: false
    }


    componentWillMount() {
        this.props.incompleteMatches()
    }

    onOpenMatches = async e => {
        this.setState({ openAddMatches: true});
    }

    onCloseMatches = () => {
        this.setState({ openAddMatches: false });
    }

    onOpenPlaylists = async e => {
        this.setState({ openAddPlaylists: true});
    }

    onClosePlaylists = () => {
        this.setState({ openAddPlaylists: false });
    }

    handleNewMatch = async () => {
        await fetch(`http://localhost:8080/match/create/${localStorage.getItem('uid')}`, {
            method: 'POST',
            crossDomain: true,
            body: JSON.stringify(this.props.song.id),
            headers: {
                "Content-Type": "application/json"
            }
            }).then(res => res.json())
            .then(res => {
                console.log(res)
            
            }).catch(err => console.log(err))
        
        this.onCloseMatches()

    }

    render() {
        if (this.props.song == null) {
            return <div></div>
        } else {
            return (
                <div>
                    <Modal open={this.props.open} onClose={this.props.onClose}>
                        <div className="modal-header"><h2>{this.props.song.name} from {this.props.song.album_name}</h2></div>
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
                                    <td>{this.props.song.key}</td>
                                </tr>
                                <tr>
                                    <td>Mode</td>
                                    <td>{this.props.song.mode}</td>
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
                                    <td>{this.props.song.key}</td>
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
                            <button type="button" className="btn btn-primary">Add to Playlists</button>
                        </div>
                    </Modal>
                    <Modal open={this.state.openAddMatches} onClose={this.onCloseMatches}>
                        <h4>Incomplete Matches</h4>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th scope="col">Match Name</th>
                                    <th scope="col">Song 1</th>
                                    <th scope="col">Song 2</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.props.incompleteResults.map(match => 
                                    <tr>
                                        <td>{match.matchName}</td>
                                        <td>{match.song1}</td>
                                        <td>{match.song2}</td>
                                    </tr>  
                                )}
                            </tbody>
                        </table>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" onClick={this.handleNewMatch}>Add New Match</button>
                            <button type="button" className="btn btn-primary">Add to Selected Match</button>
                        </div>
                    </Modal>
                </div>
            );
        }
    }
    
}

Matches.propTypes = {
    incompleteMatches: PropTypes.func.isRequired,
    //addNewMatch: PropTypes.func.isRequired
}

const mapStateToProps = state => ({
    incompleteResults: state.matches.incompleteResults
})

export default connect(mapStateToProps, { incompleteMatches })(ModalWrapper);