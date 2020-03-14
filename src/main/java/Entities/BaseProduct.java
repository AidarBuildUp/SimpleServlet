package Entities;

public class BaseProduct {
    private Long productCode;

    private String name;

    public BaseProduct(Long index, String name) {
        this.productCode = index;
        this.name = name;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
