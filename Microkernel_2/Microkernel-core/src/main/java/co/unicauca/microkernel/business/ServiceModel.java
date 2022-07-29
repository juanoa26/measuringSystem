
package co.unicauca.microkernel.business;

import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.plugin.manager.Subject;
import java.util.ArrayList;
import java.util.List;

public class ServiceModel extends Subject{
    
    private List<Measure> measures;
    
    public ServiceModel(){
        this.measures = new ArrayList<>();
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
    
    public void addMeasure(Measure measure){
        this.measures.add(measure);
        this.notifyAllObserves();
    }
    
    public Measure findMeasure(int id){
        Measure measure = null;
        
        for(Measure m : this.measures){
            if(id == m.getProduct().getProductId()){
                measure = m;
                break;
            }
        }
        
        return measure;
    }
    
    public int numAcceptables(){
        int cont=0;
        
        for(Measure m : this.measures){
            if(m.getEstado().equals("Aceptable")){
                cont++;
            }
        }
        
        return cont;
    }
    
    public int numFailures(){
        int cont=0;
        
        for(Measure m : this.measures){
            if(m.getEstado().equals("Defectuoso")){
                cont++;
            }
        }
        
        return cont;
    }
}
