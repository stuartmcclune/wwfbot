import React, {useState} from 'react';
import Tile from './tile';

function Rack() {
    
    const [tiles, setTiles] = useState([
        {letter: "", score: null},
        {letter: "", score: null},
        {letter: "", score: null},
        {letter: "", score: null},
        {letter: "", score: null},
        {letter: "", score: null},
        {letter: "", score: null}
    ]);
    
    return(
        <div className="rack">
            <div className="rackTitle">
                <h1>Rack</h1>
            </div>
            
            <div className="rackTiles">
                {tiles.map(tile => (
                    <Tile letter={tile.letter} score={tile.score}/>
                ))}     
            </div>
            
        </div>
    )
}

export default Rack;
