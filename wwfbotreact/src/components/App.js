import React from 'react';
import '../styles/App.css';
import CurrentBoard from '../containers/currentBoard';
import CurrentRack from '../containers/currentRack';
import CurrentPool from '../containers/currentPool';
import CheatButton from '../containers/cheatButton';
import LoadingScreen from '../containers/loadingScreen';

function App() {

  return (
    <div className="app">
      <LoadingScreen />
      <div className="title">
        <h1>wwfBot</h1>
      </div>
      <div className="content">
        <CurrentRack />
        <div className="contentMiddle">
          <CurrentBoard />
          <CheatButton />
        </div>
        <CurrentPool />
        
      </div>
      
    </div>
  )

 
}

export default App;
