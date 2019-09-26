import React from 'react';
import Board from './board';
import Pool from './pool';
import Rack from './rack';

function App() {

  return (
    <div className="app">
      <div className="title">
        <h1>wwfBot</h1>
      </div>
      <div className="content">
        <Rack />
        <div className="contentMiddle">
          <Board />
          <button className="cheatBtn">Cheat</button>
        </div>
        <Pool />
        
      </div>
      
    </div>
  )
}

export default App;
