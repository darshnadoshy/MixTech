export const completeMatches = () => dispatch => {
    fetch(`http://localhost:8080/match/complete/${localStorage.getItem('uid')}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
    .then(res => {
        console.log(res)
        const results = res.map(match => ({
            matchID: match.mid,
            matchName: match.mname,
            song1: match.sname1,
            song2: match.sname2
        }))
        dispatch({
            type: 'COMPLETE_MATCHES',
            payload: results
        })
    })
    .catch(err => console.log(err))
}

export const incompleteMatches = () => dispatch => {
    fetch(`http://localhost:8080/match/incomplete/${localStorage.getItem('uid')}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
    .then(res => {
        console.log(res)
        const results = res.map(match => ({
            matchID: match.mid,
            matchName: match.mname,
            song1: match.sname1,
            song2: match.sname2
        }))
        dispatch({
            type: 'INCOMPLETE_MATCHES',
            payload: results
        })
    })
    .catch(err => {console.log('yup'); console.log(err)})
}