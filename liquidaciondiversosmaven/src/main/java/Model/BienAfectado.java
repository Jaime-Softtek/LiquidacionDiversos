package Model;

import lombok.Data;

@Data
public class BienAfectado {

    private Warranty warranty;
    private double valueNuevo;
    private double valueOriginal;
    private int antiguedadAnios;
    private double importeDanio;

}
