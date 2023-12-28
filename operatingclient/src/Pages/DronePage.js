import Drone from "../components/Drone";
import { useState, useEffect } from 'react';

function DronePage() {

    const [data, setData] = useState(null);


    useEffect(() => {
        // Function to fetch data
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8082/dronora/drones');
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
    /*useEffect(() => {
        fetch('http://localhost:8082/dronora/drones')
            .then(response => {
                if (response.ok) {
                    setData(response);
                }
                console.log(response);

            })
            .catch(error => console.error(error));
    }, [])*/

    return (
        <>
            <div>
                <div>
                    <h3 style={{ paddingLeft: '5vw' }}>Drones</h3>
                </div>
                <div>
                    {data && data.map((drone, i) => (
                        <Drone
                            key={i} // Don't forget to add a unique key when mapping over elements
                            name={drone.name}
                            status={drone.status}
                            capacity={drone.capacity}
                        />
                    ))}
                </div>
            </div>
        </>
    );
}

export default DronePage;