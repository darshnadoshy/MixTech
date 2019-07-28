import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import '../css/Sidebar.css'

class Sidebar extends Component {
    render() {
        return (
            <div className="wrapper">
                <nav id="sidebar">
                    <div className="sidebar-header">
                        <h3>MixTech</h3>
                    </div>

                    <ul className="list-unstyled components">
                        <p>Username</p>
                        
                        <li>
                            <Link to={'/home'}>Matches</Link>
                        </li>
                        <li>
                            <Link to={'/home/playlists'}>Playlists</Link>
                        </li>
                        <li>
                            <Link to={'/home/search'}>Search</Link>
                        </li>
                    </ul>

                </nav>
            </div>
        );
    }
}

export default Sidebar;