package Domain.Service;

import Model.Siniestro;

public interface LiquidacionService {
    double calcularLiquidacionTotal(Siniestro siniestro);
    void mostrarDesgloseLiquidacion(Siniestro siniestro);
}
