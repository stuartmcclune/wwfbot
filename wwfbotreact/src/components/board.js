import React from 'react';
import Tile from "./tile";

function Board({tiles, bestMove, selected, onTileClick}) {

    let {letters, row, column, orientation, score} = bestMove;
    let lettersIndex = 0;

    return(
        <div className = "board">
            {tiles.map((tile, index) => {
                if (score === -1) {
                    //No possible move.
                    return (<Tile {...tile} key={index} isSelected={index === selected} onClick={() => onTileClick(index)}/>)
                }
                let t;
                const boardIndex = row * 11 + column;
                if (lettersIndex === letters.length) {
                    return (<Tile {...tile} key={index} isSelected={index === selected} onClick={() => onTileClick(index)}/>)
                }
                if (index === boardIndex) {
                    //Try to play here.
                    if (tile.isEmpty) {
                        //Can play here.
                        t = letters[lettersIndex];
                        lettersIndex++;
                    } else {
                        //Can't play here
                        t = tile;
                    }
                    //Try next spot on board.
                    if (orientation === "h") {
                        column++;
                    } else {
                        row++;
                    }
                } else {
                    t = tile;
                }

                return (<Tile {...t} key={index} isSelected={index === selected} onClick={() => onTileClick(index)}/>)
            })}
        </div>
    )

}

export default Board;
