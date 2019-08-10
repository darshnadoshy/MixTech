import React, { Component } from 'react';
import Modal from 'react-responsive-modal'

class ModalWrapper extends Component {
    componentWillMount() {
        
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
                            <button type="button" className="btn btn-secondary">Add to Matches</button>
                            <button type="button" className="btn btn-primary">Add to Playlists</button>
                        </div>
                    </Modal>
                    <Modal>

                    </Modal>
                </div>
            );
        }
    }
    
}

export default ModalWrapper;