package com.unicauca.products.publicador_suscriptor.Service;


public class Product {

    private int productId;
    private String name;

    /**
     * Peso del producto, en gramos.
     *
     */
    private double weight;
    /**
     * Ancho del producto, en centÃ­metros.
     *
     */
    private double width;
    /**
     * Alto del producto, en centÃ­metros.
     *
     */
    private double height;
    /**
     * Profundidad del producto, en centÃ­metros.
     *
     */
    private double depth;

    public Product(int productId, String name, double weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;

    }

    public Product(int productId, String name, double weight, double width, double height, double depth) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}

