/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.products.publicador_suscriptor.access;
import com.unicauca.products.publicador_suscriptor.Service.Product;


public class validacionMedida extends validacion{
    
    @Override
    public boolean validacionMedidaLata(Product products){
    boolean flag = true;        
        double weight = products.getWeight();
    
        if(weight<267 || weight>355){
            System.out.println("El producto es rechazado. Peso fuera del rango.");
            flag = false;
        }        
        return flag;
    }
}
