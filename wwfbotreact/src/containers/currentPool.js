import {connect} from 'react-redux';
import {selectPoolTile} from '../actions';
import Pool from '../components/pool';

const mapStateToProps = state => {
    return {
        tiles: state.pool,
        selected: state.selectedTile.type === "POOL" ? state.selectedTile.id : null,
    }
};

const mapDispatchToProps = dispatch => {
    return {
        onTileClick: id => {
            dispatch(selectPoolTile(id))
        }
    }
};

const CurrentPool = connect(
    mapStateToProps,
    mapDispatchToProps
)(Pool);

export default CurrentPool;