import React, { Component } from 'react';
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
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

// const style = {
//     position: 'absolute',
//     left: '50%',
//     top: '25%',
//     transform: 'translate(-50%, -50%)'
// }

export default Matches;