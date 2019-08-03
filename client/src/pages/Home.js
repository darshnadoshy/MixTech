import React from 'react';
import Sidebar from '../components/Sidebar'
import Matches from '../components/Matches'
import Playlists from '../components/Playlists'
import Search from '../components/Search'
import AdvancedSearch from '../components/AdvancedSearch'

import {Route, Switch} from "react-router-dom"
import '../css/Home.css'

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