import boardReducer from './board';
import selectBoardTileReducer from './selectBoardTile';
import {combineReducers} from 'redux';
import selectRackTileReducer from './selectRackTile';
import rackReducer from './rack';
import selectPoolTileReducer from './selectPoolTile';
import poolReducer from './pool';

const allReducer = combineReducers({
    board: boardReducer,
    selectedBoardTile: selectBoardTileReducer,
    rack: rackReducer,
    selectedRackTile: selectRackTileReducer,
    pool: poolReducer,
    selectedPoolTile: selectPoolTileReducer,
})

export default allReducer;