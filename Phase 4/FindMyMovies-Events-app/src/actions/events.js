import {
    CREATE_EVENTS,
    UPDATE_EVENTS,
    DELETE_EVENT,
    GET_EVENTS
} from "./type";

import axios from 'axios';

import eventsDataService from "../events.service"




export const createEvent= (type,name,date,description,location) => async (dispatch) =>{
    try {
        const res = await eventsDataService.create({type,name,date,description,location});

        dispatch({
            type: CREATE_EVENTS,
            payload: res.data,
        });
        return Promise.resolve(res.data);
    }
    catch (error){
        return Promise.reject(error);
    }
};



  export const getEvents = () => {
    return async (dispatch) => {
      try {
        const response = await axios.get('http://localhost:3000/events');
        dispatch({
          type: GET_EVENTS,
          payload: response.data,
        });
        console.log(response.data)
      } catch (error) {
        console.error('Error while fetching events:', error);
      }
    };
  };

export const updateEvents= (id,data) => async (dispatch) =>{
    try {
        const res = await eventsDataService.update(id,data);

        dispatch({
            type: UPDATE_EVENTS,
            payload: data,
        });
        return Promise.resolve(res.data);
    }
    catch (error){
        return Promise.reject(error);
    }
};

export const deleteEvents= (id) => async (dispatch) =>{
    try {
        const res = await eventsDataService.delete(id);

        dispatch({
            type: DELETE_EVENT,
            payload: { id },
        });
        return Promise.resolve(res.data);
    }
    catch (error){
        return Promise.reject(error);
    }
};


export const findEventsByName = (name) => {
  return (dispatch) => {
    return new Promise((resolve, reject) => {
      eventsDataService.findByName(name)
        .then((response) => {
          const foundEvents = response.data;
          console.log(foundEvents);
          dispatch({ type: "RETRIEVE_EVENTS", payload: foundEvents });
          resolve(foundEvents);
        })
        .catch((error) => {
          console.log(error);
          reject(error);
        });
    });
  };
};

