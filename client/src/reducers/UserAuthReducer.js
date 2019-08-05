
const initialState = {
    success: -1,
    token: null
}

export default (state=initialState, action) => {
    switch (action.type) {
        case 'LOGIN':
            return {
                state,
                success: action.payload.ret,
                token: action.payload.token
            }
        default:
            return {
                state
            }
    }
}