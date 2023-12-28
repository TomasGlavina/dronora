import Delivery from "../components/Delivery";
import { useState, useEffect } from 'react';

function DeliveryPage() {

    const [data, setData] = useState(null);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8082/dronora/flights');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const jsonData = await response.json();
                setData(jsonData); // Set the data in state
            } catch (error) {
                console.error('Fetch error:', error);
            }
        };
        fetchData();
    }, [])

    return (
        <>
            <div>
                <div>
                    <h3 style={{ paddingLeft: '5vw' }}>Deliveries</h3>
                </div>
                <div>
                    {data && data.map((delivery, i) => (
                        <Delivery
                            key={i} // Don't forget to add a unique key when mapping over elements
                            startingLatitude={delivery.startingPoint.latitude}
                            startingLongitude={delivery.startingPoint.longitude}
                            destLatitude={delivery.destination.latitude}
                            destLongitude={delivery.destination.longitude}
                            weight={delivery.weight}
                            drone={delivery.droneId}
                            status={delivery.status}
                        />
                    ))}
                </div>
            </div>
        </>
    );
}

export default DeliveryPage;