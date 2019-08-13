export const completeMatches = () => dispatch => {
    fetch(`http://localhost:8080/match/complete/${localStorage.getItem('uid')}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
    .then(res => {
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

export const addNewMatch = (song) => dispatch => {
    fetch(`http://localhost:8080/match/create/${localStorage.getItem('uid')}?spotifyUri1=${song.id}`, {
            method: 'POST',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(dispatch({ type: 'ADD_NEW_MATCH' }))
        .catch(err => console.log(err))
}

export const addToExistingMatch = (req) => dispatch => {
    fetch(`http://localhost:8080/match/addsong/${localStorage.getItem('uid')}/${req.matchID}?spotifyUri2=${req.songID}`, {
            method: 'POST',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(dispatch({ type: 'ADD_TO_EXISTING_MATCH' }))
        .catch(err => console.log(err))
}

export const deleteMatch = (matchID) => dispatch => {
    fetch(`http://localhost:8080/match/delete/${matchID}/${localStorage.getItem('uid')}`, {
        method: 'DELETE',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(dispatch({ type: 'DELETE_MATCH'}))
    .catch(err => console.log(err))

}