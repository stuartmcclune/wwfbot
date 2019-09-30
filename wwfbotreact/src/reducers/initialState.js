export const initialState = {
    board: [
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "+", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
    
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "DW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
    
        {letter: "TL", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TW", score: null, isEmpty: true},
        {letter: "", score: null, isEmpty: true},
        {letter: "TL", score: null, isEmpty: true}
    ],
    rack: [{isEmpty: true},{isEmpty: true},{isEmpty: true},{isEmpty: true},{isEmpty: true},{isEmpty: true},{isEmpty: true}],
    pool: [
        {letter: "A", score: 1, count: 5, isEmpty: false},
        {letter: "B", score: 4, count: 1, isEmpty: false},
        {letter: "C", score: 4, count: 1, isEmpty: false},
        {letter: "D", score: 2, count: 2, isEmpty: false},
        {letter: "E", score: 1, count: 7, isEmpty: false},
        {letter: "F", score: 4, count: 1, isEmpty: false},
        {letter: "G", score: 3, count: 1, isEmpty: false},
        {letter: "H", score: 3, count: 1, isEmpty: false},
        {letter: "I", score: 1, count: 4, isEmpty: false},
        {letter: "J", score: 10, count: 1, isEmpty: false},
        {letter: "K", score: 5, count: 1, isEmpty: false},
        {letter: "L", score: 2, count: 2, isEmpty: false},
        {letter: "M", score: 4, count: 1, isEmpty: false},
        {letter: "N", score: 2, count: 2, isEmpty: false},
        {letter: "O", score: 1, count: 4, isEmpty: false},
        {letter: "P", score: 4, count: 1, isEmpty: false},
        {letter: "Q", score: 10, count: 1, isEmpty: false},
        {letter: "R", score: 1, count: 2, isEmpty: false},
        {letter: "S", score: 1, count: 4, isEmpty: false},
        {letter: "T", score: 1, count: 2, isEmpty: false},
        {letter: "U", score: 2, count: 1, isEmpty: false},
        {letter: "V", score: 5, count: 1, isEmpty: false},
        {letter: "W", score: 4, count: 1, isEmpty: false},
        {letter: "X", score: 8, count: 1, isEmpty: false},
        {letter: "Y", score: 3, count: 1, isEmpty: false},
        {letter: "Z", score: 10, count: 1, isEmpty: false},
        {letter: "", score: 0, count: 2, isEmpty: false}
    ],
    selectedTile: {type: null, id: null},
    isFetching: false,
    bestMove: {letters: null, row: -1, column: -1, orientation: null, score: -1},
    popupOpen: false,
    blankLetter: null,
    
}