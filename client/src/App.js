import React from 'react'
import { BrowserRouter as Router, Route, Switch} from "react-router-dom"

import './App.css'
import Front from './pages/Front'
import Login from './components/Login'
import Register from './components/Register'
import Search from './components/Search'

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path='/' component={Front}/>
        <Route path='/login' component={Login}/>
        <Route path='/register' component={Register}/>
        <Route path='/search' component={Search}/>
      </Switch>
    </Router>
  );
}

export default App;
