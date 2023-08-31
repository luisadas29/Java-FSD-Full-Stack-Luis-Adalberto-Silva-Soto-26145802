// import React, { useState } from 'react';
// import { useUser } from './UserContext';
// import axios from 'axios';
// import { Link, useNavigate } from 'react-router-dom';


// function Login() {
//   const { setUserEmail } = useUser(); // Access the setUserEmail function from the context
//   const [emailid, setEmailid] = useState('');
//   const [password, setPassword] = useState('');
//   const [typeofuser, setTypeOfUser] = useState('');
//   const navigate = useNavigate();

//   const signIn = async (event) => {
//     event.preventDefault();
//     let login = { emailid: emailid, password: password, typeofuser: typeofuser };
//     try {
//       let result = await axios.post('http://localhost:8080/Login/signIn', login);
//       if (result.data === 'Admin Success') {
//         navigate('/admin');
//       } else if (result.data === 'Customer success') {
//         // Set the user's email after signing in
//         setUserEmail(emailid);
//         navigate('/customer');
//       } else {
//         alert(result.data); // Display the actual result
//       }
//     } catch (ex) {
//       console.log(ex);
//     }
//   };

//   return (
//     <div>
//       <div>Login Page</div>
//       <form onSubmit={signIn}>
//         <label>Email</label>
//         <input type="email" name="emailid" onChange={(e) => setEmailid(e.target.value)} />
//         <br />
//         <label>Password</label>
//         <input type="password" name="password" onChange={(e) => setPassword(e.target.value)} />
//         <br />
//         <label>Type Of User</label>
//         <input type="radio" name="typeofuser" value="admin" onChange={(e) => setTypeOfUser(e.target.value)} />Admin
//         <input type="radio" name="typeofuser" value="customer" onChange={(e) => setTypeOfUser(e.target.value)} />Customer
//         <br />
//         <input type="submit" value="submit" />
//         <input type="reset" value="reset" />
//         <br />
//         <Link to="/signup">SignUp</Link>
//       </form>
//     </div>
//   );
// }

// export default Login;

// import React, { useState } from 'react';
// import { useUser } from './UserContext';
// import axios from 'axios';
// import { Link, useNavigate } from 'react-router-dom';
// import './Login.css'; // Import your CSS file for styling

// function Login() {
//   const { setUserEmail } = useUser(); // Access the setUserEmail function from the context
//   const [emailid, setEmailid] = useState('');
//   const [password, setPassword] = useState('');
//   const [typeofuser, setTypeOfUser] = useState('');
//   const navigate = useNavigate();

//   const signIn = async (event) => {
//     event.preventDefault();
//     let login = { emailid: emailid, password: password, typeofuser: typeofuser };
//     try {
//       let result = await axios.post('http://localhost:8080/Login/signIn', login);
//       if (result.data === 'Admin Success') {
//         navigate('/admin');
//       } else if (result.data === 'Customer success') {
//         // Set the user's email after signing in
//         setUserEmail(emailid);
//         navigate('/customer');
//       } else {
//         alert(result.data); // Display the actual result
//       }
//     } catch (ex) {
//       console.log(ex);
//     }
//   };

//   return (
//     <div className="login-container">
//       <div className="login-header">Login Page</div>
//       <form className="login-form" onSubmit={signIn}>
//         <label>Email</label>
//         <input className="login-input" type="email" name="emailid" onChange={(e) => setEmailid(e.target.value)} />
//         <br />
//         <label>Password</label>
//         <input className="login-input" type="password" name="password" onChange={(e) => setPassword(e.target.value)} />
//         <br />
//         <label>Type Of User</label>
//         <div className="radio-group">
//           <input type="radio" name="typeofuser" value="admin" onChange={(e) => setTypeOfUser(e.target.value)} />
//           <span>Admin</span>
//           <input type="radio" name="typeofuser" value="customer" onChange={(e) => setTypeOfUser(e.target.value)} />
//           <span>Customer</span>
//         </div>
//         <br />
//         <input className="submit-button" type="submit" value="Submit" />
//         <input className="reset-button" type="reset" value="Reset" />
//         <br />
//         <Link className="signup-link" to="/signup">Sign Up</Link>
//       </form>
//     </div>
//   );
// }

// export default Login;
import React, { useState } from 'react';
import { useUser } from './UserContext';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './Login.css'; // Import your CSS file for styling

function Login() {
  const { setUserEmail } = useUser();
  const [emailid, setEmailid] = useState('');
  const [password, setPassword] = useState('');
  const [typeofuser, setTypeOfUser] = useState('');
  const navigate = useNavigate();

  const signIn = async (event) => {
    event.preventDefault();
    let login = { emailid: emailid, password: password, typeofuser: typeofuser };
    try {
      let result = await axios.post('http://localhost:8080/Login/signIn', login);
      if (result.data === 'Admin Success') {
        navigate('/admin');
      } else if (result.data === 'Customer success') {
        setUserEmail(emailid);
        navigate('/customer');
      } else {
        alert(result.data);
      }
    } catch (ex) {
      console.log(ex);
    }
  };

  return (
    <div className="login-container">
      <div className="login-header">Login Page</div>
      <form className="login-form" onSubmit={signIn}>
        <label>Email</label>
        <input
          className="login-input"
          type="email"
          name="emailid"
          onChange={(e) => setEmailid(e.target.value)}
        />
        <label>Password</label>
        <input
          className="login-input"
          type="password"
          name="password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <div className="radio-group">
          <input
            type="radio"
            name="typeofuser"
            value="admin"
            onChange={(e) => setTypeOfUser(e.target.value)}
          />
          <span>Admin</span>
          <input
            type="radio"
            name="typeofuser"
            value="customer"
            onChange={(e) => setTypeOfUser(e.target.value)}
          />
          <span>Customer</span>
        </div>
        <input className="submit-button" type="submit" value="Submit" />
        <input className="reset-button" type="reset" value="Reset" />
        <Link className="signup-link" to="/signup">
          SignUp
        </Link>
      </form>
    </div>
  );
}

export default Login;
