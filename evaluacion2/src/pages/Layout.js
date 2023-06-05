import { Outlet, Link } from "react-router-dom";
import "../styles/Navbar.css";

const Layout = () =>{
 return <div className="hero">
    <nav>
      <div className="logo">
        <Link to="/">MilkStgo</Link>
      </div>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/registro">Registro</Link>
          </li>
          <li>
            <Link to="/proveedores">Proveedores</Link>
          </li>
          <li>
            <Link to="/acopio">Acopio</Link>
          </li>
          <li>
            <Link to="/porcentaje">Porcentaje</Link>
          </li>
          <li>
            <Link to="/calculos">Calculos</Link>
          </li>
        </ul>
    </nav>
    <Outlet />
 </div>;
}

export default Layout;