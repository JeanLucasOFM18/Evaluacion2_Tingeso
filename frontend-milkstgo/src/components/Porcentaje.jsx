import React from "react"
import axios from "axios"
import "../styles/Porcentaje.css";

function Porcentaje() {

    const [archivo, setArchivo] = React.useState(null);

    const handleArchivoChange = (event) => {
        const archivoSeleccionado = event.target.files[0];
        setArchivo(archivoSeleccionado);
    };

    const agregarPorcentaje = async () => {
      try {
        const formData = new FormData();
        formData.append('file', archivo); // Agrega el archivo al FormData
  
        await axios.post('http://localhost:8080/porcentaje/subir', formData);
        window.location.reload();
      } catch (error) {
        console.error(error);
      }
    };
  
    return (
      <div class="hero">
        <div class="container2">
          <h1 class="title-effect">Subir Porcentaje</h1>
          <div class="mb-3">
            <input type="file" accept=".csv" onChange={handleArchivoChange} />
          </div>
          <div style={{ textAlign: 'center' }}>
            <button type="submit" class="btn btn-primary" onClick={agregarPorcentaje}>
              Subir archivo
            </button>
          </div>
        </div>
      </div>
    );
  }
  
  export default Porcentaje;