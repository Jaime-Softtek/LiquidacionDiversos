import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Poliza {
    public int id;
    public Product producto;
    public Cliente cliente;
    public Map<String, Double> insuredCapitals;

    public Poliza(int id, Product producto, Cliente cliente, Map<String, Double> insuredCapitals) {
        this.id = id;
        this.producto = producto;
        this.cliente = cliente;
        this.insuredCapitals = insuredCapitals;
    }
}
