import React, { useState } from 'react';


function Delivery({ startingLatitude, startingLongitude, destLatitude, destLongitude, weight, drone, status }) {

    const[deliveryStatus, setDeliveryStatus] = useState(status);

    function handleDeliver() {
        const fetchDelivery = async () => {
            try{
                console.log(drone)
                const response = await fetch('http://localhost:8082/dronora/flight/deliver/' + drone );
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                setDeliveryStatus("DELIVERED");
            } catch (error) {
                console.error('Fetch error:', error);
            }
        };
        fetchDelivery();
    };

    return (
        <div className=''>
            <div style={{ display: 'flex', flexDirection: 'column', width: '100%', marginTop: '20px', marginLeft: '10px'}}>
                <p className=''>Starting Latitude: {startingLatitude}</p>
                <p className=''>Starting Longitude: {startingLongitude}</p>
                <p className=''>Destination Latitude: {destLatitude}</p>
                <p className=''>Destination Longitude: {destLongitude}</p>
                <p className=''>Weight: {weight}</p>
                <p className=''>Drone: {drone}</p>
                <p className=''>Status: {deliveryStatus}</p>

                <button id="submit" onClick={handleDeliver}>Deliver</button>

            </div>

        </div>
    );
}

export default Delivery;