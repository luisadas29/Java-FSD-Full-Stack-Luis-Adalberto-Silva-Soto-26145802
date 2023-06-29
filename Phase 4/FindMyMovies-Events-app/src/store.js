import { legacy_createStore , applyMiddleware} from "redux";
import thunk from 'redux-thunk';
import eventReducer from "./reducers/eventReducer";


const initialState = {};


const store = legacy_createStore(eventReducer, applyMiddleware(thunk));

export default store;