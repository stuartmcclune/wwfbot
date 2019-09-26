import React from 'react';

function Tile({letter, score, count, isSelected, onClick}) {

    return(
        <div className={isSelected ? "tile selected" : "tile"} onClick={onClick}>
            <p className="score">{score}</p>
            <h1 className="letter">{letter}</h1>
            <p className="count">{count}</p>    
        </div>
        
    )
}

export default Tile;
