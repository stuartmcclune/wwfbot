import React from 'react'
import { connect } from 'react-redux'
import { fetchBestMove } from '../actions'


let CheatButton = ({dispatch}) => {
    return (
        <button className="cheatBtn" onClick={() => dispatch(fetchBestMove())}>Cheat</button>
    )
}

CheatButton = connect()(CheatButton);

export default CheatButton;