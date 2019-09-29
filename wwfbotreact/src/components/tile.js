import React from 'react';

function Tile({letter, score, count, isEmpty, isSelected, onClick}) {

    const isLetter = score != null;
    const isFake = isEmpty && isLetter;
    const className = "tile" + (isSelected ? " selected" : "") + (isLetter ? " isLetter" : "") + (count === 0 ? " runOut" : "") + (isFake ? " fake" : "");

    return(
        <div className={className} onClick={onClick}>
            <p className="score">{score}</p>
            <h1 className="letter">{letter}</h1>
            <p className="count">{count}</p>    
        </div>
        
    )
}

export default Tile;
