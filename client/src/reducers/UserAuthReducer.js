
const initialState = {
    isFetching: false,
    isAuthenticated: localStorage.getItem('token') ? true : false
}

export default (state=initialState, action) => {
    switch (action.type) {
        case 'REGISTER_SUCCESS':
            return {
                state,
                isFetching: false,
                isAuthenticated: true,
                errorMessage: ''
            }
        case 'REGISTER_FAILURE':
            return {
                state,
                isFetching: false,
                isAuthenticated: false,
                errorMessage: action.error
            }
        case 'LOGIN_REQUEST':
            return {
                state,
                isFetching: true,
                isAuthenticated: false,
                errorMessage: ''
            }
        case 'LOGIN_SUCCESS':
            return {
                state,
                isFetching: false,
                isAuthenticated: true,
                errorMessage: ''
            }
        case 'LOGIN_FAILURE':
            return {
                state,
                isFetching: false,
                isAuthenticated: false,
                errorMessage: action.error
            }
        case 'LOGOUT':
            return {
                state,
                isFetching: false,
                isAuthenticated: false
            }
        default:
            return {state}
    }
}