/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.product.repository;

import com.unicauca.products.publicador_suscriptor.Service.Product;
import java.util.ArrayList;


public class ProductRepositoryImpl implements IProductRepository{
    
    private ArrayList<Product> misProducts;
    

    public ProductRepositoryImpl() {
        this.misProducts = new ArrayList();
    }    
    
    @Override
    public void agregarproductRepository(Product objProducto) {
                
        if (misProducts.add(objProducto)) {
            System.out.println("se agrego el producto");
        }
        else
        {
        System.out.println("no se agrego");
        }   
    }    

    @Override
    public int tamanioLista() {
        return this.misProducts.size();
    } 
}
