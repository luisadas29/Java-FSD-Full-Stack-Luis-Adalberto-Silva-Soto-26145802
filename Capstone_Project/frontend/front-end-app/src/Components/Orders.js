import React, { useState, useEffect } from "react";
import axios from "axios";
import { useUser } from '../UserContext';
import "../Orders.css"; 

function Orders() {
  const [orderHistory, setOrderHistory] = useState([]);
  const user = useUser();

  useEffect(() => {
    fetchOrderHistory();
  }, []);

  const fetchOrderHistory = async () => {
    try {
      if (!user) {
        console.log("User not logged in");
        return;
      }
      const usersEmail = user.userEmail;
      const response = await axios.get(`http://localhost:8080/orders/history?email=${usersEmail}`);
      setOrderHistory(response.data);
    } catch (error) {
      console.error("Error fetching order history:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="orders-title">Your Order History</h2>
      <table className="table orders-table">
        <thead>
          <tr>
            <th>Order ID</th>
            <th>Total Cost (£)</th>
            <th>Order Date</th>
            <th>Items</th>
          </tr>
        </thead>
        <tbody>
          {orderHistory.length > 0 ? (
            orderHistory.map(order => (
              <tr key={order.orderid}>
                <td>{order.orderid}</td>
                <td>£{order.totalCost.toFixed(2)}</td>
                <td>{new Date(order.orderDate).toLocaleDateString()}</td>
                <td>
                  <ul className="order-items-list">
                    {order.orderItemStrings && order.orderItemStrings.length > 0 ? (
                      JSON.parse(order.orderItemStrings).map((item, index) => (
                        <li key={index}>{item}</li>
                      ))
                    ) : (
                      <li>No items</li>
                    )}
                  </ul>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="no-orders-text">
                You have no order history.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}

export default Orders;
