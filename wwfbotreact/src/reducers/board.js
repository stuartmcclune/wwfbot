const boardReducer = (state = [
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},

    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},

    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},

    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},

    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},

    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "+", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},

    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},

    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},

    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "DL", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},

    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "DW", score: null},
    {letter: "", score: null},

    {letter: "TL", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "", score: null},
    {letter: "TW", score: null},
    {letter: "", score: null},
    {letter: "TL", score: null}]
    , action) => {
    
    

    switch(action.type) {
        case "SET_BOARD":
            const newState = [...state];
            const row = action.payload.row;
            const column = action.payload.column;
            const letter = action.payload.letter;
            const score = action.payload.score;
            newState[row * 11 + column].letter = letter;
            newState[row * 11 + column].score = score;
            return newState;
        default:
            return state;

    }
}

export default boardReducer;