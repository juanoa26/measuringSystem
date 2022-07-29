/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.products.publicador_suscriptor.Service;
import com.unicauca.product.repository.ProductRepositoryImpl;
import java.util.ArrayList;
import java.util.List;


public class ProductService {
      static List<Product> products = new ArrayList<>();
      ArrayList<Product> arrayLista = new ArrayList<Product>();
      static boolean bandera=false;
      static Product newproduct;
      ProductRepositoryImpl objRepositoryProduct = new ProductRepositoryImpl();
      
     public List<Product> getAll() {
       
        if(bandera == false){
        
        Product productOne = new Product(1, "En lata", 269);
        Product productTwo = new Product(2, "Envase de vidrio", 355);
   
        products.add(productOne);
        products.add(productTwo);
       
        bandera = true;
        }
        
        return products;
    }
public String buscar(){
    return arrayLista.get(1).getName();
}
public boolean AgregarProduct(int productId, String name, double weight){
     boolean agregado=false;
    int tama=products.size();
    newproduct = new Product(productId,name,weight);
    products.add(newproduct);
    if(tama!=products.size()){
        agregado=true;
        System.out.println("se agrego el producto");
                }
    
    else{    
        System.out.println("no se agrego");
    }
    
return agregado;
}

public ProductService() {
    }    
          
}
