import React from "react"
import axios from "axios"
import "../styles/Registro.css";

function Registro(){
    const [codigo, setCodigo] = React.useState("");
    const [nombre, setNombre] = React.useState("");
    const [categoria, setCategoria] = React.useState("");
    const [retencion, setRetencion] = React.useState("");
    
    const agregarProveedor = async () =>{
        await axios.post('http://localhost:8080/proveedor/crear', {
            codigo, nombre, categoria, retencion
        })
        window.location.reload();
    }

    return (
        <div class="hero">
            <div class="container3">
                <div class="image">
                    <div class="form-box">
                        <div class="form">
                            <form>
                                <h2>Registro</h2>
                                <div class="input-box">
                                    <input type="text" id="codigo" name="codigo" required maxlength="5" onChange={(e) => setCodigo(e.target.value)}/>
                                    <label for="codigo">Codigo</label>
                                </div>
                                <div class="input-box">
                                    <input type="text" id="nombre" name="nombre" required onChange={(e) => setNombre(e.target.value)}/>
                                    <label for="nombre">Nombre</label>
                                </div>
                                <label for="categoria">Categoria</label>
                                <div class="select">
                                    <select id="categoria" name="categoria" required onChange={(e) => setCategoria(e.target.value)}>
                                        <option selected disabled> Seleccione una opción </option>
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                        <option value="C">C</option>
                                        <option value="D">D</option>
                                    </select>
                                </div>
                                <label for="retencion">Retencion</label>
                                <div class="select">
                                    <select id="retencion" name="retencion" required onChange={(e) => setRetencion(e.target.value)}>
                                        <option selected disabled> Seleccione una opción </option>
                                        <option value="Si">Si</option>
                                        <option value="No">No</option>
                                    </select>
                                </div>
                                <button onClick={() => agregarProveedor()}>Registrar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Registro