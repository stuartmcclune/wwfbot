import {connect} from 'react-redux';
import {selectRackTile} from '../actions';
import Rack from '../components/rack';

const mapStateToProps = state => {
    return {
        tiles: state.rack,
        selected: state.selectedTile.type === "RACK" ? state.selectedTile.id : null,
    };
}

const mapDispatchToProps = dispatch => {
    return {
        onTileClick: id => {
            dispatch(selectRackTile(id))
        }
    } 
};

const CurrentRack = connect(
    mapStateToProps,
    mapDispatchToProps
)(Rack);

export default CurrentRack;