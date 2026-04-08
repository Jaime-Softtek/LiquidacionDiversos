package Domain.Implement;

import Domain.Service.PreexistenciaService;
import Model.ProductWarranty;
import Model.Siniestro;
import Model.WarrantyType;

public class PreexistenciaServiceImpl implements PreexistenciaService {

    @Override
    public double aplicarReglaPreexistencia(double importe, Siniestro siniestro, ProductWarranty regla) {

        double preexistencia = obtenerPreexistenciaSegunGarantia(siniestro, regla);
        double capitalAsegurado = regla.getCapitalInsured();

        if (capitalAsegurado <= 0) {
            return 0;
        }
        //Si la preexistencia no supera el capital
        if (preexistencia <= capitalAsegurado) {
            return importe;
        }
        //Si la supera se reduce proporcionalmete
        double factorReduccion = capitalAsegurado / preexistencia;
        return importe * factorReduccion;
    }

    private double obtenerPreexistenciaSegunGarantia(Siniestro siniestro, ProductWarranty regla) {
        WarrantyType tipoGarantia = regla.getWarranty().getWarrantyType();

        if (tipoGarantia == WarrantyType.CONTENT) {
            return siniestro.getValorPreexistenciaContenido();
        }

        return siniestro.getValorPreexistenciaContinente();
    }
}
