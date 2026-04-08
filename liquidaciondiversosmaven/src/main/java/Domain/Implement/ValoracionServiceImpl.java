package Domain.Implement;

import Domain.Service.ValoracionService;
import Model.BienAfectado;
import Model.PaymentType;

public class ValoracionServiceImpl implements ValoracionService {

    @Override
    public double calcularImporteBase(BienAfectado bien, PaymentType paymentType) {

        switch (paymentType) {
            case PRIMER_RIESGO:
                return bien.getImporteDanio();

            case REPOSICION_NUEVO:
                return bien.getValueNuevo();

            case VALOR_REAL:
                return calcularValorReal(bien);

            default:
                return 0;
        }
    }

    private double calcularValorReal(BienAfectado bien) {
        double depreciacionAnual = 1.0 / 7.0;
        double porcentajeDepreciacion = bien.getAntiguedadAnios() * depreciacionAnual;
        double porcentajeRestante = 1 - porcentajeDepreciacion;

        if (porcentajeRestante < 0.10) {
            porcentajeRestante = 0.10;
        }

        return bien.getValueOriginal() * porcentajeRestante;
    }
}
