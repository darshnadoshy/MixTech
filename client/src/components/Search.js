import React, { Component } from 'react';

class Search extends Component {
    state = {
        name: ""
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value})
    }

    handleSubmit = e => {
    }
    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group"> 
                            <label for="search">Search</label>
                            <input type="text" className="form-control" id="search" placeholder="Enter song name"
                            onChange={this.handleChange}></input>
                            <button type="submit" className="btn btn-primary">Search</button>
                        </div>
                    </form>
                    <div className="container">
                        <h2>Search Results</h2>
                    </div>
                </div>
            </div>
        );
    }
}


const style = {
    position: 'absolute',
    left: '50%',
    top: '25%',
    transform: 'translate(-50%, -50%)'
}

export default Search;