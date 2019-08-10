import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { completeMatches, incompleteMatches } from '../actions/MatchActions'
import '../css/Matches.css'

class Matches extends Component {
    // componentWillMount() {
    //     this.props.completeMatches()
    //     this.props.incompleteMatches()
    // }
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
                                <th scope="col">Match Name</th>
                                <th scope="col">Song 1</th>
                                <th scope="col">Song 2</th>
                            </tr>
                        </thead>
                        <tbody>
                            {/* {this.props.completeResults.map(match => 
                                <tr>
                                    <td>{match.matchName}</td>
                                    <td>{match.song1}</td>
                                    <td>{match.song2}</td>
                                </tr>  
                            )} */}
                        </tbody>
                    </table>
                </div>
                <div className="matchesTable">
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
                            {/* {this.props.incompleteResults.map(match => 
                                <tr>
                                    <td>{match.matchName}</td>
                                    <td>{match.song1}</td>
                                    <td>{match.song2}</td>
                                </tr>  
                            )} */}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

Matches.propType = {
    allMatches: PropTypes.func.isRequired,
    completeResults: PropTypes.array,
    incompleteResults: PropTypes.array
};

const mapStateToProps = state => ({
    completeResults: state.matches.results,
    incompleteResults: state.matches.results

})


export default connect(mapStateToProps, { completeMatches, incompleteMatches })(Matches);