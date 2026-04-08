package Domain.Implement;

import Domain.Service.AltaSiniestroService;
import Model.*;
import Utils.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class AltaSiniestroImpl implements AltaSiniestroService {
    @Override
    public Siniestro altaSiniestro(Poliza poliza) {

        if (poliza == null) {
            throw new IllegalArgumentException("La póliza no puede ser nula");
        }

        // Datos básicos
        String fechaSiniestro = Utilidades.leerTexto("Introduce la fecha del siniestro (dd/MM/yyyy)");
        String nombreContacto = Utilidades.leerTexto("Introduce el nombre de la persona de contacto");
        String direccionSiniestro = Utilidades.leerTexto("Introduce la dirección del siniestro");

        // Causa (solo una)
        String codigoCausa = Utilidades.leerTexto("Introduce el código de la causa del siniestro");

        Risk causaSiniestro = new Risk();
        causaSiniestro.setCode(codigoCausa);
        causaSiniestro.setName(codigoCausa);

        // Valores de preexistencia
        double valorPreexistenciaContenido = Utilidades.leerDouble("Introduce valor preexistencia contenido");
        double valorPreexistenciaContinente = Utilidades.leerDouble("Introduce valor preexistencia continente");

        // Lista de bienes afectados
        List<BienAfectado> bienesAfectados = new ArrayList<>();

        String opcion;
        do {
            System.out.println("Introduce los datos del bien afectado:");

            String codigoGarantia = Utilidades.leerTexto("Introduce el código de la garantía");
            String tipoGarantiaTexto = Utilidades.leerTexto("Introduce el tipo de garantía (CONTENT/BUILDING)");

            double valorNuevo = Utilidades.leerDouble("Introduce el valor a nuevo");
            double valorInicial = Utilidades.leerDouble("Introduce el valor inicial");
            int antiguedad = Utilidades.leerEntero("Introduce la antigüedad en años");
            double importeDanio = Utilidades.leerDouble("Introduce el importe del daño");

            WarrantyType warrantyType = WarrantyType.valueOf(tipoGarantiaTexto.toUpperCase());

            Warranty warranty = new Warranty();
            warranty.setCode(codigoGarantia);
            warranty.setName(codigoGarantia);
            warranty.setWarrantyType(warrantyType);

            BienAfectado bien = new BienAfectado();
            bien.setWarranty(warranty);
            bien.setValueNuevo(valorNuevo);
            bien.setValueOriginal(valorInicial);
            bien.setAntiguedadAnios(antiguedad);
            bien.setImporteDanio(importeDanio);

            bienesAfectados.add(bien);

            opcion = Utilidades.leerTexto("¿Quieres añadir otro bien? (s/n)");

        } while (opcion.equalsIgnoreCase("s"));

        Siniestro siniestro = new Siniestro();
        siniestro.setPoliza(poliza);
        siniestro.setFecha_ocurrencia(fechaSiniestro);
        siniestro.setNombreContacto(nombreContacto);
        siniestro.setDireccion(direccionSiniestro);
        siniestro.setCausa(causaSiniestro);
        siniestro.setValorPreexistenciaContenido(valorPreexistenciaContenido);
        siniestro.setValorPreexistenciaContinente(valorPreexistenciaContinente);
        siniestro.setBienAfectados(bienesAfectados);

        return siniestro;
    }
}
