import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import PropTypes from 'prop-types'
import { logout } from '../actions/UserActions'
import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'
import '../css/Sidebar.css'

class Sidebar extends Component {
    render() {
        return (
            <nav className="navbar" id="sidebar">
                <div className="navbar-brand sidebar-header">
                    <Link to={'/home'}><h1>MixTech</h1></Link>
                    <h5>username</h5>
                </div>
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <Link to={'/home'}><h4>Matches</h4></Link>
                    </li>
                    <li className="nav-item">
                        <Link to={'/home/playlists'}><h4>Playlists</h4></Link>
                    </li>
                    <li className="nav-item">
                        <Link to={'/home/search'}><h4>Search</h4></Link>
                    </li>
                    <li className="nav-item">
                        <Link to={'/home/advancedsearch'}><h4>Advanced Search</h4></Link>
                    </li>
                </ul>
                <button onClick={() => {this.props.logout()}} id="logout" className="btn btn-secondary justify-content-end">Logout</button>
                {!localStorage.getItem('token') && <Redirect to='/login' />}
            </nav>
        )
    }
}

Sidebar.propTypes = {
    logout: PropTypes.func.isRequired
}

const mapStateToProps = state => ({
    isAuthenticated: state.userAuth.isAuthenticated
})

export default connect(mapStateToProps, { logout })(Sidebar);