import React, { Component } from 'react';
import ModalWrapper from './ModalWrapper'
import PropTypes from 'prop-types'
import { basicResults, clearResults, basicMatches } from '../actions/SearchActions'
import { connect } from 'react-redux'
import '../css/Search.css'

/**
 * Component for the Basic Search functionality. State
 * consists of song name, and the ModalWrapper which holds
 * data about the results.
 */

class Search extends Component {
    /**
     * Initialize component state.
     */
    constructor() {
        super()
        this.state = {
            sname: "", // song name to query
            modalOpen: false, // current state of modal
            selected: null // the selected song for modal data
        }
    }

    /**
     * Clear results after leaving search component
     */
    componentWillUnmount() {
        this.props.clearResults()
    }

    /**
     * Updates song name query.
     */
    handleChange = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    /**
     * Submits the form, requesting search to the backend via
     * searchActions.
     */
    handleSubmit = async e => {
        // use awaits for getting data in proper
        e.preventDefault()
        const query = {sname: this.state.sname}
        await this.props.basicResults(query)
        await this.props.basicMatches(query)
    }

    /**
     * Change state of selected and modalOpen. Opens the modal
     * to show data.
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
            <div id="searchContent">
                <div className="container" id="form">
                    <form onSubmit={this.handleSubmit.bind(this)}>
                        <div className="form-group"> 
                            <label htmlFor="search"><h1>Search</h1></label>
                            <input type="text" className="form-control" name="sname" placeholder="Enter song name"
                            onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <button type="submit" className="btn btn-primary">Search</button>
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
                <div className="container" id="matchResults">
                    <h4>Complete Matches</h4>
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Song 1</th>
                                <th scope="col">Song 2</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.matches.map((match, i) => 
                                <tr key={i}>
                                    <td>{match.song1}</td>
                                    <td>{match.song2}</td>
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

Search.propTypes = {
    basicResults: PropTypes.func.isRequired,
    clearResults: PropTypes.func.isRequired,
    basicMatches: PropTypes.func.isRequired,
    results: PropTypes.array
}

const mapStateToProps = state => ({
    results: state.SearchResults.results,
    matches: state.SearchResults.matches
})

export default connect(mapStateToProps, { basicResults, clearResults, basicMatches })(Search);