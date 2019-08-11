

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
                localStorage.setItem('uname', res.uname)
                localStorage.setItem('uid', res.uid)
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
    localStorage.removeItem('uname')
    localStorage.removeItem('uid')
    localStorage.removeItem('token')
    dispatch({type: 'LOGOUT'})
}

export const register = (creds) => dispatch => {
    dispatch({type: 'REGISTER_REQUEST'})
    fetch('http://localhost:8080/user/register', {
            method: 'POST',
            crossDomain: true,
            body: JSON.stringify(creds),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => res.json())
        .then(res => {
            if (res.ret === 1) {
                localStorage.setItem('uname', res.uname)
                localStorage.setItem('uid', res.uid)
                localStorage.setItem('token', res.token)
                dispatch({
                    type: 'REGISTER_SUCCESS',
                })
            } else {
                dispatch({
                    type: 'REGISTER_FAILURE',
                    error: res.msg
                })
            }
        }).catch(err => console.log(err));
}