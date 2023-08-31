import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import '../AddMedicine.css';

function AddMedicine() {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const [inventory, setInventory] = useState('');
  const [imageurl, setImageURL] = useState('');
  const [enable, setEnable] = useState('');
  const navigate = useNavigate();

  const addMedicine = async (event) => {
    event.preventDefault();
    const medicine = {
      name: name,
      description: description,
      price: price,
      inventory: inventory,
      imageurl: imageurl,
      enable: enable,
    };
    try {
      const result = await axios.post('http://localhost:8080/Medicine/addMedicine', medicine);
      if (result.data === 'Medicine created') {
        alert('Medicine Created Successfully!!');
      } else {
        alert('Please try again');
      }
    } catch (ex) {
      console.log(ex);
    }
  };

  return (
    <div className="add-medicine-container">
      <h2 className="add-medicine-header">Add Medicine</h2>
      <form className="add-medicine-form" onSubmit={addMedicine}>
        <label>Name</label>
        <input type="text" name="name" onChange={(e) => setName(e.target.value)} />
        <br />
        <label>Description</label>
        <input type="text" name="description" onChange={(e) => setDescription(e.target.value)} />
        <br />
        <label>Price</label>
        <input type="number" name="price" onChange={(e) => setPrice(e.target.value)} />
        <br />
        <label>Quantity</label>
        <input type="number" name="inventory" onChange={(e) => setInventory(e.target.value)} />
        <br />
        <label>Image URL</label>
        <input type="text" name="imageurl" onChange={(e) => setImageURL(e.target.value)} />
        <br />
        <label>Enable</label>
        <input type="checkbox" name="enable" onChange={(e) => setEnable(e.target.checked)} />
        <br />
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
        <br />
      </form>
    </div>
  );
}

export default AddMedicine;
