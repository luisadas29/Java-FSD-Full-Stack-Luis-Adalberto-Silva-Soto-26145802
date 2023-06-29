import {
    CREATE_EVENTS,
    UPDATE_EVENTS,
    DELETE_EVENT,
    GET_EVENTS
} from "../actions/type";

const initialState = {
    events: [],
  };


const eventReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_EVENTS:
      return {
        ...state,
        events: action.payload,
      };
    case CREATE_EVENTS:
      return {
        ...state,
        events: action.payload,
      }
    case DELETE_EVENT:
        const updatedEvents = state.events.filter((event)=> event.id !== 
        action.payload);
      return {
        ...state,
      events: updatedEvents,
      }
      case UPDATE_EVENTS:
        return{
               ...state,
                events: action.payload, 
              }
    default:
      return state;
  }
};

export default eventReducer;

