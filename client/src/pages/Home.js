import React from 'react';
import Sidebar from '../components/Sidebar'
import Matches from '../components/Matches'
import Playlists from '../components/Playlists'
import Search from '../components/Search'
import AdvancedSearch from '../components/AdvancedSearch'

import {Route, Switch} from "react-router-dom"
import '../css/Home.css'


/**
 * The authenticated user will be redirected to this home page.
 * Defines a sidebar as the navigation bar for MixTech and defines several
 * browser routes for the user each with their corresponding
 * component and functionality.
 */

const Home = () => {
    return (
        <div id="home">
            <Sidebar />
            <Switch>
                <Route exact path="/home" component={Matches} />
                <Route path="/home/playlists" component={Playlists} />
                <Route path="/home/search" component={Search} />
                <Route path="/home/advancedsearch" component={AdvancedSearch} />
            </Switch>

        </div>
    )
}

export default Home;