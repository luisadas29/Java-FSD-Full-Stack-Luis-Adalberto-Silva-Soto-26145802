import axios from "axios";
import React, { useState, useEffect } from "react";
import '../ViewMedicine.css'; 

function ViewMedicine() {
    const [medicines, setMedicines] = useState([]);
    const [editMedicine, setEditMedicine] = useState(null);
    const [editedValues, setEditedValues] = useState({});
    const [searchQuery, setSearchQuery] = useState("");



    const loadMedicines = async () => {
        try {
            const response = await axios.get("http://localhost:8080/Medicine/viewAllMedicine");
            setMedicines(response.data);
        } catch (error) {
            console.error("Error fetching medicines:", error);
        }
    };

    const handleDelete = async (medicineid) => {
        try {
            await axios.delete(`http://localhost:8080/Medicine/${medicineid}`);
            loadMedicines(); // Refresh product list after deletion
        } catch (error) {
            console.error("Error deleting product:", error);
        }
    };

    const handleEdit = (medicine) => {
        setEditedValues({ ...medicine });
        setEditMedicine(medicine);
    };

    const handleUpdate = async (updatedMedicine) => {
        try {
            const updatedPrice = updatedMedicine.originalprice * (1 - updatedMedicine.offer / 100);
            updatedMedicine.price = updatedPrice;
            await axios.put(`http://localhost:8080/Medicine/${updatedMedicine.medicineid}`, updatedMedicine);
            loadMedicines(); // Refresh medicine list after update
            setEditMedicine(null); // Clear edit mode
        } catch (error) {
            console.error("Error updating medicine:", error);
        }
    };


    const handleSearch = async () => {
        if (searchQuery.trim() === "") {
            loadMedicines(); // Reset to all medicines
        } else {
            try {
                const response = await axios.get(`http://localhost:8080/Medicine/searchMedicine?query=${searchQuery}`);
                setMedicines(response.data);
            } catch (error) {
                console.error("Error searching medicines:", error);
            }
        }
    };

    const handleEnable = async (medicineid) => {
        try {
            await axios.put(`http://localhost:8080/Medicine/enable/${medicineid}`);
            loadMedicines(); // Refresh medicine list after enabling
        } catch (error) {
            console.error("Error enabling medicine:", error);
        }
    };
    
    const handleDisable = async (medicineid) => {
        try {
            await axios.put(`http://localhost:8080/Medicine/disable/${medicineid}`);
            loadMedicines(); // Refresh medicine list after disabling
        } catch (error) {
            console.error("Error disabling medicine:", error);
        }
    };


  const medicineRecord = medicines.map((medicine) => (
    <tr key={medicine.medicineid}>
      <td>{medicine.medicineid}</td>
      <td>{editMedicine === medicine ? (
        <input
          type="text"
          value={editedValues.name}
          onChange={(e) => setEditedValues({ ...editedValues, name: e.target.value })}
        />
      ) : (
        medicine.name
        )}</td>
        <td>{editMedicine === medicine ? (
      <input
        type="text"
        value={editedValues.description}
        onChange={(e) => setEditedValues({ ...editedValues, description: e.target.value })}
      />
    ) : (
      medicine.description
    )}</td>
    <td>{editMedicine === medicine ? (
       <input
       type="number"
       value={editedValues.price}
       onChange={(e) => setEditedValues({ ...editedValues, price: e.target.value})}
       />
    ) : (
        medicine.price
    )}</td>
        <td>{editMedicine === medicine ? (
       <input
       type="number"
       value={editedValues.inventory}
       onChange={(e) => setEditedValues({ ...editedValues, inventory: e.target.value})}
       />
    ) : (
        medicine.inventory
    )}</td>
       <td>{editMedicine === medicine ? (
       <input
       type="number"
       value={editedValues.offer}
       onChange={(e) => setEditedValues({ ...editedValues, offer: e.target.value})}
       />
    ) : (
        medicine.offer
    )}</td>
      <td>
        <img src={medicine.imageurl} alt={medicine.name} width="100px" height="100px" />
      </td>
      <td>
      {editMedicine === medicine ? (
        <button onClick={() => handleUpdate(editedValues)}>Update</button>
      ) : (
        <button onClick={() => handleEdit(medicine)}>Edit</button>
      )}
      <button onClick={() => handleDelete(medicine.medicineid)}>Delete</button>
    </td>
      {/* <td>{medicine.offer}%</td> */}
      {/* <td>
        <button onClick={() => handleDelete(medicine.medicineid)}>Delete</button>
        <button onClick={() => handleEdit(medicine)}>Edit</button>
      </td> */}
      <td>
        {medicine.enable ? (
          <button onClick={() => handleDisable(medicine.medicineid)}>Disable</button>
        ) : (
          <button onClick={() => handleEnable(medicine.medicineid)}>Enable</button>
        )}
      </td>
    </tr>
  ));

  return (
    <div>
      <h2>Search Medicine Products</h2>
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
      <table className="medicine-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            {/* <th>Image</th> */}
            <th>Offer % discount</th>
            <th>Image</th>
            <th>Edit / Delete Record</th>
            <th>Enable / Disable</th>
          </tr>
        </thead>
        <tbody>{medicineRecord}</tbody>
      </table>
    </div>
  );
}

export default ViewMedicine;




  