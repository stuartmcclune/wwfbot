const selectRackTileReducer = (state = null, action) => {
    switch(action.type) {
        case "SELECT_RACK":
            return state === action.payload ? null : action.payload;
        default:
            return state;
    }
}

export default selectRackTileReducer;