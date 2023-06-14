import './App.css';
import { Routes, Route } from 'react-router-dom';
import Layout  from "./components/Layout";
import Home  from "./components/Home";
import Registro  from "./components/Registro";
import Proveedores  from "./components/Proveedores";
import Acopio  from "./components/Acopio";
import Porcentaje  from "./components/Porcentaje";
import Calculos  from "./components/Calculos";
import Default  from "./components/Default";

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
