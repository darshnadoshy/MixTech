

const initialState = {
  results: []
}


export default (state=initialState, action) => {
    switch (action.type) {
     case 'BASIC_SEARCH_RESULTS':
      return {
        state,
        results: action.payload
      }
     default:
      return state
    }
   }