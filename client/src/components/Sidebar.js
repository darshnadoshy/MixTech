import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import '../css/Sidebar.css'

class Sidebar extends Component {
    render() {
        return (
            <nav className="navbar" id="sidebar">
                <div className="navbar-brand sidebar-header">
                    <h1>MixTech</h1>
                </div>
                <ul className="navbar-nav">
                    <h4>Username</h4>
                    <li className="nav-item">
                        <div className="container">
                            <Link to={'/home'}>Matches</Link>
                        </div>
                    </li>
                    <li>
                        <div className="container">
                            <Link to={'/home/playlists'}>Playlists</Link>
                        </div>
                    </li>
                    <li className="nav-item">
                        <div className="container">
                            <Link to={'/home/search'}>Search</Link>
                        </div>
                    </li>
                    <li className="nav-item">
                        <div className="container">
                            <Link to={'/home/advancedsearch'}>Advanced Search</Link>
                        </div>
                    </li>
                </ul>
            </nav>
        );
    }
}

export default Sidebar;