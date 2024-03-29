import {initialState} from './initialState';

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case 'SELECT_RACK_TILE':
            if (state.selectedTile.id != null && state.rack[action.id].isEmpty) {
                //A tile is selected and this rack space is playable.
                let selectedTile;
                const newState = Object.assign({}, state);
                switch(state.selectedTile.type) {
                    case "RACK":
                        if (state.selectedTile.id === action.id) {
                            return Object.assign({}, state, {selectedTile: {}});
                        }
                        selectedTile = Object.assign({}, state.rack[state.selectedTile.id]);
                        newState.rack = state.rack.map((tile, index) => {
                            return index === state.selectedTile.id ? {isEmpty: true} : tile;
                        })
    
                        break;
                    case "POOL":
                        selectedTile = Object.assign({}, state.pool[state.selectedTile.id]);
                        if (selectedTile.count === 0) {
                            //Tile not playable.
                            newState.selectedTile = {type: "RACK", id: action.id};
                            return newState;
                        }
                        selectedTile.count = null;
                        newState.pool = state.pool.map((tile, index) => {
                            if (index === state.selectedTile.id) {
                                const newTile = Object.assign({}, tile);
                                newTile.count--;
                                return newTile;
                            }
                            return tile;
                        })
                        break;
                    case "BOARD":
                        selectedTile = Object.assign({}, state.board[state.selectedTile.id]);
                        newState.board = state.board.map((tile, index) => {
                            return index === state.selectedTile.id ? Object.assign({},initialState.board[index]) : tile; 
                        })
             
                        break;
                    default:
                        return state;
                }
    
                if (selectedTile.score == null) {
                    //The selected tile is not playable.
                    newState.selectedTile = {type: "RACK", id: action.id};
                    return newState;
                }
    
                //This space is playable, and the selectedTile is playable.
                //Check if blank. If so, set letter to "".
                if (selectedTile.score === 0) {
                    selectedTile.letter = "";
                }
                newState.selectedTile = {};
                newState.rack = newState.rack.map((tile, index) => {
                    return index === action.id ? selectedTile : tile;
                })
    
                
                return newState;
            }

            return Object.assign({}, state, {selectedTile: state.selectedTile.type === "RACK" && state.selectedTile.id === action.id ? {} : {id: action.id, type: "RACK"}});
        case 'SELECT_POOL_TILE':

            if (state.selectedTile.id != null && state.selectedTile.type !== "POOL") {
                //A tile is selected and it's not from the pool.
                let selectedTile;
                const newState = Object.assign({}, state);
                switch(state.selectedTile.type) {
                    case "RACK":
                        selectedTile = Object.assign({}, state.rack[state.selectedTile.id]);
                        if (selectedTile.letter !== state.pool[action.id].letter) {
                            //Letters don't match.
                            newState.selectedTile = {type: "POOL", id: action.id};
                            return newState;
                        }
                        newState.rack = state.rack.map((tile, index) => {
                            return index === state.selectedTile.id ? {isEmpty: true} : tile;
                        })
        
                        break;
                    
                    case "BOARD":
                        selectedTile = Object.assign({}, state.board[state.selectedTile.id]);
                        if (selectedTile.score === 0) {
                            selectedTile.letter = "";
                        }
                        if (selectedTile.letter !== state.pool[action.id].letter) {
                            //Letters don't match.
                            newState.selectedTile = {type: "POOL", id: action.id};
                            return newState;
                        }
                        newState.board = state.board.map((tile, index) => {
                            return index === state.selectedTile.id ? Object.assign({},initialState.board[index]) : tile; 
                        })
                 
                        break;
                    default:
                        return state;
                }
        
                if (selectedTile.score == null) {
                    //The selected tile is not playable.
                    newState.selectedTile = {type: "POOL", id: action.id};
                    return newState;
                }
        
                //This space is playable, and the selectedTile is playable.
                newState.selectedTile = {};
                newState.pool = newState.pool.map((tile, index) => {
                    if (index === action.id) {
                        const newTile = Object.assign({}, tile);
                        newTile.count++;
                        return newTile;
                    }
                    return tile;
                })
        
                return newState;
                }

            return Object.assign({}, state, {selectedTile: state.selectedTile.type === "POOL" && state.selectedTile.id === action.id ? {} : {id: action.id, type: "POOL"}});
        case 'SELECT_BOARD_TILE':
            if (state.selectedTile.id != null && state.board[action.id].isEmpty) {
                //A tile is selected and this board space is playable.
                let selectedTile;
                const newState = Object.assign({}, state);
                switch(state.selectedTile.type) {
                    case "RACK":
                        selectedTile = Object.assign({}, state.rack[state.selectedTile.id]);
                        newState.rack = state.rack.map((tile, index) => {
                            return index === state.selectedTile.id ? {isEmpty: true} : tile;
                        })

                        break;
                    case "POOL":
                        selectedTile = Object.assign({}, state.pool[state.selectedTile.id]);
                        if (selectedTile.count === 0) {
                            //Tile not playable.
                            newState.selectedTile = {type: "BOARD", id: action.id};
                            return newState;
                        }
                        selectedTile.count = null;
                        newState.pool = state.pool.map((tile, index) => {
                            if (index === state.selectedTile.id) {
                                const newTile = Object.assign({}, tile);
                                newTile.count--;
                                return newTile;
                            }
                            return tile;
                        })
                        break;
                    case "BOARD":
                        if (state.selectedTile.id === action.id) {
                            return Object.assign({}, state, {selectedTile: {}});
                        }
                        selectedTile = Object.assign({}, state.board[state.selectedTile.id]);
                        newState.board = state.board.map((tile, index) => {
                            return index === state.selectedTile.id ? Object.assign({},initialState.board[index]) : tile; 
                        })
                        
                        break;
                    default:
                        return state;
                }

                if (selectedTile.score == null) {
                    //The selected tile is not playable.
                    newState.selectedTile = {type: "BOARD", id: action.id};
                    return newState;
                }

                //This space is playable, and the selectedTile is playable.
                newState.selectedTile = {};
                //Check if selectedTile is blank. If so, change its letter.
                if (selectedTile.score === 0) {
                    selectedTile.letter = state.blankLetter;
                }


                newState.board = newState.board.map((tile, index) => {
                    return index === action.id ? selectedTile : tile;
                })
                newState.bestMove = initialState.bestMove;

                return newState;

            }

            return Object.assign({}, state, {selectedTile: state.selectedTile.type === "BOARD" && state.selectedTile.id === action.id ? {} : {id: action.id, type: "BOARD"}});
        case 'REQUEST_BEST_MOVE':
            return Object.assign({}, state, {
                isFetching: true,
            })
        case 'RECEIVE_BEST_MOVE':
            return Object.assign({}, state, {
                isFetching: false,
                bestMove: action.bestMove
            })
        case 'CLOSE_POPUP':
            return Object.assign({}, state, {
                popupOpen: false,
                blankLetter: action.letter
            })
        case 'OPEN_POPUP':
                return Object.assign({}, state, {
                    popupOpen: true,
                    awaitingSelection: action.id,
                    blankLetter: null
                })
        default:
            return state;
    }
}

export default reducer;