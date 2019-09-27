import fetch from 'cross-fetch';
import { get } from 'https';

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

export const requestBestMove = () => {
    return {
        type: "REQUEST_BEST_MOVE",
    }
}

export const receiveBestMove = json => {
    return {
        type: "RECEIVE_BEST_MOVE",
        bestMove: json
    }
}


export function fetchBestMove() {
    return (dispatch, getState) => {
        // Update state to inform API call starting.
        dispatch(requestBestMove());
        // Make API call.
        return fetch('http://www.stuartmcclune.co.uk/bestmove', {
            method: 'post',
            headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
              },
              body: {
                  board: getState().board,
                  rack: getState.rack
              }
        })
        .then(
            response => response.json(),
            error => console.log("An error occurred.", error)
        )
        .then(
            json => dispatch(receiveBestMove(json))
        )
    }
}