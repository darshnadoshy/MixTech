import React, { Component } from 'react';
import ReactBootstrapSlider from 'react-bootstrap-slider';
import '../css/AdvancedSearch.css'

class AdvancedSearch extends Component {
    constructor() {
        super()
        this.state = {
            results: []
        }
    }
    render() {
        return (
            <div id="asearchContent">
                <div className="container">
                    <div className="container title">
                        <h1>Advanced Search</h1>
                    </div>
                    <form>
                        <div className="form-group">
                            <label for="key">Key</label>
                            <input type="range" className="custom-range" id="key"></input>

                            <label for="key">Tempo</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Duration</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Loudness</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Energy</label>
                            <input type="range" min="0" max="1" step="0.1" className="custom-range" id="key"></input>

                            <label for="key">Danceability</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Valence</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Instrumentalness</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Acousticness</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Liveness</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Speechiness</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <label for="key">Mode</label>
                            <input type="range" class="custom-range" id="key"></input>

                            <ReactBootstrapSlider />
                        </div>
                    </form>
                </div>
                
            </div>
        );
    }
}

export default AdvancedSearch;