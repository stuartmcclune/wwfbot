import React from 'react';
import Tile from './tile';

function Pool({tiles, selected, onTileClick}) {

    return(
        <div className="pool">
            <div className="poolTitle">
                <h1>Pool</h1>
            </div>
            
            <div className="poolTiles">
                {tiles.map((tile, index) => (
                    <Tile {...tile} key={index} isSelected={selected === index} onClick={() => onTileClick(index)} />
                ))}     
            </div>
        </div>
    )
}

export default Pool;
