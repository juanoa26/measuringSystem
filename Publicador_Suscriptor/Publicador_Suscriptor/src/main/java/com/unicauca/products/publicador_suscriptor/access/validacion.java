/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.products.publicador_suscriptor.access;

import com.unicauca.products.publicador_suscriptor.Service.Product;
import java.util.ArrayList;
import java.util.List;


public abstract class validacion {
    List<Product> products = new ArrayList<>();
    abstract boolean validacionMedidaLata(Product products);
}
