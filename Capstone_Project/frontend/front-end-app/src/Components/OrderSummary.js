import React from "react";
import { useLocation, Link } from "react-router-dom";
import "../OrderSummary.css"; // Import your CSS file for styling

function OrderSummary() {
  const location = useLocation();
  const { orderItems } = location.state || { orderItems: [] }; // Access the order items from state
  const totalCost = orderItems.reduce((total, item) => total + item.price, 0);
  console.log(orderItems);

  return (
    <div className="order-summary">
      <h2>Order Summary</h2>
      {orderItems.length > 0 ? (
        <ul className="order-items">
          {orderItems.map((item, index) => (
            <li key={index}>
              {item.name} - £{item.price}
            </li>
          ))}
        </ul>
      ) : (
        <p className="empty-message">No items in the basket.</p>
      )}
      <p className="total-cost">Total Cost: £{totalCost.toFixed(2)}</p>
      <Link to="/customer/browseMedical" className="back-link">
        Back to Browse Medical
      </Link>
    </div>
  );
}

export default OrderSummary;


