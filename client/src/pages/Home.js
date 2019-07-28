import React from 'react';
import Sidebar from '../components/Sidebar'
import Matches from '../components/Matches'
import Playlists from '../components/Playlists'
import Search from '../components/Search'

import {Route, Switch} from "react-router-dom"

const Home = () => {
    return (
        <div>
            <Sidebar />
            <Switch>
                <Route exact path="/home" component={Matches} />
                <Route path="/home/playlists" component={Playlists} />
                <Route path="/home/search" component={Search} />
            </Switch>

        </div>
    )
}

export default Home;