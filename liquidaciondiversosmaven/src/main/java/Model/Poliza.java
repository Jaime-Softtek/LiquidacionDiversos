package Model;

import lombok.Data;

import java.util.Map;

@Data
public class Poliza {
    public int id;
    public Product producto;
    public Cliente cliente;
    public Map<String, Double> insuredCapitals;

}
