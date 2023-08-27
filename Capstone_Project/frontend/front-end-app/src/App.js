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



function App() {
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
          <li className="nav-item">
            <Link to={"/browseMedical"} className="nav-link">
              Browse Medical Supplies
            </Link>
          </li>
          </div> 
      </nav>



      <Routes>

        <Route path="/" element={<Homepage/>}/>
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/login" element={<Login/>}/>
        
        <Route path='/admin' element={<Admin/>}>
          <Route path ="addMedicine" element={<AddMedicine/>}/>
          <Route path ="viewMedicine" element={<ViewMedicine/>}/>
        </Route>
        
        <Route path='/customer' element={<Customer/>}>
          <Route path ="viewMedicine" element={<ViewMedicine/>}/>
        </Route>

      </Routes>
    </div>
  );
}

export default App;
