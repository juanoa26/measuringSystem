package co.unicauca.microkernel.common.interfaces;

import co.unicauca.microkernel.common.entities.Measure;

public interface IMeasurePlugin {

    /**
     * Establece la medicion del producto.
     *
     * @param measure item de medicion que contiene las medidas del item fisico
     * @return true o false dependiendo de si el producto es aceptable o 
     * defectuoso
     */
    boolean calculateMeasure(Measure measure);

}
