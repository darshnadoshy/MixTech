export const allPlaylists = (query) => dispatch => {
    fetch(`http://localhost:8080/playlists/all/${query.uid}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {return res.json()})
        .then(res => {
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