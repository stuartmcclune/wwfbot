import React, {useState} from 'react';
import Tile from './tile';

function Pool() {

    const [tiles, setTiles] = useState([
        {letter: "A", score: 1, count: 5},
        {letter: "B", score: 4, count: 1},
        {letter: "C", score: 4, count: 1},
        {letter: "D", score: 2, count: 2},
        {letter: "E", score: 1, count: 7},
        {letter: "F", score: 4, count: 1},
        {letter: "G", score: 3, count: 1},
        {letter: "H", score: 3, count: 1},
        {letter: "I", score: 1, count: 4},
        {letter: "J", score: 10, count: 1},
        {letter: "K", score: 5, count: 1},
        {letter: "L", score: 2, count: 2},
        {letter: "M", score: 4, count: 1},
        {letter: "N", score: 2, count: 2},
        {letter: "O", score: 1, count: 4},
        {letter: "P", score: 4, count: 1},
        {letter: "Q", score: 10, count: 1},
        {letter: "R", score: 1, count: 2},
        {letter: "S", score: 1, count: 4},
        {letter: "T", score: 1, count: 2},
        {letter: "U", score: 2, count: 1},
        {letter: "V", score: 5, count: 1},
        {letter: "W", score: 4, count: 1},
        {letter: "X", score: 8, count: 1},
        {letter: "Y", score: 3, count: 1},
        {letter: "Z", score: 10, count: 1},
        {letter: "", score: 0, count: 2}
    ]);

    return(
        <div className="pool">
            <div className="poolTitle">
                <h1>Pool</h1>
            </div>
            
            <div className="poolTiles">
                {tiles.map(tile => (
                    <Tile letter={tile.letter} score={tile.score} count={tile.count}/>
                ))}     
            </div>
        </div>
    )
}

export default Pool;
