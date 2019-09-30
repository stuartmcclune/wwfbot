import React from 'react'
import Popup from 'reactjs-popup'

function BlankPopup({isOpen, onClick}) {
    return (
        <Popup open={isOpen} closeOnDocumentClick={false}>
            <div>
                <h1>Pick a Letter</h1>
                {['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'].map(c => (
                    <button className="letterBtn" onClick={() => onClick(c)}>{c}</button>
                ))}
                {/* <button onClick={() => onClick('A')}>A</button>
                <button onClick={() => onClick('B')}>B</button>
                <button onClick={() => onClick('C')}>C</button>
                <button onClick={() => onClick('D')}>D</button>
                <button onClick={() => onClick('E')}>E</button>
                <button onClick={() => onClick('F')}>F</button>
                <button onClick={() => onClick('G')}>G</button>
                <button onClick={() => onClick('H')}>H</button>
                <button onClick={() => onClick('I')}>I</button>
                <button onClick={() => onClick('J')}>J</button>
                <button onClick={() => onClick('K')}>K</button>
                <button onClick={() => onClick('L')}>L</button>
                <button onClick={() => onClick('M')}>M</button>
                <button onClick={() => onClick('N')}>N</button>
                <button onClick={() => onClick('O')}>O</button>
                <button onClick={() => onClick('P')}>P</button>
                <button onClick={() => onClick('Q')}>Q</button>
                <button onClick={() => onClick('R')}>R</button>
                <button onClick={() => onClick('S')}>S</button>
                <button onClick={() => onClick('T')}>T</button>
                <button onClick={() => onClick('U')}>U</button>
                <button onClick={() => onClick('V')}>V</button>
                <button onClick={() => onClick('W')}>W</button>
                <button onClick={() => onClick('X')}>X</button>
                <button onClick={() => onClick('Y')}>Y</button>
                <button onClick={() => onClick('Z')}>Z</button> */}
            </div>
        </Popup>    
    )
}

export default BlankPopup;
