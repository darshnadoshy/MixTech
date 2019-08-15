import React, { Component } from 'react';
import ModalWrapper from './ModalWrapper'
import PropTypes from 'prop-types'
import { connect } from 'react-redux' 
import { advancedResults } from '../actions/SearchActions'
import { clearResults } from '../actions/SearchActions'
import InputRange from 'react-input-range'
import 'react-input-range/lib/css/index.css'
import '../css/AdvancedSearch.css'

/**
 * Component implementing Advanced Search functionality.
 * State contains min and max values for every audio feature except key and mode,
 * which are distinct.
 */
class AdvancedSearch extends Component {
    /**
     * States for every audio feature corresponding to the respective
     * InputRange component.
     * @param {*} props 
     */
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
          },
          modalOpen: false, // modal containing song data
          selected: null // the selected song to show
        }
    }
    
    /**
     * Clear advanced search results after leaving
     * component.
     */
    componentWillUnmount() {
        this.props.clearResults()
    }

    /**
     * Submits form with every current state of the InputRange
     * into the query body connecting to SearchActions.
     */
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
            instrumentalness1: this.state.instrumentalness.max,
            liveness0: this.state.liveness.min,
            liveness1: this.state.liveness.max,
            valence0: this.state.valence.min,
            valence1: this.state.valence.max,
            tempo0: this.state.tempo.min,
            tempo1: this.state.tempo.max,
            duration_ms0: this.state.duration_ms.min,
            duration_ms1: this.state.duration_ms.max
        }
        this.props.advancedResults(query)
    }

    /**
     * Sets the selected song to the one user just clicked,
     * opens modal containing data of that song.
     */
    onOpenModal = async e => {
        await this.setState({ selected: e.target.selected })
        this.setState({modalOpen: true})
    }

    /**
     * Closes the modal.
     */
    onCloseModal = () => {
        this.setState({ modalOpen: false });
    }
    
    /**
     * HTML and CSS to display.
     */
    render() {
        return (
            <div id="asearchContent">
                <div className="container" id="form">
                    <form className="form" onSubmit={this.handleSubmit.bind(this)}>
                        <label><h1>Advanced Search</h1></label>
                        <div className="form-row">
                            <div className="col pcol">
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
                            <div className="col pcol">
                                <label className="alabel">Modality</label>
                                <select className="form-control" onChange={e => {this.setState({mode: e.target.value})}}>
                                    <option value={1}>Major</option>
                                    <option value={0}>Minor</option>
                                </select>
                            </div>
                        </div>  
                        <div className="form-row">
                            <div className="col pcol">
                                <label className="alabel">Danceability</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.danceability}
                                onChange={value => this.setState({ danceability: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
                                <label className="alabel">Energy</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.energy}
                                onChange={value => this.setState({ energy: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
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
                            <div className="col pcol">
                                <label className="alabel">Speechiness</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.speechiness}
                                onChange={value => this.setState({ speechiness: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
                                <label className="alabel">Acousticness</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.acousticness}
                                onChange={value => this.setState({ acousticness: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
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
                            <div className="col pcol">
                                <label className="alabel">Liveness</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.liveness}
                                onChange={value => this.setState({ liveness: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
                                <label className="alabel">Valence</label>
                                <InputRange
                                minValue={0.0}
                                maxValue={1.0}
                                step={0.01}
                                value={this.state.valence}
                                onChange={value => this.setState({ valence: value })}
                                onChangeComplete={value => console.log(value)} />
                            </div>
                            <div className="col pcol">
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
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Song</th>
                                <th scope="col">Key</th>
                                <th scope="col">Tempo (BPM)</th>
                                <th scope="col">Popularity</th>
                            </tr>
                        </thead>
                        <tbody>
                        {this.props.results.map((song, i) =>
                            <tr key={i}>
                                <td><button className="btn btn-light btn-lg" selected={song} onClick={(e) => this.onOpenModal(e)}>{song.name}</button></td>
                                <td>{whichKey(song.key)}</td>
                                <td>{song.tempo}</td>
                                <td>{song.popularity}</td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                </div>
                <ModalWrapper open={this.state.modalOpen} onClose={this.onCloseModal} song={this.state.selected}/>
            </div>
        );
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
        default: return '...'
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