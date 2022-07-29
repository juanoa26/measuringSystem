package com.unicauca.publicador_suscriptor.presentation;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.unicauca.products.publicador_suscriptor.Service.Product;
import com.unicauca.products.publicador_suscriptor.Service.ProductService;
import com.unicauca.products.publicador_suscriptor.access.validacionMedida;
import java.util.List;
import javax.swing.DefaultListModel;

//envia mensaje
public class Send {

    public Send() {
    }
    private static final String EXCHANGE_NAME = "log";
    static DefaultListModel modeloPublicador = new DefaultListModel();

    //static int contador=1;
    public void init() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        //TODO obtener informacion del producto
        ProductService productservice = new ProductService();
        List<Product> ListaProducts = productservice.getAll();
        validacionMedida vMedida = new validacionMedida();
        ///-----
        //int contador = 1;
        try ( Connection connection = factory.newConnection();  Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            modeloPublicador.removeAllElements();
            String SendInit = "*******¡Enviando mensaje!********";
            channel.basicPublish(EXCHANGE_NAME, "", null, SendInit.getBytes("UTF-8"));
            for (int i = 0; i <= ListaProducts.size() - 1; i++) {
                String messagee = "Producto:ID " + ListaProducts.get(i).getProductId() + " , " + ListaProducts.get(i).getName() + " , "
                        + ListaProducts.get(i).getWeight() + " , " + ListaProducts.get(i).getWidth() + " , " + ListaProducts.get(i).getHeight()
                        + " , " + ListaProducts.get(i).getDepth();
                String mmsDefectuosa = "Producto con Id: " + ListaProducts.get(i).getProductId() + " Defectuoso...Rechazado";
                if (!vMedida.validacionMedidaLata(ListaProducts.get(i))) {
                    channel.basicPublish(EXCHANGE_NAME, "", null, mmsDefectuosa.getBytes("UTF-8"));
                    //System.out.println(" [x] Sent '" + messagee + " ");

                    modeloPublicador.addElement(messagee);
                } else {
                    String mssAceptado = "Producto Aceptado:ID " + ListaProducts.get(i).getProductId() + " , " + ListaProducts.get(i).getName() + " , "
                            + ListaProducts.get(i).getWeight() + " , " + ListaProducts.get(i).getWidth() + " , " + ListaProducts.get(i).getHeight()
                            + " , " + ListaProducts.get(i).getDepth();
                    channel.basicPublish(EXCHANGE_NAME, "", null, mssAceptado.getBytes("UTF-8"));                    
                    modeloPublicador.addElement(messagee);
                }
            }
        }
    }
}
