import "./bootstrap.min.css";
import './App.css';
import Login from './Login';
import SignUp from './SignUp';
import { Routes,Route, Link } from 'react-router-dom';
import Admin from './Components/Admin'
import Customer from './Components/Customer'
import Homepage from './Components/Homepage'
import AddMedicine from './Components/AddMedicine';
import ViewMedicine from './Components/ViewMedicine';
import BrowseMedical from "./Components/BrowseMedical";
import React, { useState } from "react";
import { UserProvider } from './UserContext';
import Checkout from "./Components/Checkout";



function App() {
  const [basket, setBasket] = useState([]);
  return (
    <div className="App">
          <nav className="navbar navbar-expand navbar-dark bg-dark">
        <Link to={"/"} className="navbar-brand">
          Medicare Website - your One Stop for Medical supplies!
        </Link>
        <div className="navbar-nav mr-auto">
          <li className ="nav-item">
            <Link to={"/login"} className="nav-link">
              Login
            </Link>
          </li>
          <li className ="nav-item">
            <Link to={"/signup"} className="nav-link">
              Signup
            </Link>
          </li>
          </div> 
      </nav>

      <UserProvider>

      <Routes>

        <Route path="/" element={<Homepage/>}/>
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/login" element={<Login/>}/>
        
        <Route path='/admin' element={<Admin/>}>
          <Route path ="addMedicine" element={<AddMedicine/>}/>
          <Route path ="viewMedicine" element={<ViewMedicine/>}/>
        </Route>
        <Route path="/customer" element={<Customer basket={basket} setBasket={setBasket} />}>
          <Route path="browseMedical" element={<BrowseMedical basket={basket} setBasket={setBasket} />} />
        </Route>
        <Route path="/customer/checkout" element={<Checkout basketItems={basket} />} />


      </Routes>
      </UserProvider>
    </div>
  );
}

export default App;
