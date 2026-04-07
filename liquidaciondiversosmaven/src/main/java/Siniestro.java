import lombok.Data;

import java.util.List;

@Data
public class Siniestro {

    public int id;
    public Poliza poliza;
    public String fecha_ocurrencia;
    public String nombreContacto;
    public String direccion;
    public String causa;
    public double valorPreexistenciaContenido;
    public double valorPreexistenciaContinente;
    public List<BienAfectado> bienAfectados;


}
