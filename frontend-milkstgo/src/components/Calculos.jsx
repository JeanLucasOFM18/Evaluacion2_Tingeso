import React,{useEffect} from "react"
import axios from "axios"
import "../styles/Calculos.css";
import 'bootstrap/dist/css/bootstrap.min.css';


function Calculos(){
    const [datos, setDatos] = React.useState([]);
    useEffect(() => {
        cargarCalculos()
    }, [])

    const cargarCalculos = async () =>{
        const respuesta = await axios.get('http://localhost:8080/pago/calculos');
        setDatos(respuesta.data)
    }

    return(
        <div class="hero">
            <div class="container2">
                <div class="row">
                    <h1 class="title-effect">Listado de Pagos</h1>
                </div>
                <div style={{ maxWidth: '80%', maxHeight: '800px', overflowY: 'auto' }}>
                    <table class="table table-dark table-striped">
                        <thead>
                            <tr class="text-center">
                            <th>Quincena</th>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Total KLS</th>
                            <th>Dias</th>
                            <th>Promedio</th>
                            <th>Var Leche</th>
                            <th>Grasa</th>
                            <th>Var Grasa</th>
                            <th>Solidos</th>
                            <th>Var Solidos</th>
                            <th>Pago Leche</th>
                            <th>Pago Grasa</th>
                            <th>Pago Solidos</th>
                            <th>Bonificacion</th>
                            <th>Dsct Leche</th>
                            <th>Dsct Grasa</th>
                            <th>Dsct Solidos</th>
                            <th>Pago Total</th>
                            <th>Retencion</th>
                            <th>Final</th>
                            </tr>
                        </thead>
                        <tbody className="text-center">
                            {
                                datos.map(fila =>(
                                    <tr>
                                        <td> {fila.quincena} </td> 
                                        <td> {fila.codigo_proveedor} </td>   
                                        <td> {fila.nombre_proveedor}</td>
                                        <td> {fila.totalKl}</td>
                                        <td> {fila.dias}</td>
                                        <td> {fila.promedio}</td>
                                        <td> {fila.variacion_leche}</td>
                                        <td> {fila.grasa}</td>
                                        <td> {fila.variacion_grasa}</td>
                                        <td> {fila.solidos}</td>
                                        <td> {fila.variacion_solidos}</td>
                                        <td> {fila.pago_leche}</td>
                                        <td> {fila.pago_grasa}</td>
                                        <td> {fila.pago_solido}</td>
                                        <td> {fila.bonificacion}</td>
                                        <td> {fila.descuento_varLeche}</td>
                                        <td> {fila.descuento_varGrasa}</td>
                                        <td> {fila.descuento_varSolidos}</td>
                                        <td> {fila.pago_total}</td>
                                        <td> {fila.monto_retencion}</td>
                                        <td> {fila.monto_final}</td>
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

export default Calculos