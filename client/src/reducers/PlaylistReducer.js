
const initialState = {
    results: [],
    songs: []
};


export default (state=initialState, action) => {
    switch (action.type) {
        case 'ALL_PLAYLISTS':
            return {
                ...state,
                results: action.payload
            };
        case 'ADD_PLAYLIST':
            return {
                ...state
            }
        case 'ADD_TO_EXISTING_PLAYLIST':
            return {
                ...state
            }
        case 'DELETE_PLAYLIST':
            return {
                ...state
            }
        case 'GET_ALL_SONGS_IN_PLAYLIST':
            return {
                ...state,
                songs: action.payload
            }
        default:
            return {...state}
    }
}