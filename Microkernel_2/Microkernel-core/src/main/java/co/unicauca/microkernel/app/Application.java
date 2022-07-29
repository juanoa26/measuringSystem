
package co.unicauca.microkernel.app;

import co.unicauca.microkernel.business.ServiceModel;
import co.unicauca.microkernel.plugin.manager.MeasurePluginManager;
//import co.unicauca.microkernel.presentation.Console;
import co.unicauca.microkernel.presentation.GUIAddProductViewController;
import co.unicauca.microkernel.presentation.GUIListProductViewController;
import co.unicauca.microkernel.presentation.GUIListProductViewController2;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) {
        new Application().execute();
    }
    
    public void execute(){
        //Inicializar el plugin manager con la ruta base de la aplicación.
        String basePath = getBaseFilePath();
        try {
            MeasurePluginManager.init(basePath);
           
            ServiceModel model = new ServiceModel();
           
            //Inyeccion de dependencias
            GUIAddProductViewController instance = new GUIAddProductViewController(model);
            instance.setVisible(true);
            model.addObserver(new GUIListProductViewController(model));
            model.addObserver(new GUIListProductViewController2(model));
        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicacion", ex);
        }
    }

    /**
     * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
     * sea desde un archivo .class o desde un paquete .jar.
     *
     */
    private static String getBaseFilePath() {
        try {
            String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
                
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }

}
