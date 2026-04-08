package Domain.Implement;

import Domain.Service.LiquidacionService;
import Domain.Service.PreexistenciaService;
import Domain.Service.ReglaProductoService;
import Domain.Service.ValoracionService;
import Model.*;

public class LiquidacionServiceImpl implements LiquidacionService {

    private final ReglaProductoService reglaProductoService;
    private final ValoracionService valoracionService;
    private final PreexistenciaService preexistenciaService;

    public LiquidacionServiceImpl() {
        this.reglaProductoService = new ReglaProductoImpl();
        this.valoracionService = new ValoracionServiceImpl();
        this.preexistenciaService = new PreexistenciaServiceImpl();
    }

    @Override
    public double calcularLiquidacionTotal(Siniestro siniestro) {
        if (siniestro == null || siniestro.getBienAfectados() == null || siniestro.getBienAfectados().isEmpty()) {
            return 0;
        }

        double total = 0;

        for (BienAfectado bien : siniestro.getBienAfectados()) {
            total += calcularLiquidacionBien(siniestro, bien);
        }

        return total;
    }

    @Override
    public void mostrarDesgloseLiquidacion(Siniestro siniestro) {
        if (siniestro == null || siniestro.getBienAfectados() == null || siniestro.getBienAfectados().isEmpty()) {
            System.out.println("No hay bienes afectados.");
            return;
        }

        System.out.println("=== DESGLOSE DE LIQUIDACIÓN ===");

        for (BienAfectado bien : siniestro.getBienAfectados()) {
            double importe = calcularLiquidacionBien(siniestro, bien);

            System.out.println("Garantía: " + bien.getWarranty().getCode());
            System.out.println("Importe liquidado: " + importe);
            System.out.println("-----------------------------");
        }

        System.out.println("TOTAL: " + calcularLiquidacionTotal(siniestro));
    }

    private double calcularLiquidacionBien(Siniestro siniestro, BienAfectado bien) {
        ProductWarranty regla = reglaProductoService.obtenerReglaProducto(
                siniestro.getPoliza(),
                siniestro.getCausa(),
                bien.getWarranty()
        );

        if (regla.isExcluded()) {
            return 0;
        }

        double importeBase = valoracionService.calcularImporteBase(bien, regla.getPaymentType());
        double importeTrasCapital = Math.min(importeBase, regla.getCapitalInsured());

        return preexistenciaService.aplicarReglaPreexistencia(importeTrasCapital, siniestro, regla);
    }
    }

