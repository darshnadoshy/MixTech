export const songResults = (query) => dispatch => {
    fetch(`http://localhost:8080/search/basic?sname=${query.sname}`, {
            method: 'GET',
            crossDomain: true,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {return res.json()})
        .then(res => {
            const results = res.map(song => ({
                name: song.sname,
                album_name: song.album_name,
                artist: song.mname,
                danceability: song.danceability,
                energy: song.energy,
                key: song.skey,
                loudness: song.loudness,
                mode: song.smode,
                speechiness: song.speechiness,
                acousticness: song.acousticness,
                instrumentalness: song.instrumentalness,
                liveness: song.liveness,
                valence: song.valence,
                tempo: song.tempo,
                duration: song.duration_ms }))

            dispatch({
                type: 'BASIC_SEARCH_RESULTS',
                payload: results
            })
        }).catch(err => {console.log(err)})
   }