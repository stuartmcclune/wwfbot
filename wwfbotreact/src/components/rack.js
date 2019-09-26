import React from 'react';
import Tile from './tile';

function Rack({tiles, selected, onTileClick}) {
    
    return(
        <div className="rack">
            <div className="rackTitle">
                <h1>Rack</h1>
            </div>
            
            <div className="rackTiles">
                {tiles.map((tile, index)=> (
                    <Tile {...tile} isSelected={selected === index} onClick={() => onTileClick(index)}/>
                ))}     
            </div>
            
        </div>
    )
}

export default Rack;
