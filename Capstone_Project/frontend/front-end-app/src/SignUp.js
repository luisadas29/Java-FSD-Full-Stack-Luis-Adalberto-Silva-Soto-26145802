import axios from "axios";
import { useState } from "react";
import { Link } from "react-router-dom";

function SignUp (){
    let [emailid,setEmailid]=useState("");
    let [password,setPassword]=useState("");
    let [typeOfUser,setTypeOfUser]=useState("");

    let signIn=async (event)=> {
        event.preventDefault();
        //console.log(emailid +" "+password+" "+typeofuser);
        let login = {"emailid":emailid,"password":password,"typeOfUser":typeOfUser};
        try{
        let result = await axios.post("http://localhost:8080/Login/signUp",login);
        console.log(result.data);
        alert("Account Created Successfully!! , please sign In")
        }catch(ex){
            console.log(ex);
        }
    }

    return(
        <div>
            <div>Account Create</div>
            <form onSubmit={signIn}>
            <label>EmailId</label>
            <input type ="email" name ="emailid" onChange={e=>setEmailid(e.target.value)}/><br/>
            <label>Password</label>
            <input type ="password" name ="password" onChange={e=>setPassword(e.target.value)}/><br/>
            <label></label>
            <input type="radio" name="User " value="customer" onChange={e=>setTypeOfUser(e.target.value)}/>Customer<br/>           
            <input type="submit" value= "submit" />
            <input type="reset" value= "reset" /><br/>
            <Link to="/Login">Login</Link>
            </form>
        </div>
    )
}

export default SignUp;