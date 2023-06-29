
import './App.css';
import React, {Component} from "react";
import "./bootstrap.min.css";
import { BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom';
import AddEvents from './components/add-events.component';
import EventsList from './components/event-list.component';
import Events from  './components/events.component';
import HomePage from './components/home-page.component';



class App extends Component{

  render() {

  return (

    <Router>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <Link to={"/"} className="navbar-brand">
          FindmyMovies Local Events App!
        </Link>
        <div className="navbar-nav mr-auto">
          <li className ="nav-item">
            <Link to={"/events"} className="nav-link">
              All Events
            </Link>
          </li>
          <li className ="nav-item">
            <Link to={"/searchEvents"} className="nav-link">
              Search Events
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"/add"} className="nav-link">
              Add Event
            </Link>
          </li>
          </div> 
      </nav>

      <div className="container mt-3">
        <Routes>
            <Route path="/" element={<HomePage />} />
          <Route path={'/events'} element={<EventsList></EventsList>}     />
          <Route path='/add' element={<AddEvents></AddEvents>} />     
          <Route path="/searchEvents" element={<Events />} />
        </Routes>
      </div>
    

    
    </Router>
    
  );
}
}



export default App;
