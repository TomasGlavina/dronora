import { useState } from 'react';
import './App.css';
import pizzaLogo from './assets/pizzalogo.jpg';

function App() {


  const [weight, setWeight] = useState('');
  const [destinationLatitude, setDestinationLatitude] = useState('');
  const [destinationLongitude, setDestinationLongitude] = useState('');
  const [startingPointLatitude, setStartingPointLatitude] = useState('');
  const [startingPointLongitude, setStartingPointLongitude] = useState('');


  const handleWeightChange = (event) => {
    setWeight(event.target.value);
  };

  const handleDestinationLatitudeChange = (event) => {
    setDestinationLatitude(event.target.value);
  };

  const handleDestinationLongitudeChange = (event) => {
    setDestinationLongitude(event.target.value);
  };

  const handleStartingPointLatitudeChange = (event) => {
    setStartingPointLatitude(event.target.value);
  };

  const handleStartingPointLongitudeChange = (event) => {
    setStartingPointLongitude(event.target.value);
  };

  const handleSubmit = () => {
    const jsonData = JSON.stringify({
      weight: parseInt(weight),
      destination: {
        latitude: parseFloat(destinationLatitude),
        longitude: parseFloat(destinationLongitude),
      },
      startingPoint: {
        latitude: parseFloat(startingPointLatitude),
        longitude: parseFloat(startingPointLongitude),
      },
    });

    fetch('http://localhost:8082/dronepizza/pizzaorders', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: jsonData,
    })
      .catch(error => {
        console.error('Error:', error);
      });
  };


  return (
    <div className="App">
      <header className="App-header">
        <img src={pizzaLogo} className='pizzaLogo' alt="pizzaLogo" />

        Weight<input className='input' type="text" value={weight} onChange={handleWeightChange} placeholder="Enter weight" />
        Destination Latitude<input className='input' type="text" value={destinationLatitude} onChange={handleDestinationLatitudeChange} placeholder="Enter destination latitude" />
        Destination Longitude<input className='input' type="text" value={destinationLongitude} onChange={handleDestinationLongitudeChange} placeholder="Enter destination longitude" />
        Start Latitude<input className='input' type="text" value={startingPointLatitude} onChange={handleStartingPointLatitudeChange} placeholder="Enter starting point latitude" />
        Start Longitude<input className='input' type="text" value={startingPointLongitude} onChange={handleStartingPointLongitudeChange} placeholder="Enter starting point longitude" />
        <button id="submit" onClick={handleSubmit}>Submit</button>
      </header>
    </div>
  );
}

export default App;
