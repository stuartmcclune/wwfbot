const selectBoardTileReducer = (state = null, action) => {
    switch(action.type) {
        case "SELECT_BOARD":
            return state === action.payload ? null : action.payload;
        default:
            return state;
    }
}

export default selectBoardTileReducer;