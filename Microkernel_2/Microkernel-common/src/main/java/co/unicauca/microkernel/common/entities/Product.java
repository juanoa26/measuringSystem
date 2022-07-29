package co.unicauca.microkernel.common.entities;

public class Product {

    /**
     * ID del producto.
     *
     */
    private int productId;

    /**
     * Peso del producto, en kilogramos.
     *
     */
    private double weight;
   

    public Product() {

    }

    public Product(int productId, double weight) {
        this.productId = productId;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
}
