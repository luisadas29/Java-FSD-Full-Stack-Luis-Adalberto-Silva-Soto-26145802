

import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './Signup.css'; // Import the CSS for styling

function SignUp() {
  const [emailid, setEmailid] = useState('');
  const [password, setPassword] = useState('');
  const [typeOfUser, setTypeOfUser] = useState('');

  const signIn = async (event) => {
    event.preventDefault();
    const login = { emailid, password, typeOfUser };
    try {
      const result = await axios.post('http://localhost:8080/Login/signUp', login);
      console.log(result.data);
      alert('Account Created Successfully!! Please sign in.');
    } catch (ex) {
      console.log(ex);
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-header">Account Creation</div>
      <form className="signup-form" onSubmit={signIn}>
        <label>EmailId</label>
        <input
          type="email"
          name="emailid"
          className="signup-input"
          onChange={(e) => setEmailid(e.target.value)}
        />
        <br />
        <label>Password</label>
        <input
          type="password"
          name="password"
          className="signup-input"
          onChange={(e) => setPassword(e.target.value)}
        />
        <br />
        <div className="radio-group">
          <input
            type="radio"
            name="User"
            value="customer"
            onChange={(e) => setTypeOfUser(e.target.value)}
          />
          <label>Customer</label>
        </div>
        <input type="submit" className="submit-button" value="Submit" />
        <input type="reset" className="reset-button" value="Reset" />
        <br />
        <Link to="/Login" className="login-link">
          Login
        </Link>
      </form>
    </div>
  );
}

export default SignUp;
