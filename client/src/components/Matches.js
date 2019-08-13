import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { completeMatches, incompleteMatches, deleteMatch } from '../actions/MatchActions'
import '../css/Matches.css'

class Matches extends Component {
    async componentWillMount() {
        await this.props.completeMatches()
        await this.props.incompleteMatches()
    }

    clickHandler = async e => {
        await this.props.deleteMatch(e.target.value)
        window.location.reload()
    }

    render() {
        return (
            <div id="matchesContent">
                <div id="matchesTitle">
                    <h1>My Matches</h1>
                </div>
                <div className="matchesTable">
                    <h4>Complete Matches</h4>
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Song 1</th>
                                <th scope="col">Song 2</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.completeResults.map((match, i) => 
                                <tr key={i}>
                                    <td>{match.song1}</td>
                                    <td>{match.song2}</td>
                                    <td><button className="btn btn-outline-danger btn-sm" value={match.matchID} onClick={this.clickHandler}>X</button></td>
                                </tr>  
                            )}
                        </tbody>
                    </table>
                </div>
                <div className="matchesTable">
                    <h4>Incomplete Matches</h4>
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Song 1</th>
                                <th scope="col">Song 2</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.incompleteResults.map((match, i) => 
                                <tr key={i}>
                                    <td>{match.song1}</td>
                                    <td>...</td>
                                    <td><button className="btn btn-outline-danger btn-sm" value={match.matchID} onClick={this.clickHandler}>X</button></td>
                                </tr>  
                            )}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

Matches.propType = {
    completeMatches: PropTypes.func.isRequired,
    incompleteMatches: PropTypes.func.isRequired,
    deleteMatch: PropTypes.func.isRequired,
    completeResults: PropTypes.array,
    incompleteResults: PropTypes.array
};

const mapStateToProps = state => ({
    completeResults: state.matches.completeResults,
    incompleteResults: state.matches.incompleteResults
})


export default connect(mapStateToProps, { completeMatches, incompleteMatches, deleteMatch })(Matches);