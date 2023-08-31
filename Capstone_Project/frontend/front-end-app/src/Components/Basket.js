// import React from "react";

// function Basket({ basketItems }) {
//     return (
//         <div>
//             <h2>Shopping Basket</h2>
//             <ul>
//                 {basketItems.map((item) => (
//                     <li key={item.medicineid}>
//                         {item.medicineid} - {item.name} - £{item.price}
//                     </li>
//                 ))}
//             </ul>
//         </div>
//     );
// }

// export default Basket;

// function Basket({ basketItems, onRemoveItem }) {
//     return (
//       <div>
//         <h2>Checkout</h2>
//         {basketItems.length > 0 ? (
//           <ul>
//             {basketItems.map((item) => (
//               <li key={item.medicineid}>
//                 {item.name} - £{item.price}
//                 <button onClick={() => onRemoveItem(item.medicineid)}>Remove</button>
//               </li>
//             ))}
//           </ul>
//         ) : (
//           <p>No items in the basket.</p>
//         )}
//       </div>
//     );
//   }
  
//   export default Basket;

// Basket.js
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

