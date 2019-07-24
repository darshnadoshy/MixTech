import React, { Component } from 'react';

class Login extends Component {
    state = {
        username: "",
        password: "",
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value}) // event is a hashmap
    }

    handleSubmit = e => {
        
    }

    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label for="username">Username</label>
                            <input type="text" className="form-control" id="username" placeholder="Enter Username"
                            onChange={this.handleChange}></input>
                        </div>
                        <div className="form-group">
                            <label for="password">Password</label>
                            <input type="text" className="form-control" id="password" placeholder="Enter Password"
                            onChange={this.handleChange}></input>
                        </div>
                        <button type="submit" className="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        );
    }
}

// const parentDiv = {
//     textAlign: 'center'
// }

const style = {
    position: 'absolute',
    left: '50%',
    top: '50%',
    transform: 'translate(-50%, -50%)'
}


export default Login;