

const initialState = {
  results: []
}


export default (state=initialState, action) => {
    switch (action.type) {
      case 'BASIC_SEARCH':
        return {
          state,
          results: action.payload
        }
      case 'ADVANCED_SEARCH':
        return {
          state,
          results: action.payload
        }
      case 'PROCESSING':
        return {
          state,
          message: 'Loading...'
        }
      default:
        return state
    }
}