
import React from 'react'
import {Link} from 'react-router-dom'



const Front = () => {
    return (
        <div className="container" style={parentStyle}>
            <div className="container" style={style}>
                <h1>Welcome to MixTech</h1>
                
                <Link to={'/login'}><button type="button" className="btn btn-primary btn-lg">Login</button></Link>
                <Link to= {'/register'}><button type="button" className="btn btn-secondary btn-lg">Register</button></Link>
                
            </div>
        </div>
    )
}


const parentStyle = {
    textAlign: 'center'
}

const style = {
    position: 'absolute',
    left: '50%',
    top: '50%',
    transform: 'translate(-50%, -50%)'
}

export default Front