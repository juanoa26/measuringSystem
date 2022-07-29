/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.microkernel.plugin.aguila;

/**
 *
 * @author ANDRE
 */

import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IMeasurePlugin;

public class AguilaMeasurementPlugin implements IMeasurePlugin{

    public boolean calculateMeasure(Measure measure) {
        boolean flag = true;
        Product product = measure.getProduct();
        double weight = product.getWeight();
  
        
        
        if(weight<355 || weight>356){
            System.out.println("El peso no es ideal.");
            flag = false;
        }
        return flag;
    }
    
}