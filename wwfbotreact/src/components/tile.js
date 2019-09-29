import React from 'react';

function Tile({letter, score, count, isSelected, onClick}) {

    const isLetter = score != null;
    const className = "tile" + (isSelected ? " selected" : "") + (isLetter ? " isLetter" : "") + (count === 0 ? " runOut" : "");

    return(
        <div className={className} onClick={onClick}>
            <p className="score">{score}</p>
            <h1 className="letter">{letter}</h1>
            <p className="count">{count}</p>    
        </div>
        
    )
}

export default Tile;
