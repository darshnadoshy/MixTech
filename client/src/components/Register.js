import React, { Component } from 'react';
import axios from 'axios';
class Register extends Component {
    state = {
        uname: "",
        email: "",
        password: "",
    }

    handleChange = e => {
        console.log(e.target.value)
        this.setState({[e.target.name]: e.target.value}) // event is a hashmap
    }

    handleSubmit = e => {
        const post = {
            uname: this.state.uname,
            email: this.state.email,
            password: this.state.password
        }
        const axiosconfig = {headers: {
            'Content-Type' : 'application/json; charset=UTF-8',
            'Accept': 'Token',
            "Access-Control-Allow-Origin": "*",
      
        }}
        axios({method: 'post', url: 'http://127.0.0.1:8080/user/register', headers: axiosconfig, data: post 
            }).catch(err => {
                console.log(err)
            })

        // fetch('http://127.0.0.1:8080/user/register', {
        //     method: 'POST',
        //     body: JSON.stringify(post),
        //     headers: {
        //         "Content-type": "application/json"
        //     }
        // }).catch(err => console.log(err));
    }
    render() {
        return (
            <div className="container">
                <div className="container" style={style}>
                    <form onSubmit={this.handleSubmit.bind(this)}>
                        <div className="form-group">
                            <label htmlFor="uname">Username</label>
                            <input type="text" className="form-control" id="uname" placeholder="Enter Username" onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <div className="form-group">
                            <label htmlFor="email">Email</label>
                            <input type="email" className="form-control" id="email" placeholder="Enter Email" onChange={this.handleChange.bind(this)}></input>
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="text" className="form-control" id="password" placeholder="Enter Password" onChange={this.handleChange.bind(this)}></input>
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