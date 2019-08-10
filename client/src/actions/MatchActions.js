export const allMatches = () => dispatch => {
    fetch(`http://localhost:8080/match/all/${localStorage.getItem('uid')}`, {
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
            song1: match.spotify_uri1,
            song2: match.spotify_uri2
        }))
        dispatch({
            type: 'ALL_MATCHES',
            payload: results
        })
    })
    .catch(err => console.log(err))
}