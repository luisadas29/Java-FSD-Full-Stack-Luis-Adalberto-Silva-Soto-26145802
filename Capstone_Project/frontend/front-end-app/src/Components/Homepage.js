import React from "react";
import image from "../Images/Medicare1.jpg"
import image2 from "../Images/Medicare2.jpg"

const HomePage = () => {
   return(
    <div>
        <h2>Welcome to Medicare!</h2>
        <div className="images">
        <img src={image} alt="Image 1" className="responsiveImage"/>
        <img src={image2} alt="Image 2" className="responsiveImage" />
        </div>
        <p></p>
        <p>
        </p>
    </div>

   )
}

export default HomePage;