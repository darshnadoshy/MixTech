export const allPlaylists = () => dispatch => {
    fetch(`http://localhost:8080/playlist/all/${localStorage.getItem('uid')}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
        .then(res => {
            console.log(res)
            const results = res.map(playlist => ({
                pid: playlist.pid,
                pname: playlist.pname,
                privacy: playlist.privacy,
                description: playlist.description
            }));
            dispatch({
                type: "ALL_PLAYLISTS",
                payload: results
            })
        }).catch(err => {console.log(err)});

};

export const addPlaylist = (data) => dispatch => {
    fetch(`http://localhost:8080/playlist/create/${localStorage.getItem('uid')}`, {
        method: 'POST',
        crossDomain: true,
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(dispatch({ type: 'ADD_PLAYLIST' }))
    .catch(err => console.log(err))
}

export const addToExistingPlaylist = (req) => dispatch => {
    fetch(`http://localhost:8080/playlist/addsong/${localStorage.getItem('uid')}/${req.matchID}?spotifyUri2=${req.songID}`, {
            method: 'POST',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => console.log(res))
        .then(dispatch({ type: 'ADD_TO_EXISTING_MATCH' }))
        .catch(err => console.log(err))
}

export const deletePlaylist = (pid) => dispatch => {
    fetch(`http://localhost:8080/playlist/delete/${localStorage.getItem('uid')}/${pid}`, {
            method: 'DELETE',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(dispatch({ type: 'DELETE_PLAYLIST' }))
        .catch(err => console.log(err))
}