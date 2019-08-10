import React, { Component } from 'react';

class Modal extends Component {
    render() {
        return (
            <div className="modal" id="songmodal" tabIndex="-1" role="dialog" aria-labelledby="songmodal" aria-hidden="true">
                <div className="modal-dialog" role="document">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h5 className="modal-title" id="exampleModalLabel">{this.props.song.name} - {this.props.song.album_name}</h5>
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div className="modal-body container">
                            <table className="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Feature</th>
                                        <th scope="col">Value</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">Key</th>
                                        <td>{this.props.song.key}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Mode</th>
                                        <td>{this.props.song.mode}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Tempo</th>
                                        <td>{this.props.song.tempo}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Time Signature</th>
                                        <td>{this.props.song.timesignature}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Duration</th>
                                        <td>{this.props.song.duration}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Danceability</th>
                                        <td>{this.props.song.danceability}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Energy</th>
                                        <td>{this.props.song.energy}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Loudness</th>
                                        <td>{this.props.song.loudness}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Speechiness</th>
                                        <td>{this.props.song.speechiness}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Acousticness</th>
                                        <td>{this.props.song.acousticness}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Instrumentalness</th>
                                        <td>{this.props.song.instrumentalness}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Liveness</th>
                                        <td>{this.props.song.liveness}</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Valence</th>
                                        <td>{this.props.song.valence}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-secondary" data-dismiss="modal">Add song</button>
                            <button type="button" className="btn btn-primary">Add match</button>
                        </div>
                    </div>
                </div> 
            </div>
        );
    }
}

export default Modal;