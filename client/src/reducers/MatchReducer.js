const initialState = {
    completeResults: [],
    incompleteResults: []
};


export default (state=initialState, action) => {
    switch (action.type) {
        case 'COMPLETE_MATCHES':
            return {
                state,
                completeResults: action.payload,
            };
        case 'INCOMPLETE_MATCHES':
            return {
                state,
                incompleteResults: action.payload
            };
        default:
            return state
    }
}