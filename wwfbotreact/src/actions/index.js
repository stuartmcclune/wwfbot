import fetch from 'cross-fetch';

export const openPopup = id => {
    return {
        type: "OPEN_POPUP",
        id: id
    }
}

export function closePopup(letter) {
    return (dispatch, getState) => {
        dispatch(cPopup(letter));
        return dispatch(selBoardTile(getState().awaitingSelection));
    }
}

const cPopup = letter => {
    return {
        type: "CLOSE_POPUP",
        letter: letter
    }
}

const selBoardTile = id => {
    return {
        type: "SELECT_BOARD_TILE",
        id: id
    }
}

export function selectBoardTile(id) {
    return (dispatch, getState) => {
        const {id:selectedId, type:selectedType} = getState().selectedTile;
        if (selectedId == null) {
            return dispatch(selBoardTile(id));
        }
        //A tile is already selected.
        let selectedTile;
        switch (selectedType) {
            case 'RACK':
                selectedTile = getState().rack[selectedId];
                break;
            case 'BOARD':
                selectedTile = getState().board[selectedId];
                break;
            case 'POOL':
                selectedTile = getState().pool[selectedId];
                if (selectedTile.count === 0) {
                    return dispatch(selBoardTile(id));
                }
                break;

            default:
                return dispatch(selBoardTile(id));
        }
        if (selectedTile.isEmpty) {
            return dispatch(selBoardTile(id));
        }
        //A letter is selected.
        if (!getState().board[id].isEmpty) {
            //This space isn't playable.
            return dispatch(selBoardTile(id));
        }
        //This space is playable.
        if (selectedTile.score !== 0) {
            //Selected tile is not blank
            return dispatch(selBoardTile(id));
        }
        //Playing a blank in this space.
        //Open popup to get letter.
        return dispatch(openPopup(id));
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
                      const isEmpty = t.isEmpty;
                      let letter;
                      if (isBlank) {
                          letter = "?";
                      } else if (isEmpty) {
                          letter = " ";
                      } else {
                          letter = t.letter;
                      }
                      return {letter: letter, score: t.score == null ? 0 : t.score, isEmpty: isEmpty}
                  }),
                    board: getState().board.map(t => {
                      const isBlank = t.score === 0;
                      const isEmpty = t.isEmpty;
                      let letter;
                      if (isBlank) {
                          letter = t.letter;
                      } else if (isEmpty) {
                          letter = " ";
                      } else {
                          letter = t.letter;
                      }
                      return {letter: letter, score: t.score == null ? 0 : t.score, isEmpty: isEmpty }
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