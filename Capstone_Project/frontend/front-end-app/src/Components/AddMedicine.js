import axios from "axios";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function AddMedicine(){

    let [name,setName]=useState("");
    let [description,setDescription]=useState("");
    let [price,setPrice]=useState("");
    let [inventory,setInventory]=useState("");
    let [imageurl,setImageURL]=useState("");
    let [enable,setEnable]=useState("");
    let navigate = useNavigate();

    let addMedicine=async (event)=> {
        event.preventDefault();
        let medicine = {
            "name":name,
            "description":description,
            "price":price,
            "inventory":inventory,
            "imageurl":imageurl,
            "enable":enable
        };
        try{
        let result = await axios.post("http://localhost:8080/Medicine/addMedicine",medicine);
        //console.log(result.data);
        if(result.data=="Medicine created"){
            alert("Medicine Created Successfully!!")
        }else{
            alert("Please try again");
        }
        }catch(ex){
            console.log(ex);
        }
    }


    return(
        <div>
            <div>Add Medicine</div>
            <form onSubmit={addMedicine}>
            <label>name</label>
            <input type ="name" name ="name" onChange={e=>setName(e.target.value)}/><br/>
            <label>Description</label>
            <input type ="description" name ="description" onChange={e=>setDescription(e.target.value)}/><br/>
            <label>Price</label>
            <input type ="price" name ="price" onChange={e=>setPrice(e.target.value)}/><br/>
            <label>Quantity</label>
            <input type ="inventory" name ="inventory" onChange={e=>setInventory(e.target.value)}/><br/>
            <label>Image URL</label>
            <input type ="imageurl" name ="imageurl" onChange={e=>setImageURL(e.target.value)}/><br/>
            <input type="submit" value= "submit" />
            <input type="reset" value= "reset" /><br/>
            </form>
        </div>
    )

}

export default AddMedicine;