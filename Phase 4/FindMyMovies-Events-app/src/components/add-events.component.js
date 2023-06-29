import React, {Component} from "react";
import {connect} from "react-redux";
import {createEvent} from "../actions/events";
import image3 from "../Images/outdoor2.jpeg"




class AddEvents extends Component {
    constructor(props) {
        super(props);
        this.onChangeType = this.onChangeType.bind(this);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangeDate = this.onChangeDate.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onChangeLocation = this.onChangeLocation.bind(this);
        
        this.saveEvents = this.saveEvents.bind(this);
        this.newEvents = this.newEvents.bind(this);

        this.state = {
            id: null,
            type: "",
            name: "",
            date: "",
            description: "",
            location: "",

            submitted:false,

        };
    }

    onChangeType(e){
        this.setState({
            type: e.target.value,
        });
    }

    onChangeName(e){
        this.setState({
            name: e.target.value,
        });
    }

    onChangeDate(e){
        this.setState({
            date: e.target.value,
        });
    }

    onChangeDescription(e){
        this.setState({
            description: e.target.value,
        });
    }

    onChangeLocation(e){
      this.setState({
          location: e.target.value,
      });
  }

    saveEvents(){
        const {type,name,date,description,location} = this.state;

        this.props
        .createEvent(type,name,date,description,location)
        .then((data)=> {
            this.setState({
                id:data.id,
                type: data.type,
                name: data.name,
                date: data.date,
                description: data.description,
                location: data.location,
                submitted:true,
            });
            console.log(data);
        })
        .catch((e) =>{
            console.log(e);
        });
    }

    newEvents(){
            this.setState({
                id: null,
                type: "",
                name: "",
                date: "",
                description: "",
                location: "",

                submitted:false,

            });
        }
    

    
    render() {
        return (
          <div className="bg-secondary"> 
          <img src={image3} alt="Image 1" className="center"/>
          <div className="submit-form" >
            {this.state.submitted ? (
              <div>
                <h4>You have submitted successfully the Event!</h4>
                <button className="btn btn-success" onClick={this.newEvents}>
                  Add another event
                </button>
              </div>
            ) : (
              <div>
                  <div className="form-group">
                  <label htmlFor="type">Type of Event</label>
                  <input
                    type="text"
                    className="form-control"
                    id="type"
                    required
                    value={this.state.type}
                    onChange={this.onChangeType}
                    name="type"
                  />
                </div>

                <div className="form-group">
                  <label htmlFor="name">Name of event</label>
                  <input
                    type="text"
                    className="form-control"
                    id="name"
                    required
                    value={this.state.name}
                    onChange={this.onChangeName}
                    name="name"
                  />
                </div>

                <div className="form-group">
                <label htmlFor="date">Date of the event</label>
                  <input
                    type="text"
                    className="form-control"
                    id="date"
                    required
                    value={this.state.date}
                    onChange={this.onChangeDate}
                    name="date"
                  />
                </div>

                <div className="form-group">
                 <label htmlFor="description">Description of the event</label>
                 <input
                   type="text"
                   className="form-control"
                   id="description"
                   required
                   value={this.state.description}
                   onChange={this.onChangeDescription}
                   name="description"
                 />
               </div>

               <div className="form-group">
                <label htmlFor="location">Location of the event</label>
                  <input
                    type="text"
                    className="form-control"
                    id="location"
                    required
                    value={this.state.location}
                    onChange={this.onChangeLocation}
                    name="location"
                  />
                </div>
 

               <button onClick={this.saveEvents} className="btn btn-success">
                Submit
               </button>
               </div>
            )}
            </div>
            </div>
          
        );
            }
        }


export default connect(null,{createEvent})(AddEvents);