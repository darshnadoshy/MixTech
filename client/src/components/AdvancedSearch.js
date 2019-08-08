import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { connect } from 'react-redux' 
import { advancedResults } from '../actions/SearchActions'
import { clearResults } from '../actions/SearchActions'
import InputRange from 'react-input-range'
import 'react-input-range/lib/css/index.css'
import '../css/AdvancedSearch.css'
class AdvancedSearch extends Component {
    constructor(props) {
        super(props);
    
        this.state = {
          key: 0,
          mode: 1,
          danceability: {
              min: 0.0,
              max: 1.0
          },
          energy: {
              min: 0.0,
              max: 1.0
          },
          loudness: {
              min: -60.0,
              max: 0.0
          },
          speechiness: {
              min: 0.0,
              max: 1.0
          },
          acousticness: {
              min: 0.0,
              max: 1.0
          },
          instrumentalness: {
              min: 0.0,
              max: 1.0
          },
          liveness: {
              min: 0.0,
              max: 1.0
          },
          valence: {
              min: 0.0,
              max: 1.0
          },
          tempo: {
              min: 0.0,
              max: 250.0
          },
          duration_ms: {
              min: 1,
              max: 5000
          }
        }
    }
    
    componentWillUnmount() {
        this.props.clearResults()
    }

    handleSubmit = e => {
        e.preventDefault()
        const query = {
            skey: this.state.key,
            smode: this.state.mode,
            danceability0: this.state.danceability.min,
            danceability1: this.state.danceability.max,
            energy0: this.state.energy.min,
            energy1: this.state.energy.max,
            loudness0: this.state.loudness.min,
            loudness1: this.state.loudness.max,
            speechiness0: this.state.speechiness.min,
            speechiness1: this.state.speechiness.max,
            acousticness0: this.state.acousticness.min,
            acousticness1: this.state.acousticness.max,
            instrumentalness0: this.state.instrumentalness.min,
            instrumentalness1: this.state.instrumentalness1.max,
            liveness0: this.state.liveness.min,
            liveness1: this.state.liveness.max,
            tempo0: this.state.tempo.min,
            tempo1: this.state.tempo.max,
            duration_ms0: this.state.duration_ms.min,
            duration_ms1: this.state.duration_ms.max
        }
        this.props.advancedResults(query)
    }
    render() {
        return (
            <div id="asearchContent">
                <div className="container">
                    <div className="container" id="title">
                        <h1>Advanced Search</h1>
                    </div>
                    <div className="container">
                        <form className="form" onSubmit={this.handleSubmit.bind(this)}>
                            <div className="form-row">
                                <div className="col">
                                    <label className="alabel">Key</label>
                                    <select className="form-control" onChange={e => {this.setState({key: e.target.value})}}>
                                        <option value={0}>C</option>
                                        <option value={1}>C#/Db</option>
                                        <option value={2}>D</option>
                                        <option value={3}>D#/Eb</option>
                                        <option value={4}>E</option>
                                        <option value={5}>F</option>
                                        <option value={6}>F#/Gb</option>
                                        <option value={7}>G</option>
                                        <option value={8}>G#/Ab</option>
                                        <option value={9}>A</option>
                                        <option value={10}>A#/Bb</option>
                                        <option value={11}>B</option>
                                    </select>
                                </div>
                                <div className="col">
                                    <label className="alabel">Modality</label>
                                    <select className="form-control" onChange={e => {this.setState({mode: e.target.value})}}>
                                        <option value={1}>Major</option>
                                        <option value={0}>Minor</option>
                                    </select>
                                </div>
                            </div>  
                            <div className="form-row">
                                <div className="col">
                                    <label className="alabel">Danceability</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.danceability}
                                    onChange={value => this.setState({ danceability: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Energy</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.energy}
                                    onChange={value => this.setState({ energy: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Loudness</label>
                                    <InputRange
                                    minValue={-60.0}
                                    maxValue={0.0}
                                    step={0.01}
                                    value={this.state.loudness}
                                    onChange={value => this.setState({ loudness: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                            </div>
                            <div className="form-row">
                                <div className="col">
                                    <label className="alabel">Speechiness</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.speechiness}
                                    onChange={value => this.setState({ speechiness: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Acousticness</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.acousticness}
                                    onChange={value => this.setState({ acousticness: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Instrumentalness</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.instrumentalness}
                                    onChange={value => this.setState({ instrumentalness: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                            </div>
                            <div className="form-row">
                                <div className="col">
                                    <label className="alabel">Liveness</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.liveness}
                                    onChange={value => this.setState({ liveness: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Valence</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={1.0}
                                    step={0.01}
                                    value={this.state.valence}
                                    onChange={value => this.setState({ valence: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                                <div className="col">
                                    <label className="alabel">Tempo</label>
                                    <InputRange
                                    minValue={0.0}
                                    maxValue={250.0}
                                    step={0.01}
                                    value={this.state.tempo}
                                    onChange={value => this.setState({ tempo: value })}
                                    onChangeComplete={value => console.log(value)} />
                                </div>
                            </div>
                            <button className="btn btn-primary">Submit</button>
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
                                    <div className="col"><button type="button" data-toggle="modal" data-target="#songmodal">{song.name}</button></div>
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
            </div>
        );
    }
}

AdvancedSearch.propTypes = {
    advancedResults: PropTypes.func.isRequired,
    clearResults: PropTypes.func.isRequired,
    results: PropTypes.array
}

const mapStateToProps = state => ({
    results: state.SearchResults.results
})

export default connect(mapStateToProps, { advancedResults, clearResults })(AdvancedSearch);