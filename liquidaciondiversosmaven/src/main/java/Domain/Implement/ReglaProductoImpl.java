package Domain.Implement;

import Domain.Service.ReglaProductoService;
import Model.Poliza;
import Model.ProductWarranty;
import Model.Risk;
import Model.Warranty;

public class ReglaProductoImpl implements ReglaProductoService {
    @Override
    public ProductWarranty obtenerReglaProducto(Poliza poliza, Risk causaSiniestro, Warranty warranty) {

        for (ProductWarranty regla : poliza.getProducto().getProductWarranties()) {
            //Comprobar que la regla coincide con la causa del siniestro y la garantia
            if (regla.getRisk().getCode().equalsIgnoreCase(causaSiniestro.getCode())
                    && regla.getWarranty().getCode().equalsIgnoreCase(warranty.getCode())) {
                return regla;

            }
        }
        return null;
    }
}
