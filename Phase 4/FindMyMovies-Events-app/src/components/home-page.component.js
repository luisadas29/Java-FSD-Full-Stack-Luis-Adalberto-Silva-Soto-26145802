import React from "react";
import image from "../Images/films.jpeg"
import image2 from "../Images/OutdoorActivities.jpeg"

const HomePage = () => {
   return(
    <div>
        <h2>Welcome to FindmyMovies Local Events website</h2>
        <div className="images">
        <img src={image} alt="Image 1" className="responsiveImage"/>
        <img src={image2} alt="Image 2" className="responsiveImage" />
        </div>
        <p></p>
        <p>This website has been setup to help you find Local Events in your area!</p>
        <p>This can range from Films, Days out in the park or anything you can think off!,
            please choose an option above for checking all the available events , adding an 
            event or searching events! , you can also update any event if you feel something is 
            not correct!
        </p>
    </div>

   )
}

export default HomePage;