import React, { Component } from 'react';
import {Redirect} from 'react-router-dom'
import PropTypes from 'prop-types'
import {authToken} from '../actions/UserActions'
import { connect } from 'react-redux'
import Home from '../pages/Home'

class Login extends Component {
    state = {
        email: "",
        password: "",
        authenticated: false
    }

    handleChange = e => {
        this.setState({[e.target.name]: e.target.value}) // event is a hashmap
    }

    handleSubmit = e => {
        e.preventDefault()
        const query = {
            email: this.state.email,
            password: this.state.password
        }
        this.props.authToken(query)
        console.log(this.props.success)

        if (this.props.success === 1) {
            this.setState({authenticated: true})
        } else {
            console.log('error')
        }
    }

    render() {
        if (this.state.authenticated) {
            return <Redirect to='/home'/>
        } else {
            return (
                <div className="container">
                    <div className="container" style={style}>
                        <form onSubmit={this.handleSubmit.bind(this)}>
                            <div className="form-group">
                                <label htmlFor="username">Email</label>
                                <input type="email" className="form-control" name="email" placeholder="Enter Username"
                                onChange={this.handleChange.bind(this)}></input>
                            </div>
                            <div className="form-group">
                                <label htmlFor="password">Password</label>
                                <input type="text" className="form-control" name="password" placeholder="Enter Password"
                                onChange={this.handleChange.bind(this)}></input>
                            </div>
                            <button type="submit" className="btn btn-primary">Login</button>
                        </form>
                    </div>
                </div>
            )
        }
    }
    
}

const style = {
    position: 'absolute',
    left: '50%',
    top: '50%',
    transform: 'translate(-50%, -50%)'
}

Login.propTypes = {
    authToken: PropTypes.func.isRequired,
    success: PropTypes.number
}

const mapStateToProps = state => ({
    success: state.userAuth.success
})

export default connect(mapStateToProps, { authToken })(Login);