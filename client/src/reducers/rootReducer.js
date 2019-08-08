import { combineReducers } from 'redux';
import SearchReducer from './SearchReducer';
import UserAuthReducer from './UserAuthReducer'


export default combineReducers({
 SearchResults: SearchReducer,
 userAuth: UserAuthReducer
});

