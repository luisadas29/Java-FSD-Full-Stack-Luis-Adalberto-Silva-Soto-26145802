function Checkout({ basketItems }) {
    console.log("Checkout Basket Items:", basketItems);
    return (
        <div>
            <h2>Checkout</h2>
            {basketItems.length > 0 ? (
                <ul>
                    {basketItems.map((item) => (
                        <li key={item.medicineid}>
                            {item.name} - £{item.price}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No items in the basket.</p>
            )}
        </div>
    );
}

export default Checkout;