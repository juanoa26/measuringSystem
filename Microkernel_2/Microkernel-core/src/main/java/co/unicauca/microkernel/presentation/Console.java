
package co.unicauca.microkernel.presentation;

import co.unicauca.microkernel.business.MeasureService;
import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.common.entities.Product;

import java.util.Scanner;

public class Console {

    private final MeasureService measureService;

    private final Scanner scanner;

    public Console(){
        measureService = new MeasureService();
        scanner = new Scanner(System.in);
    }

    public void start() {

        int option;

        System.out.println("Aplicacion de medicion");

        do {

            System.out.println();
            System.out.println("1. Medir item.");
            System.out.println("2. Salir.");

            option = scanner.nextInt();

            switch (option) {
                case 1: 
                    handleDeliveryCostOption();
                    break;
            }

        } while(option != 2);

        System.out.println("Aplicacion terminada");
    }

    private void handleDeliveryCostOption(){

        System.out.println("ID del item: ");
        int id = scanner.nextInt();
        
        System.out.println("Peso del item: ");
        double weight = scanner.nextDouble();
    
        Product selectedProduct = new Product(id, weight);
        
        System.out.println("Tiempo de medicion: ");
        int tiempo = scanner.nextInt();
        
        //Leer salto de línea para que pueda pregunta por el código del país. (https://stackoverflow.com/a/13102066/1601530)
        scanner.nextLine();

        System.out.println("Código del item que será medido: ");
        String itemCode = scanner.nextLine();

        //objeto de  la capa de dominio para  el cálculo.
        Measure measurementEntity = new Measure(selectedProduct, tiempo, itemCode);

        try {
            boolean medicion = measureService.calculateMeasureCost(measurementEntity);
            if(medicion){
                System.out.println("La medicion fue exitosa. ");
            }else{
                System.out.println("Producto rechazado.");
            }
        } catch (Exception exception) {
            System.out.println("No fue posible medir el item. " + exception.getMessage());
        }

    }
}
