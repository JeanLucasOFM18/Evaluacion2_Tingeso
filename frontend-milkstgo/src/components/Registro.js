import "../styles/Registro.css";

const Registro = () =>{
    return <div class="hero">
                <div class="container">
                    <div class="image">
                        <div class="form-box">
                            <div class="form">
                                <form action="crearProveedor" method="post">
                                    <h2>Registro</h2>
                                    <div class="input-box">
                                        <input type="text" id="codigo" name="codigo" required maxlength="5"/>
                                        <label for="codigo">Codigo</label>
                                    </div>
                                    <div class="input-box">
                                        <input type="text" id="nombre" name="nombre" required/>
                                        <label for="nombre">Nombre</label>
                                    </div>
                                    <label for="categoria">Categoria</label>
                                    <div class="select">
                                        <select id="categoria" name="categoria" required>
                                            <option selected disabled> Seleccione una opción </option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                        </select>
                                    </div>
                                    <label for="retencion">Retencion</label>
                                    <div class="select">
                                        <select id="retencion" name="retencion" required>
                                            <option selected disabled> Seleccione una opción </option>
                                            <option value="Si">Si</option>
                                            <option value="No">No</option>
                                        </select>
                                    </div>
                                    <button>Registrar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>;
        }

export default Registro;