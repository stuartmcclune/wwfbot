import {connect} from 'react-redux';
import Loading from '../components/loading';

const mapStateToProps = state => {
    return {
        isLoading: state.isFetching
    }
        
}

const LoadingScreen = connect(
    mapStateToProps
)(Loading);

export default LoadingScreen;