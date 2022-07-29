
package co.unicauca.microkernel.plugins.corona;

import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IMeasurePlugin;


public class CoronaMeasurementPlugin implements IMeasurePlugin {
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
