package herramientas;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import main.Ciudad;

public class FileLoader {

    private static FileInputStream entrada;
    private static FileOutputStream salida;
    public static File archivo = null;

    public static String cargarArchivoTxt(final String file) {
        String content = "";

        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            archivo = new File(file);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content += line + "\n";
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + file + " No se pudo cargar el archivo");
            e.printStackTrace();
        }

        return content;
    }

    public static boolean guardarArchivoTxt(File archivo, String contenido) {
        boolean respuesta = false;
        try {
            if (archivo != null) {
                salida = new FileOutputStream(archivo);
                byte[] bytesTxt = contenido.getBytes();
                salida.write(bytesTxt);
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe un archivo para guardar");
            }

        } catch (Exception e) {

        }
        return respuesta;
    }

    public static ArrayList<Ciudad> cargarCiudadesTxt(String cat) {
        ArrayList<Ciudad> r = new ArrayList<>();

        if (cat != null) {

            String[] line = cat.split("\n");
            for (int i = 1; i < line.length; i++) {
                String[] data = line[i].split(",");
                r.add(new Ciudad(Integer.parseInt(data[1]), data[0])); // Cambiar posicion de las ciudades
            }
        }

        return r;
    }

    public static Grafo cargarEnlacesTxt(String cat, int numCiudades, Grafo g) {
        
        if (cat != null) {

            g = new Grafo(numCiudades);
            
            String[] line = cat.split("\n");
            for (int i = 1; i < line.length; i++) {

                String[] data = line[i].split(",");
                int origen = Integer.parseInt(data[0]);
                int destino = Integer.parseInt(data[1]);
                int dist = Integer.parseInt(data[2]);

                g.crearEnlace(origen, destino, dist);

            }
        }
        
        return g;
    }

}
