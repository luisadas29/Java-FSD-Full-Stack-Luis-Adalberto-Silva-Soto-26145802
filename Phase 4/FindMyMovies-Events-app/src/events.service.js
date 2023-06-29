import http from "./http.common.all";
import axios from 'axios';

const BASE_URL = 'http://localhost:3000/';



class eventsDataService{


    get(id) {
        return http.get(`/events/${id}`);
    }

    create(data) {
        return http.post("/events",data);
    }

    update(id,data){
        return http.put(`/events/${id}`,data);
    }

    delete(id){
        return http.delete(`/events/${id}`);
    }

    findByName(name) {
        return axios.get(`${BASE_URL}events`, { params: { name } });
      }
      
    }

export default new eventsDataService;