export const allPlaylists = () => dispatch => {
    fetch(`http://localhost:8080/playlist/all/${localStorage.getItem('uid')}`, {
        method: 'GET',
        crossDomain: true,
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json())
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