package Domain.Service;

import Model.ProductWarranty;
import Model.Siniestro;

public interface PreexistenciaService {
    double aplicarReglaPreexistencia(double importe, Siniestro siniestro, ProductWarranty regla);
}
