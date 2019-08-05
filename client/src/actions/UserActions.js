

export const authToken = (query) => dispatch => {
    fetch(`http://localhost:8080/user/login?email=${query.email}&password=${query.password}`, {
            method: 'POST',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => res.json())
        .then(res => {
            dispatch({
                type: 'LOGIN',
                payload: res
            })
        }).catch(err => {console.log(err)})
    
    
}