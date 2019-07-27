import React from 'react'
import { BrowserRouter as Router, Route} from "react-router-dom"

import './App.css'
import Front from './pages/Front'
import Login from './components/Login'
import Register from './components/Register'
import Home from './pages/Home'

function App() {
  return (
    <Router>
      <Route exact path='/' component={Front}/>
      <Route path='/login' component={Login}/>
      <Route path='/register' component={Register}/>
      <Route path='/home' component={Home}/>
    </Router>
  );
}

export default App;
