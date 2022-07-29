
package co.unicauca.microkernel.presentation;

import co.unicauca.microkernel.business.ServiceModel;
import co.unicauca.microkernel.common.entities.Measure;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.plugin.manager.Observer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIListProductViewController extends javax.swing.JFrame implements Observer {

    private final ServiceModel service;
    private final JTable table;
    private final DefaultTableModel model;

    /**
     * Creates new form GUIListadoProductos
     *
     * @param service servicio
     */
    public GUIListProductViewController(ServiceModel service) {
        initComponents();
        this.service = service;
        this.model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Estado");
        model.addColumn("Peso");       
        model.addColumn("T. medicion");
        model.addColumn("Código");
        table = new JTable(model);
        jPanel2.add(new JScrollPane(table));
        setSize(500, 200);
        setLocation(10,50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Listado de Productos");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object o) {
        this.setVisible(true);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Estado");
        modelo.addColumn("Peso");
        modelo.addColumn("T. medicion");
        modelo.addColumn("Código");
        this.table.setModel(modelo);
        modelo.setRowCount(0);
        for(Measure m : service.getMeasures()){
            Product p = m.getProduct();
            int id = p.getProductId();
            String estado = m.getEstado();
            double peso = p.getWeight();
            int tiempo_medicion = m.getTiempo();
            String codigo = m.getItemCode();
            modelo.addRow(new Object[]{id, estado , peso, tiempo_medicion, codigo});
        }
        table.paintImmediately(table.getBounds());
    }
}