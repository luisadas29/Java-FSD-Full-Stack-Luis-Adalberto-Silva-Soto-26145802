import axios from "axios";
import { useState } from "react";

function Login (){
    let [emailid,setEmailid]=useState("");
    let [password,setPassword]=useState("");
    let [typeofuser,setTypeOfUser]=useState("");

    let signIn=async (event)=> {
        event.preventDefault();
        //console.log(emailid +" "+password+" "+typeofuser);
        let login = {"emailid":emailid,"password":password,"typeofuser":typeofuser};
        try{
        let result = await axios.post("http://localhost:8080/Login/signIn",login);
        console.log(result.data);
        }catch(ex){
            console.log(ex);
        }
    }

    return(
        <div>
            <div>Login Page</div>
            <form onSubmit={signIn}>
            <label>EmailId</label>
            <input type ="email" name ="emailid" onChange={e=>setEmailid(e.target.value)}/><br/>
            <label>Password</label>
            <input type ="password" name ="password" onChange={e=>setPassword(e.target.value)}/><br/>
            <label>TypeOfUser</label>
            <input type ="radio" name ="typeofuser" value="admin" onChange={e=>setTypeOfUser(e.target.value)}/>Admin
            <input type ="radio" name ="typeofuser" value="customer" onChange={e=>setTypeOfUser(e.target.value)}/>Customer<br/>
            <input type="submit" value= "submit" />
            <input type="reset" value= "reset" />
            </form>
        </div>
    )
}

export default Login;