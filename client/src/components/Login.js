import React, { Component } from 'react';

class Login extends Component {
    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form>
                        <div className="form-group">
                            <label for="username">Username</label>
                            <input type="text" className="form-control" id="username" placeholder="Enter Username"></input>
                        </div>
                        <div className="form-group">
                            <label for="password">Password</label>
                            <input type="text" className="form-control" id="password" placeholder="Enter Password"></input>
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