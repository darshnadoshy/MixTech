import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { basicResults } from '../actions/SearchActions'
import { clearResults } from '../actions/SearchActions'
import { connect } from 'react-redux'
import '../css/Search.css'


class Search extends Component {
    constructor() {
        super()
        this.state = {
            sname: "",
        }
    }

    componentWillUnmount() {
        this.props.clearResults()
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    handleSubmit = e => {
        e.preventDefault()
        const query = {sname: this.state.sname}
        this.props.basicResults(query)
    }   

    render() {
        return (
            <div id="searchContent">
                <div className="container" id="form">
                    <h1>Search</h1>
                    <form onSubmit={this.handleSubmit.bind(this)}>
                        <div className="form-group"> 
                            {/* <label htmlFor="search">Search</label> */}
                            <input type="text" className="form-control" name="sname" placeholder="Enter song name"
                            onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <button type="submit" className="btn btn-primary">Search</button>
                    </form>
                </div>
                <div className="container" id="results">
                    {this.props.results.map(song => 
                        <div>
                            <h3>Results</h3>
                            <div className="row align-items-start">
                                <div className="col"><h4>Song Name</h4></div>
                                <div className="col"><h4>Key</h4></div>
                                <div className="col"><h4>Tempo</h4></div>
                            </div>
                            <div className="row align-items-start border bg-light">
                                <div className="col"><button className="btn btn-light btn-lg" data-toggle="modal" data-target="#songmodal">{song.name}</button></div>
                                <div className="col"><h4>{song.key}</h4></div>
                                <div className="col"><h4>{song.tempo}</h4></div>
                            </div>
                            <div className="modal" id="songmodal" tabIndex="-1" role="dialog" aria-labelledby="songmodal" aria-hidden="true">
                                <div className="modal-dialog" role="document">
                                    <div className="modal-content">
                                        <div className="modal-header">
                                            <h5 className="modal-title" id="exampleModalLabel">{song.name}</h5>
                                            <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div className="modal-body container">
                                            <div className="row">
                                                <div className="col">Song Name</div>
                                                <div className="col">{song.name}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Album Name</div>
                                                <div className="col">{song.album_name}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Danceability</div>
                                                <div className="col">{song.danceability}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Energy</div>
                                                <div className="col">{song.energy}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Key</div>
                                                <div className="col">{song.key}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Loudness</div>
                                                <div className="col">{song.loudness}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Mode</div>
                                                <div className="col">{song.mode}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Speechiness</div>
                                                <div className="col">{song.speechiness}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Acousticness</div>
                                                <div className="col">{song.acousticness}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Instrumentalness</div>
                                                <div className="col">{song.instrumentalness}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Liveness</div>
                                                <div className="col">{song.liveness}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Valence</div>
                                                <div className="col">{song.valence}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Tempo</div>
                                                <div className="col">{song.tempo}</div>
                                            </div>
                                            <div className="row">
                                                <div className="col">Duration</div>
                                                <div className="col">{song.duration}</div>
                                            </div>
                                        </div>
                                        <div className="modal-footer">
                                            <button type="button" className="btn btn-secondary" data-dismiss="modal">Add song</button>
                                            <button type="button" className="btn btn-primary">Add match</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        </div>    
                    )}
                </div>
                
                
            </div>

        );
    }
}

Search.propTypes = {
    basicResults: PropTypes.func.isRequired,
    clearResults: PropTypes.func.isRequired,
    results: PropTypes.array
}

const mapStateToProps = state => ({
    results: state.SearchResults.results
})

export default connect(mapStateToProps, { basicResults, clearResults })(Search);