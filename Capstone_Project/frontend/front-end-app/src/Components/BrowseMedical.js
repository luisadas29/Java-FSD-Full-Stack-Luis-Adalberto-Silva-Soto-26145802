import axios from "axios";
import React, { useState, useEffect } from "react";
import Basket from "./Basket";
import { useUser } from '../UserContext';
import "../BrowseMedical.css";
import { Link, useNavigate } from "react-router-dom"; 

function BrowseMedical() {
    const [medicines, setMedicines] = useState([]);
    const [basket, setBasket] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [totalBasketAmount, setTotalBasketAmount] = useState(0);
    const [accountAmount, setAccountAmount] = useState(0); 
    const user = useUser(); 
    const navigate = useNavigate();
    

    useEffect(() => {
        console.log("Basket Items:", basket);
    }, [basket]);
    
    
    const loadMedicines = async () => {
        try {
            const response = await axios.get("http://localhost:8080/Medicine/viewAllMedicine");
            setMedicines(response.data);
        } catch (error) {
            console.error("Error fetching medicines:", error);
        }
    };

    const handleSearch = async () => {
        if (searchQuery.trim() === "") {
            loadMedicines(); 
        } else {
            try {
                const response = await axios.get(`http://localhost:8080/Medicine/searchMedicine?query=${searchQuery}`);
                setMedicines(response.data);
            } catch (error) {
                console.error("Error searching medicines:", error);
            }
        }
    };

    const addToBasket = async (medicineId) => {
        try {
            const response = await axios.get(`http://localhost:8080/Medicine/${medicineId}`);
            const selectedMedicine = response.data;
            setBasket((prevBasket) => [...prevBasket, selectedMedicine]);
            setTotalBasketAmount((prevTotal) => prevTotal + selectedMedicine.price);
            console.log("Added to basket:", selectedMedicine);
        } catch (error) {
            console.error("Error adding to basket:", error);
        }
    };

    
    const loadAccountAmount = async () => {
        try {
            const usersEmails = user.userEmail;
            const accountResponse = await axios.get(`http://localhost:8080/account/amount?email=${usersEmails}`);
            const fetchedAccountAmount = accountResponse.data;
            setAccountAmount(fetchedAccountAmount); 
        } catch (error) {
            console.error("Error fetching Account Amount:", error);
        }
    };

    useEffect(() => {
        if (user) {
            loadAccountAmount();
        }
    }, [user]);

    const removeItemFromBasket = (medicineId) => {
        const updatedBasket = basket.filter(item => item.medicineid !== medicineId);
        setBasket(updatedBasket);
        const removedItem = basket.find(item => item.medicineid === medicineId);
        setTotalBasketAmount(prevTotal => prevTotal - removedItem.price);
      };

 

    const handlesCheckout = async () => {
        try {
            if (!user) {
                console.log("User not logged in");
                return;
            }
    
            const usersEmail = user.userEmail;
            console.log("User Email:", usersEmail);
    
            // Calculate the total cost of items in the basket
            const totalCost = basket.reduce((total, item) => total + item.price, 0);
    
            // Fetch the current inventory of each medicine
            const fetchMedicinesPromises = basket.map(async (item) => {
                const medicineResponse = await axios.get(`http://localhost:8080/Medicine/${item.medicineid}`);
                const medicine = medicineResponse.data;
                return medicine;
            });
    
            const medicines = await Promise.all(fetchMedicinesPromises);
    
            // Check if account has sufficient balance and medicines have enough inventory
            const canCheckout = accountAmount >= totalCost && medicines.every((medicine) => medicine.inventory > 0);
    
            if (canCheckout) {
                const checkoutRequest = {
                    userEmail: usersEmail,
                    medicines: basket.map(item => ({ 
                        medicineid: item.medicineid, 
                        quantity: 1 ,
                        name: item.name, 
                    price: item.price 
                    })), 
                    totalCost: totalCost
                };
            if (canCheckout){
                const updateMedicinePromises = medicines.map(async (medicine) => {
                    const updatedInventory = medicine.inventory - 1;
                    await axios.put(`http://localhost:8080/Medicine/updateInventory/${medicine.medicineid}?newInventory=${updatedInventory}`);
                });
            };
                const updatedAccountAmount = accountAmount - totalCost;
    
                // Send the checkout request to create an order
                const createOrderResponse = await axios.post("http://localhost:8080/orders/checkout", checkoutRequest);
    
                console.log("Order created successfully. Order ID:", createOrderResponse.data);
                console.log(basket);
                navigate("./order-summary",  { state: { orderItems: basket } });
    
                // Clear the basket after successful checkout
                setBasket([]);
                loadMedicines();
                setTotalBasketAmount(0);
                setAccountAmount(updatedAccountAmount);
                
            } else {
                console.log("Checkout Failed: Insufficient Balance or Inventory");
            }
            //navigate("order-summary", { state: { orderItems: basket } });
        } catch (error) {
            console.error("Error during checkout:", error);
        }
    };
    


    useEffect(() => {
        console.log("Basket Items:", basket);
    }, [basket]);

    const medicineRecord = medicines.map((medicine) => (
        <tr key={medicine.medicineid}>
        {medicine.enable ? ( 
        <>
        <td>{medicine.medicineid}</td>
        <td>{medicine.name}</td>
        <td>{medicine.description}</td>
        <td>£{medicine.price}</td>
        <td>{medicine.inventory}</td>
        <td>
        <img src={medicine.imageurl} alt={medicine.name} width="100px" height="100px" />
        </td>
        <td>{medicine.offer}%</td>
        <td>
        <button onClick={() => addToBasket(medicine.medicineid)}>Add to Basket</button>
        </td>
        
        </>
        ) : null}
        </tr>
        ));

        return (
            <div className="browse-medical-container">
              <h2>View all Medicine Products</h2>
              <div className="search-bar">
               <input
                   type="text"
                   placeholder="Search by name"
                   value={searchQuery}
                   onChange={(e) => setSearchQuery(e.target.value)}
                 />
                     <button className="search-button" onClick={handleSearch}>Search</button>
                <button className="show-all-button" onClick={loadMedicines}>Show All</button>
              </div>
              <table className="medicine-table">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Image</th>
                    <th>Offer % discount (Already Applied in Price)</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>{medicineRecord}</tbody>
              </table>
              <div className="basket-checkout">
                <Basket basketItems={basket} onRemoveItem={removeItemFromBasket} />
                <div className="basket-summary">
                  <p>Total Basket Amount: £{totalBasketAmount.toFixed(2)}</p>
                  <br></br>
                  <p>Available to spend from your account: £{accountAmount.toFixed(2)}</p>
                  <button className="checkout-button" onClick={handlesCheckout}>
                    Checkout
                  </button>
               
                </div>
              </div>
            </div>
          );
          

       
        }
        
        export default BrowseMedical;