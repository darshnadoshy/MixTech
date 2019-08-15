/**
 * Actions mapping to the match route and calling various functionalities.
 * Dispatches to MatchReducer.js to change match state.
 */

 /**
  * Get a list of all complete matches
  */
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

/**
 * Gets a list of all incomplete matches
 */
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

/**
 * Adds a new match given a song id.
 * @param {*} song 
 */
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

/**
 * Adds to an exisitng match given a song id.
 * @param {*} req 
 */
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

/**
 * Deletes a match.
 * @param {*} matchID 
 */
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