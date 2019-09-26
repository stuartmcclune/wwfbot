import React from 'react';
import Tile from "./tile";

function Board({tiles, selected, onTileClick}) {

    return(
        <div className = "board">
            {tiles.map((tile, index) => (
                <Tile {...tile} isSelected={index === selected} onClick={() => onTileClick(index)}/>
            ))}
        </div>
    )

}

export default Board;
