
const initialState = {
    results: []
};


export default (state=initialState, action) => {
    switch (action.type) {
        case 'ALL_PLAYLISTS':
            return {
                state,
                results: action.payload
            };
        case 'ADD_PLAYLIST':
            return {
                ...state
            }
        case 'ADD_TO_EXISTING_PLAYLIST':
            return {
                state
            }
        case 'DELETE_PLAYLIST':
            return {
                state
            }
        default:
            return state
    }
}