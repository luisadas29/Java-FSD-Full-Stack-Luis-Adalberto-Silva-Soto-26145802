// import { Link,Outlet } from "react-router-dom";

// function Admin(){


//     return(
//         <div>
//             <h2>Welcome to Admin Home Page</h2>
//             <Link to="addMedicine">Add Medicine</Link> |
//             <Link to="viewMedicine">View all Products</Link> |
//             <Link to="allOrders">View All Placed Orders</Link> |
//             <Link to="/">Logout</Link> |
//             <hr/>
//             <Outlet></Outlet>
//         </div>
//     )

// }

// export default Admin;

import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import '../Admin.css'; // Import the CSS for styling

function Admin() {
  return (
    <div className="admin-container">
      <h2 className="admin-header">Welcome to Admin Home Page</h2>
      <nav className="admin-nav">
        <Link to="addMedicine">Add Medicine</Link>
        <Link to="viewMedicine">View all Products</Link>
        <Link to="allOrders">View All Placed Orders</Link>
        <Link to="/">Logout</Link>
      </nav>
      <hr className="admin-hr" />
      <Outlet />
    </div>
  );
}

export default Admin;
