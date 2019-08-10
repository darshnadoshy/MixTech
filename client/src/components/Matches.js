import React, { Component } from 'react';
import PropTypes from 'prop-types'
import { connect } from 'react-redux'
import { allMatches } from '../actions/MatchActions'
import '../css/Matches.css'

class Matches extends Component {
    
    render() {
        return (
            <div id="matchesContent">
                <div id="matchesTitle">
                    <h1>My Matches</h1>
                </div>
                <div id="matchesTable">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Match Name</th>
                                <th scope="col">Song 1</th>
                                <th scope="col">Song 2</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.results.map(match => 
                                <tr>
                                    <td>{match.mname}</td>
                                    <td>{match.song1}</td>
                                    <td>{match.song2}</td>
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
    allPlaylists: PropTypes.func.isRequired,
    results: PropTypes.array
};

const mapStateToProps = state => ({
    results: state.matches.results
})


export default connect(mapStateToProps, { allMatches })(Matches);