package Domain.Service;

import Model.Poliza;
import Model.ProductWarranty;
import Model.Risk;
import Model.Warranty;

public interface ReglaProductoService {
    ProductWarranty obtenerReglaProducto(Poliza poliza, Risk causa, Warranty warranty);
}
