import React from "react";

function Basket({ basketItems }) {
    return (
        <div>
            <h2>Shopping Basket</h2>
            <ul>
                {basketItems.map((item) => (
                    <li key={item.medicineid}>
                        {item.name} - £{item.price}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Basket;
