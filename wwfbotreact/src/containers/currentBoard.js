import {connect} from 'react-redux';
import {selectBoardTile} from '../actions';
import Board from '../components/board';

const mapStateToProps = state => {
    return {
        tiles: state.board,
        selected: state.selectedTile.type === "BOARD" ? state.selectedTile.id : null,
    }
};

const mapDispatchToProps = dispatch => {
    return {
        onTileClick: id => {
            dispatch(selectBoardTile(id))
        }
    }
};

const CurrentBoard = connect(
    mapStateToProps,
    mapDispatchToProps
)(Board);

export default CurrentBoard;