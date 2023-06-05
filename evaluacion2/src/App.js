import './App.css';
import { Routes, Route } from 'react-router-dom';
import Layout  from "./pages/Layout";
import Home  from "./pages/Home";
import Registro  from "./pages/Registro";
import Proveedores  from "./pages/Proveedores";
import Acopio  from "./pages/Acopio";
import Porcentaje  from "./pages/Porcentaje";
import Calculos  from "./pages/Calculos";
import Default  from "./pages/Default";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Layout />}>
           <Route path="/" element={<Home />} />
           <Route path="registro" element={<Registro />} />
           <Route path="proveedores" element={<Proveedores />} />
           <Route path="acopio" element={<Acopio />} />
           <Route path="porcentaje" element={<Porcentaje />} />
           <Route path="calculos" element={<Calculos />} />
           <Route path="*" element={<Default />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
