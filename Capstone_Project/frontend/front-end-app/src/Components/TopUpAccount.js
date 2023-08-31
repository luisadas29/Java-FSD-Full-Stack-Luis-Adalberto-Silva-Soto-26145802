import axios from "axios";
import { useUser } from '../UserContext';
import React, { useState, useEffect } from "react";

function TopUpAccount() {
  const user = useUser();
  const [newAmount, setNewAmount] = useState(0);
  const [creditCardNumber, setCreditCardNumber] = useState("");
  const [expiryDate, setExpiryDate] = useState("");
  const [csv, setCSV] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [accountAmount, setAccountAmount] = useState(0); 
  const [errorMessage, setErrorMessage] = useState("");
  const [totalAmount, setTotalAmount] = useState(0);


  const handleTopUp = async () => {

    const newAmount = accountAmount + parseFloat(totalAmount);
    console.log(totalAmount);
    console.log(newAmount);
    try {
        const usersEmail = user.userEmail;
        console.log(usersEmail);
        const response = await axios.put("http://localhost:8080/account/topUp", {
            email: usersEmail,
            newAmount: parseFloat(newAmount)
          });
      if (response.data) {
        setSuccessMessage("Top-up successful!");
        setErrorMessage("");
      } else {
        setSuccessMessage("");
        setErrorMessage("Top-up failed. Please check your details and try again.");
      }
    } catch (error) {
      console.error("Error topping up account:", error);
      setSuccessMessage("");
      setErrorMessage("An error occurred. Please try again later.");
    }
  };

  const loadAccountAmount = async () => {
    try {
        const usersEmails = user.userEmail;
        console.log(usersEmails);
        const accountResponse = await axios.get(`http://localhost:8080/account/amount?email=${usersEmails}`);
        const fetchedAccountAmount = accountResponse.data;
        setAccountAmount(fetchedAccountAmount); 
        console.log(accountAmount);
    } catch (error) {
        console.error("Error fetching Account Amount:", error);
    }
};

useEffect(() => {
    if (user) {
        loadAccountAmount();
    }
}, [user]);

  return (
    <div className="container mt-4">
      <h2>Top Up Account</h2>
      {successMessage && <p className="success-message">{successMessage}</p>}
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <div>
        <label>Amount to Deposit (£):</label>
        <input
          type="number"
          value={totalAmount}
          onChange={(e) => setTotalAmount(e.target.value)}
        />
      </div>
      <div>
        <label>Credit Card Number:</label>
        <input
          type="text"
          value={creditCardNumber}
          onChange={(e) => setCreditCardNumber(e.target.value)}
        />
      </div>
      <div>
        <label>Expiry Date:</label>
        <input
          type="text"
          value={expiryDate}
          onChange={(e) => setExpiryDate(e.target.value)}
        />
      </div>
      <div>
        <label>CSV:</label>
        <input
          type="text"
          value={csv}
          onChange={(e) => setCSV(e.target.value)}
        />
      </div>
      <button onClick={handleTopUp}>Top Up</button>
    </div>
  );
}

export default TopUpAccount;
