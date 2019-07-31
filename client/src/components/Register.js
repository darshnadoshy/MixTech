import React, { Component } from 'react';
//import axios from 'axios';
class Register extends Component {
    constructor () {
        super()
        this.state = {
            uname: "",
            email: "",
            password: ""
        }
    }

    handleChange = e => {
        console.log(this.state)
        this.setState({[e.target.name]: e.target.value}) // event is a hashmap
    }

    handleSubmit = e => {
        
        fetch('http://localhost:8080/user/register', {
            method: 'POST',
            crossDomain: true,
            body: JSON.stringify(this.state),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => console.log(res.json))
        .catch(err => console.log(err));
    }
    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form onSubmit={this.handleSubmit.bind(this)}>
                        <div className="form-group">
                            <label htmlFor="uname">Username</label>
                            <input type="text" className="form-control" name="uname" placeholder="Enter Username" onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input type="email" className="form-control" name="email" placeholder="Enter Email" onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="text" className="form-control" name="password" placeholder="Enter Password" onChange={this.handleChange.bind(this)}></input>
                        </div>
                        {/* <div className="form-group">
                            <label for="password">Confirm Password</label>
                            <input type="text" className="form-control" id="password" placeholder="Enter Password"></input>
                        </div> */}
                        <button type="submit" className="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        );
    }
}

const style = {
    position: 'absolute',
    left: '50%',
    top: '50%',
    transform: 'translate(-50%, -50%)'
}

export default Register;