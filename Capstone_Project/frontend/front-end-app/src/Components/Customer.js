import { Link ,Outlet} from "react-router-dom";
import '../Admin.css'; 
import React from 'react';


function Customer(){


    return(
    <div className="admin-container">
    <h2 className="admin-header">Welcome to Customer Home Page</h2>
    <nav className="admin-nav">
            <Link to="browseMedical">Purchase Medicines!</Link> 
            <Link to ="orders">View Past Orders</Link> 
            <Link to ="topUpAccount">Top Up Account</Link> 
            <Link to="/">Logout</Link> 
    </nav>
    {/* <hr className="admin-hr" /> */}
    <Outlet />
  </div>
);

}

export default Customer;



  
