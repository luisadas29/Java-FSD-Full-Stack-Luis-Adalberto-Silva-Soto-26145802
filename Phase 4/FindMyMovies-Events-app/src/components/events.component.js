import React, { Component } from "react";
import { connect } from "react-redux";
import { updateEvents,deleteEvents,findEventsByName } from "../actions/events";



const mapStateToProps = (state) => {
 return {
        events: state.events.events,
        };
    };

class Events extends Component {
    constructor(props) {
    super(props);
    this.onChangeType = this.onChangeType.bind(this);
    this.onChangeName = this.onChangeName.bind(this);
    this.onChangeDate = this.onChangeDate.bind(this);
    this.onChangeDescription = this.onChangeDescription.bind(this);
    this.onChangeLocation= this.onChangeLocation.bind(this);
    this.updateContent = this.updateContent.bind(this);
    this.removeEvents = this.removeEvents.bind(this);
    this.handleSearch = this.handleSearch.bind(this);

    this.state = {
    currentEvent: {
     id: null,
     type: "",
     name: "",
     date: "",
     description: "",
     location: "",
    },
     message: "",
     searchQuery: "",
    };
    }

componentDidMount() {
 const { match } = this.props;
   if (match && match.params && match.params.name) {
   this.props.findEventsByName(match.params.name);
   }
}

onChangeType(e) {
 const type = e.target.value;
 this.setState(function (prevState) {
 return {
     currentEvent: {
     ...prevState.currentEvent,
     type: type,
     },
    };
    });
}

onChangeName (e) {
     const name = e.target.value;
     this.setState((prevState) => ({
     currentEvent: {
     ...prevState.currentEvent,
     name: name,
     },
    }));
}

onChangeDate (e) {
     const date = e.target.value;
     this.setState((prevState) => ({
     currentEvent: {
     ...prevState.currentEvent,
     date: date,
     },
     }));
}

onChangeDescription(e) {
     const description = e.target.value;
     this.setState((prevState) => ({
     currentEvent: {
     ...prevState.currentEvent,
     description: description,
     }, 
     }));
}

onChangeLocation(e) {
     const location = e.target.value;
     this.setState((prevState) => ({
     currentEvent: {
     ...prevState.currentEvent,
     location: location,
    },
    }));
}

updateContent() {
     this.props
     .updateEvents(this.state.currentEvent.id, this.state.currentEvent)
     .then((reponse) => {
     console.log(reponse);
     this.setState({ message: "The Event was updated successfully!" });
     })
     .catch((e) => {
     console.log(e);
    });
}

removeEvents() {
     this.props
     .deleteEvents(this.state.currentEvent.id)
     .then(() => {
     
     this.setState({
         currentEvent: {
             id: null,
             type: "",
             name: "",
             date: "",
             description: "",
             location: ""
         },
         message: "Event was Removed successfully"
     });
    })
     .catch((e) => {
     console.log(e);
     });
}

handleSearch(event) {
     event.preventDefault();
     this.props.findEventsByName(this.state.searchQuery)
     .then((response) => {
    console.log(response);
     if (response) {
     let foundEvents;
     if (Array.isArray(response)) {
     foundEvents = response;
     } else if (response.data && Array.isArray(response.data)) {
             foundEvents = response.data;
             } else {
                   console.log('Invalid response or missing data');
                   return;
                 }
     console.log(foundEvents);
     if (foundEvents.length > 0) {
     const firstEvent = foundEvents[0];
     this.setState({
     currentEvent: {
        id: firstEvent.id,
        type: firstEvent.type,
        name: firstEvent.name,
        date: firstEvent.date,
        description: firstEvent.description,
        location: firstEvent.location
        }
     });
     } else {
           this.setState({ currentEvent: null });
        }
    } else {
       console.log('Invalid response or missing data');
     }
    })
    .catch((error) => {
          console.log(error);
    });
}

render() {
const { currentEvent } = this.state;
return (
    <div>
    <div>
         <form onSubmit={this.handleSearch}>
           <input type="text" placeholder="Search Events by Name"
           value={this.state.searchQuery}
           onChange={(e) => this.setState({ searchQuery: e.target.value })}/>
           <button type="submit">Search</button>
         </form>
    </div>
    {currentEvent ? (
    <div className="edit-form">
    <h4>Event</h4>
    <form>
        <div className="form-group">
            <label htmlFor="type">Type of Event</label>
            <input type="text" className="form-control" id="type"
            value={currentEvent.type} onChange={this.onChangeType}/>
        </div>
            <div className="form-group">
             <label htmlFor="name">Name of Event</label>
             <input type="text"className="form-control"id="name" value={currentEvent.name}
             onChange={this.onChangeName}
             />
        </div>
             <div className="form-group">
             <label htmlFor="date">Date of Event</label><input type="text" 
             className="form-control" id="date" value={currentEvent.date}
             onChange={this.onChangeDate}
             />
        </div>
        <div className="form-group">
             <label htmlFor="description">Description</label>
             <input type="text" className="form-control" id="description"
             value={currentEvent.description}
             onChange={this.onChangeDescription}
             />
        </div>
        <div className="form-group">
             <label htmlFor="location">Location</label>
             <input type="text" className="form-control" id="location"
             value={currentEvent.location} onChange={this.onChangeLocation}
            />
        </div>
    </form>
    <button className="badge badge-danger mr-1" onClick={this.removeEvents}>
     Delete
    </button>
    <button type="submit" className="badge badge-success" onClick={this.updateContent}>
     Update
    </button>
    <p>{this.state.message}</p>
    </div>
    ) : (
    <div>
    <br />
    <p>No Event Found...</p>
    </div>
    )}
    </div>
    );
    }
} 

export default connect(mapStateToProps, { updateEvents, deleteEvents,findEventsByName })(Events);
