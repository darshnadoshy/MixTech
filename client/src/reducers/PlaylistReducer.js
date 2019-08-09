
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
        case 'CLEAR':
            return {
                state,
                results: []
            };
        default:
            return state
    }
}