import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch} from 'react-redux';
import { getEvents, deleteEvents} from '../actions/events';
//import { useNavigate } from 'react-router-dom';

const EventList = () => {
  const events = useSelector((state) => state.events);
  const dispatch = useDispatch();
  //const navigate = useNavigate();
 

  useEffect(() => {
    dispatch(getEvents());
  }, [dispatch]);

  const handleDeleteEvent = (eventId) => {
    dispatch(deleteEvents(eventId))
      .then(() => dispatch(getEvents()))
      .catch((error) => {
        console.log('Error deleting event:', error);
      });
  };


  if (!Array.isArray(events)) {
    return <p>Loading events...</p>;
  }

  if (events.length === 0 ) {
    return <p>No events are available...</p>;
  }


  return (
    <div>
      <div className='bg-secondary'>
      <div className='center'>
      <h2>Event List</h2>
          {events.map((event) => (
            <div key={event.id} className="card mb-2">
            <div className="card-body">
            <h5 className="card-title">{event.name}</h5>
            <p className="card-text">{event.date}</p>
            <p className="card-text">{event.description}</p>
            <p className="card-text">{event.location}</p>
            <button className="badge btn-danger mr-1"
             onClick={() => handleDeleteEvent(event.id)}>Delete</button>
            </div>
          </div>         
          ))}
    </div>
    </div>
    </div>
  );
};

export default EventList;

