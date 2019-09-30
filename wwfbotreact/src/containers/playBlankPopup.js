import {connect} from 'react-redux'
import BlankPopup from '../components/blankPopup'
import {closePopup} from '../actions'

const mapStateToProps = state => {
    return {
        isOpen: state.popupOpen
    }
}

const mapDispatchToProps = dispatch => {
    return {
        onClick: letter => {
            dispatch(closePopup(letter))
        }
    }
}

const PlayBlankPopup = connect(
    mapStateToProps,
    mapDispatchToProps
)(BlankPopup);

export default PlayBlankPopup;