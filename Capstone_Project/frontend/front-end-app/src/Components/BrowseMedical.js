import axios from "axios";
import React, { useState, useEffect } from "react";
import Basket from "./Basket";
import { useUser } from '../UserContext';


function BrowseMedical() {
    const [medicines, setMedicines] = useState([]);
    const [basket, setBasket] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [totalBasketAmount, setTotalBasketAmount] = useState(0);
    const [accountAmount, setAccountAmount] = useState(0); 
    const user = useUser(); 
    

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

      

    const handleCheckout = async (userEmail) => {
        try {
            
            if (!user) {
                console.log("User not logged in");
                return;
            }

            const usersEmail = user.userEmail;
            console.log("User Email:", usersEmail);

            // Fetch user's account amount using userEmail
            const accountResponse = await axios.get(`http://localhost:8080/account/amount?email=${usersEmail}`);
            const accountAmount = accountResponse.data;
            console.log("User's Account Amount:", accountAmount);
    
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
                // Deduct the inventory of medicines and the account amount
                const updateMedicinePromises = medicines.map(async (medicine) => {
                    const updatedInventory = medicine.inventory - 1;
                    await axios.put(`http://localhost:8080/Medicine/updateInventory/${medicine.medicineid}?newInventory=${updatedInventory}`);
                });

                const updatedAccountAmount = accountAmount - totalCost;
            const modifyAccountResponse = await axios.put(`http://localhost:8080/account/modify?email=${usersEmail}&newAmount=${updatedAccountAmount}`);
            const modifiedAccountAmount = modifyAccountResponse.data;
            console.log("Modified Account Amount:", modifiedAccountAmount);
    
                
                await Promise.all(updateMedicinePromises);
    
                // Clear the basket after successful checkout
                setBasket([]);
                loadMedicines();
                setAccountAmount(modifiedAccountAmount);
                
    
                // Implement any additional UI feedback
                console.log("Checkout Successful!");
                setTotalBasketAmount(0);
            } else {
                console.log("Checkout Failed: Insufficient Balance or Inventory");
            }
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
        <div>
            <h2>View all Medicine Products</h2>
            <div>
                <input
                    type="text"
                    placeholder="Search by name"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
                <button onClick={handleSearch}>Search</button>
                <button onClick={loadMedicines}>Show All</button>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th>Image</th>
                        <th>Offer % discount</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>{medicineRecord}</tbody>
            </table>
            {/* Render the Basket component */}
            <Basket basketItems={basket} />
            <p>Total Basket Amount: £{totalBasketAmount.toFixed(2)}</p> |
            <p>Available to spend from your account : £{accountAmount.toFixed(2)}</p>
              |
            <></>
            <button onClick={handleCheckout}>Checkout</button>

        </div>
    );
}

export default BrowseMedical;
