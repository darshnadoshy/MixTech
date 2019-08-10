import { combineReducers } from 'redux';
import SearchReducer from './SearchReducer';
import UserAuthReducer from './UserAuthReducer';
import PlaylistReducer from './PlaylistReducer'
import MatchReducer from './MatchReducer'



export default combineReducers({
 SearchResults: SearchReducer,
 userAuth: UserAuthReducer,
 playlists: PlaylistReducer,
 matches: MatchReducer
});

