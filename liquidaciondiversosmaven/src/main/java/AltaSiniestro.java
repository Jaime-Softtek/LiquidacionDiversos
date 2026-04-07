import java.util.ArrayList;
import java.util.List;


public class AltaSiniestro {

    public Siniestro altaSiniestro(Poliza poliza) {

        //Datos básicos
        String fechaSiniestro = Utilidades.leerTexto("Introduce la fecha del siniestro (dd/MM/yyyy)");
        String nombreContacto = Utilidades.leerTexto("Introduce el nombre de la persona de contacto");
        String direccionSiniestro = Utilidades.leerTexto("Introduce la dirección del siniestro");

        //Causa (solo una)
        String causaSiniestro = Utilidades.leerTexto("Introduce la causa del siniestro");

        //Valores de preexistencia
        double valorPreexistenciaContenido = Utilidades.leerDouble("Introduce valor preexistencia contenido");
        double valorPreexistenciaContinente = Utilidades.leerDouble("Introduce valor preexistencia continente");

        //Lista de bienes afectados
        List<BienAfectado> bienesAfectados = new ArrayList<>();

        //Bucle para introducir los bienes afectados
        String opcion;
        do {
            System.out.println("Introduce los datos del bien afectado:");

            String garantia = Utilidades.leerTexto("Introduce la garantía (contenido/continente)");
            double valorNuevo = Utilidades.leerDouble("Introduce el valor a nuevo");
            double valorInicial = Utilidades.leerDouble("Introduce el valor inicial");
            int antiguedad = Utilidades.leerEntero("Introduce la antigüedad en años");

            BienAfectado bien = new BienAfectado(garantia, valorNuevo, valorInicial, antiguedad);
            bienesAfectados.add(bien);
            opcion = Utilidades.leerTexto("¿Quieres añadir otro bien? (s/n)");

        } while (opcion.equalsIgnoreCase("s"));

        //Crear siniestro
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

    //El cálculo de liquidación de un siniestro se realizará Garantía a Garantía, aplicando para cada garantía las reglas que apliquen en función de la configuración del producto/póliza para esa causa/garantía concreta y los importes introducidos.
    //El proceso de cálculo sería el siguiente:
    //1.	Se comprueba si la garantía está excluida
    //a.	En caso de exclusión la liquidación es 0.
    //2.	Se calcula el importe a liquidar en función del tipo de valoración.
    //3.	Se calcula el importe a liquidar en función del tipo de aseguramiento (tomando como entrada el importe calculado en punto 2)
    //4.	Se aplica la regla de infraseguro
    public void calculoLiquidaciones(Siniestro siniestro, List<Warranty> garantiasEmpresa){
        List<ProductWarranty> garantiasSiniestro = siniestro.getPoliza().getProducto().getProductWarranties();

        for(ProductWarranty garantia : garantiasSiniestro){
            if(garantia.isExcluded()){
                System.out.println("La garantía " + garantia.getWarranty().getName() + " está excluida. Liquidación: 0");
            } else {
                //Aquí se implementaría el cálculo del importe a liquidar en función del tipo de valoración y aseguramiento, así como la regla de infraseguro.
                //Este cálculo dependerá de la configuración específica de cada garantía y causa, por lo que se necesitaría más información para implementarlo correctamente.
                System.out.println("Calculando liquidación para la garantía " + garantia.getWarranty().getName());

            }
        }




    }
}
