import { combineReducers } from 'redux';
import basicSearchReducer from './BasicSearchReducer';
import UserAuthReducer from './UserAuthReducer'


export default combineReducers({
 basicSearchResults: basicSearchReducer,
 userAuth: UserAuthReducer
});

