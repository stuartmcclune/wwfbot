import fetch from 'cross-fetch';

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
        return fetch('http://localhost:8080/bestmove', {
            method: 'post',
            headers: {
                "Content-type": "application/json; charset=UTF-8"
              },
              body: JSON.stringify({
                  rack: getState().rack.map(t => {
                      const isBlank = t.score === 0;
                      const isEmpty = t.score == null;
                      let letter;
                      if (isBlank) {
                          letter = "?";
                      } else if (isEmpty) {
                          letter = " ";
                      } else {
                          letter = t.letter;
                      }
                      return {letter: letter, score: t.score == null ? 0 : t.score }
                  }),
                    board: getState().board.map(t => {
                      const isBlank = t.score === 0;
                      const isEmpty = t.score == null;
                      let letter;
                      if (isBlank) {
                          letter = "?";
                      } else if (isEmpty) {
                          letter = " ";
                      } else {
                          letter = t.letter;
                      }
                      return {letter: letter, score: t.score == null ? 0 : t.score }
                  })    
              })
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