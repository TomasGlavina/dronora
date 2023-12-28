import { Link } from "react-router-dom";
import "./Sidebar.css";

function Sidebar() {
    return (
        <>
            <div className="Sidebar">
                <div style={{ flex: '1' }}>
                    <p>Fleet Management</p>
                </div>
                <div style={{ flex: '20', display: 'flex', flexDirection: 'column', justifyContent: 'center', paddingBottom: '15vh' }}>
                    <button className="page_selection"><Link to={"/drones"} style={{ textDecoration: 'none', fontSize: 'large', color: 'black' }}>Drones</Link ></button>
                    <button className="page_selection"><Link to={"/deliveries"} style={{ textDecoration: 'none', fontSize: 'large', color: 'black' }}>Deliveries</Link ></button>
                </div>
            </div>
        </>
    );
}

export default Sidebar;
