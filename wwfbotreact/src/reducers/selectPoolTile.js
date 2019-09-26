const selectPoolTileReducer = (state = null, action) => {
    switch(action.type) {
        case "SELECT_POOL":
            return state === action.payload ? null : action.payload;
        default:
            return state;
    }
}

export default selectPoolTileReducer;