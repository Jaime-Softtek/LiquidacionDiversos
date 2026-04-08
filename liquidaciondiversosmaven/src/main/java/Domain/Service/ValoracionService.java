package Domain.Service;

import Model.BienAfectado;
import Model.PaymentType;

public interface ValoracionService {

    double calcularImporteBase(BienAfectado bien, PaymentType paymentType);
}
