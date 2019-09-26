import React, {useState} from 'react';
import Tile from "./tile";
import './App.css'

function Board() {
    const [tiles, setTiles] = useState([
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
        {letter: "TL", score: null}
    ]);

    return(
        <div className = "board">
            {tiles.map(tile => (
                <Tile letter={tile.letter} score={tile.score}/>
            ))}
        </div>
    )

}

export default Board;
