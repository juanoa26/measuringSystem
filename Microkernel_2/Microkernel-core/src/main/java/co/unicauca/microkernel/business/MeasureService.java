
package co.unicauca.microkernel.business;

import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.common.interfaces.IMeasurePlugin;
import co.unicauca.microkernel.plugin.manager.MeasurePluginManager;

/**
 * Obtiene el plugin
 */
public class MeasureService {

    /**
     * Determina si la medicion da para un producto bueno o defectuoso
     * haciendo uso de plugins que implementan la funcionalidad para comparar las
     * medidas.
     * @param measureData el item de medicion que contiene los datos del producto
     * @return boolean Con la funcion calculateMeasure devuelve true o false
     * si las medidas son adecuadas o no
     * @throws java.lang.Exception Cuando no encuentra un plugin con el itemCode
     */
    public boolean calculateMeasureCost(Measure measureData) throws Exception {
        
        String itemCode = measureData.getItemCode();
        MeasurePluginManager manager = MeasurePluginManager.getInstance();
        IMeasurePlugin plugin = manager.getMeasurePlugin(itemCode);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el item indicado: " + itemCode);
        }

        return plugin.calculateMeasure(measureData);   
    }
}
