
import React from "react";
import "../Basket.css";

function Basket({ basketItems, onRemoveItem }) {
  return (
    <div className="basket-container">
      <div className="basket-header">
        <h2>Basket</h2>
      </div>
      <ul className="basket-items">
        {basketItems.map((item) => (
          <li className="basket-item" key={item.medicineid}>
            <div className="basket-item-details">
              <span className="basket-item-name">{item.name}</span>
              <span className="basket-item-price">£{item.price}</span>
            </div>
            <span
              className="basket-item-remove"
              onClick={() => onRemoveItem(item.medicineid)}
            >
              Remove
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Basket;

