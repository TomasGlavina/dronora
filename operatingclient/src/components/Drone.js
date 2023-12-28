
import './Drone.css';
import droneImage from './../assets/drone.png';

function Drone({ name, status, capacity }) {

    return (
        <div className='drone_box'>
            <img src={droneImage} className='drone_image' alt="droneImage" />
            <div style={{ display: 'flex', flexDirection: 'column', width: '100%', marginTop: '20px', marginLeft: '10px'}}>
                <p className='drone_info'>Name: {name}</p>
                <p className='drone_info'>Status: {status}</p>
                <p className='drone_info'>Capacity: {capacity}</p>
            </div>

        </div>
    );
}

export default Drone;