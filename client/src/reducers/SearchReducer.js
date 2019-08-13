

const initialState = {
  results: [],
  matches: []
}


export default (state=initialState, action) => {
    switch (action.type) {
      case 'BASIC_SEARCH':
        return {
          ...state,
          results: action.payload
        }
      case 'ADVANCED_SEARCH':
        return {
          ...state,
          results: action.payload
        }
      case 'MATCH_SEARCH':
        return {
          ...state,
          matches: action.payload
        }
      case 'PROCESSING':
        return {
          ...state,
          message: 'Loading...'
        }
      case 'CLEAR':
        return {
          ...state,
          results: [],
          matches: []
        }
      default:
        return {...state}
    }
}