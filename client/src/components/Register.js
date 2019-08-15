import React, { Component } from 'react';
import { connect } from 'react-redux'
import PropTypes from 'prop-types'
import { register } from '../actions/UserActions'
import { Link, Redirect } from 'react-router-dom'

/**
 * Component to register a new user.
 */
class Register extends Component {
    /**
     * State for necessary credentials for
     * registering the user in the backend.
     */
    constructor () {
        super()
        this.state = {
            uname: "",
            email: "",
            password: ""
        }
    }

    /**
     * Updates corresponding form field.
     */
    handleChange = e => {
        this.setState({[e.target.name]: e.target.value}) // event is a hashmap
    }

    /**
     * Submits the form and registers a new user.
     */
    handleSubmit = e => {
        e.preventDefault()
        const creds = {
            uname: this.state.uname,
            email: this.state.email,
            password: this.state.password
        }
        this.props.register(creds)
    }

    /**
     * HTML and CSS to display. If authenticated (check UserActions),
     * then redirect to home page, if not display fail message and
     * rerender register page.
     */
    render() {
            if (this.props.isAuthenticated) {
                return <Redirect to={'/home'}></Redirect>
            } else if (this.props.isFetching) {
                return <h1>Loading...</h1>
            } else {
                return (
                    <div>
                        <div><Link to={'/'}><button className="btn btn-light">Back</button></Link></div>
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
                                    <input type="password" className="form-control" name="password" placeholder="Enter Password" onChange={this.handleChange.bind(this)}></input>
                                </div>
                                <button type="submit" className="btn btn-primary">Register</button>
                                <h2>{this.props.errorMessage}</h2>
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

Register.propTypes = {
    register: PropTypes.func.isRequired,
    isFetching: PropTypes.bool,
    isAuthenticated: PropTypes.bool,
    errorMessage: PropTypes.string
}

const mapStateToProps = state => ({
    isFetching: state.userAuth.isFetching,
    isAuthenticated: state.userAuth.isAuthenticated,
    errorMessage: state.userAuth.errorMessage
})

export default connect(mapStateToProps, { register })(Register);