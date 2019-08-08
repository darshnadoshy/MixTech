

export const login = (creds) => dispatch => {
    dispatch({type: 'LOGIN_REQUEST'})
    fetch(`http://localhost:8080/user/login?email=${creds.email}&password=${creds.password}`, {
            method: 'POST',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => res.json())
        .then(res => {
            if (res.ret === 1) {
                localStorage.setItem('token', res.token)
                dispatch({
                    type: 'LOGIN_SUCCESS',
                })
            } else {
                dispatch({
                    type: 'LOGIN_FAILURE',
                    error: res.msg
                })
            }
        }).catch(err => {console.log(err)})
}

export const logout = () => dispatch => {
    console.log('logging out...')
    localStorage.removeItem('token')
    dispatch({type: 'LOGOUT'})
}

export const register = () => dispatch => {
    
}