import React,{useEffect} from "react"
import axios from "axios"
import "../styles/Proveedores.css";
import 'bootstrap/dist/css/bootstrap.min.css';

function Proveedores(){
    const [datos, setDatos] = React.useState([]);
    useEffect(() => {
        cargarProveedores()
    }, [])

    const cargarProveedores = async () =>{
        try {
            const respuesta = await axios.get('http://localhost:8080/proveedor/listado');
            setDatos(respuesta.data);
          } catch (error) {
            console.error(error);
          }
    }

    return (
        <div className="hero">
            <div className="container2">
                <div className="row">
                    <h1 className="title-effect">Listado de Proveedores</h1>
                </div>
                <div style={{ maxWidth: '80%', maxHeight: '500px', overflow: 'auto'}}>
                    <table className="table table-dark table-striped">
                        <thead>
                        <tr className="text-center">
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Categoria</th>
                            <th>Retencion</th>
                        </tr>
                        </thead>
                        <tbody className="text-center">
                            {
                                datos.map(fila =>(
                                    <tr>
                                        <td> {fila.codigo} </td> 
                                        <td> {fila.nombre} </td>   
                                        <td> {fila.categoria}</td>
                                        <td> {fila.retencion}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
    
}

export default Proveedores
