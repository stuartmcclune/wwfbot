import React from 'react';

function Loading({isLoading}) {

    return(
        <div className={isLoading ? "loading" : "loading hide"}>
            <h1>Calculating Best Move...</h1>
        </div>
        
    )
}

export default Loading;
