import React, {useState} from 'react';
import './App.css'

function Tile({letter, score, count}) {
    
    const [isSelected, setSelected] = useState(false);

    const selectTile = () => {
        setSelected(!isSelected);
    }

    return(
        <div className={isSelected ? "tile selected" : "tile"} onClick={selectTile}>
            <p className="score">{score}</p>
            <h1 className="letter">{letter}</h1>
            <p className="count">{count}</p>    
        </div>
        
    )
}

export default Tile;
