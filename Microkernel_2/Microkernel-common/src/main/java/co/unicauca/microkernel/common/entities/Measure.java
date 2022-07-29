package co.unicauca.microkernel.common.entities;

public class Measure {

    private Product product;
    
    /**
     * Estado del producto luego de medirlo
     */
    private String estado;
    
    /**
     * Tiempo de medición en ms.
     * 
     */
    private int tiempo;
    
    /**
     * Código del item al que se medirá.
     * 
     */
    private String itemCode;

    public Measure() {
    
    }
    
    public Measure(Product product, int tiempo, String itemCode) {
        this.product = product;
        this.tiempo = tiempo;
        this.itemCode = itemCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }   
}
