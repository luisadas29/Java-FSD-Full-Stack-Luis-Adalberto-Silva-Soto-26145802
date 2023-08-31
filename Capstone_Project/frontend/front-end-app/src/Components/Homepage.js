
import React from "react";
import image from "../Images/Medicare1.jpg";
import image2 from "../Images/Medicare2.jpg";
import "../HomePage.css"; 

const HomePage = () => {
  return (
    <div className="home-page">
      <h2 className="home-title">Welcome to Medicare - Your Medical Supplies Shop</h2>
      <div className="image-container">
        <img src={image} alt="Medical Supplies 1" className="responsive-image" />
        <img src={image2} alt="Medical Supplies 2" className="responsive-image" />
      </div>
      <p className="home-text">
        At Medicare, we provide a wide range of high-quality medical supplies to meet your needs. Whether you're looking for personal protective equipment, medical devices, or healthcare essentials, we have you covered. Our mission is to ensure you have access to top-notch products that contribute to your well-being.
      </p>
      <p className="home-text">
        Browse through our collection and experience the convenience of shopping for medical supplies online. We're committed to providing reliable products and exceptional service to our customers. Start exploring our shop today!
      </p>
    </div>
  );
};

export default HomePage;
