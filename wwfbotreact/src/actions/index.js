export const setBoard = (tileInfo) => {
    return {
        type: "SET_BOARD",
        payload: tileInfo
    };
};

export const selectBoardTile = id => {
    return {
        type: "SELECT_BOARD",
        payload: id
    }
}

export const setRack = () => {
    return {
        type: "SET_RACK"
    }
}

export const selectRackTile = id => {
    return {
        type: "SELECT_RACK",
        payload: id
    }
}

export const setPool = () => {
    return {
        type: "SET_POOL"
    }
}

export const selectPoolTile = id => {
    return {
        type: "SELECT_POOL",
        payload: id
    }
}