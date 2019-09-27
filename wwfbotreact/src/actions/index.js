export const selectBoardTile = id => {
    return {
        type: "SELECT_BOARD_TILE",
        id: id
    }
}

export const selectRackTile = id => {
    return {
        type: "SELECT_RACK_TILE",
        id: id
    }
}

export const selectPoolTile = id => {
    return {
        type: "SELECT_POOL_TILE",
        id: id
    }
}
