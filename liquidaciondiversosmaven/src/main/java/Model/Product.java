package Model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String code;
    private String name;
    // Lo que cubre roturas, agua
    List<ProductWarranty> productWarranties;


}
