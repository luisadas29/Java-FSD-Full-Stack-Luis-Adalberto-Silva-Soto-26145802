import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import '../Admin.css'; 

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
      {/* <hr className="admin-hr" /> */}
      <Outlet />
    </div>
  );
}

export default Admin;
