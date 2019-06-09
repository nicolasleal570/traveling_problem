package main;

import herramientas.FileLoader;
import herramientas.Grafo;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    private ArrayList<Ciudad> ciudades;
    private ArrayList<Arista> enlaces;
    private Grafo graph;

    private int[][] mAdy;

    private String rutaFile;
    private JFileChooser seleccionado = new JFileChooser();
    private File archivo;

    private Point p1, p2;

    public Lienzo() {
        ciudades = new ArrayList<>();
        enlaces = new ArrayList<>();
        initMoreConfig();
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.red);
        g.fillOval(50, 50, 100, 100);

        for (Ciudad c : ciudades) {
            //c.pintar(g);
        }
        for (Arista e : enlaces) {
            //e.pintar(g);
        }
    }

    /**
     * INICIA VARIABLES EXTRAS QUE UTILIZA EL PROGRAMA
     */
    private void initMoreConfig() {
        rutaFile = FileLoader.cargarArchivoTxt("recursos/config.txt");
        archivo = FileLoader.archivo;

        armarGrafo();
        llenarMatrizAdyacencia();
    }

    /* ARMA EL GRAFO CON LAS CONEXIONES DEPENDE DEL TXT */
    public void armarGrafo() {

        String[] categoria = rutaFile.split("-");
        ciudades = cargarCiudadesTxt(categoria[1]); // Obtiene las ciudades desde el txt
        graph = new Grafo(ciudades.size());
        cargarEnlacesTxt(categoria[2], graph); // Obtiene los enlaces entre las ciudades desde el txt

    }

    /* LEE EL ARCHIVO TXT Y RECUPERA LAS CIUDADES */
    public ArrayList<Ciudad> cargarCiudadesTxt(String cat) {
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

    /* CREA LOS ENLACES ENTRE CIUDADES */
    public void cargarEnlacesTxt(String cat, Grafo g) {

        if (cat != null) {

            String[] line = cat.split("\n");
            for (int i = 1; i < line.length; i++) {

                String[] data = line[i].split(",");
                int origen = Integer.parseInt(data[0]);
                int destino = Integer.parseInt(data[1]);
                int dist = Integer.parseInt(data[2]);

                g.crearEnlace(origen, destino, dist);

            }
        }
    }

    /* LLENA LA MATRIZ DE ADYACENCIA CON LAS DISTANCIAS ENTRE CIUDADES */
    private void llenarMatrizAdyacencia() {
        mAdy = new int[ciudades.size() + 1][ciudades.size() + 1];
        for (int i = 0; i < graph.getGraphEstructura().length; i++) {
            for (int j = 0; j < graph.getGraphEstructura()[i].size(); j++) {

                if (!graph.getGraphEstructura()[i].isEmpty()) {

                    int idOrigen = i;
                    int idDestino = graph.getGraphEstructura()[i].get(j).getVertice();

                    mAdy[idOrigen + 1][idDestino + 1] = graph.getGraphEstructura()[i].get(j).getDistancia(); // Accediendo a todos los valores de la lista enlazada

                }
            }

        }
    }

    /* GETTERS Y SETTERS */
    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public Grafo getGraph() {
        return graph;
    }

    public String getRutaFile() {
        return rutaFile;
    }

    public void setRutaFile(String rutaFile) {
        this.rutaFile = rutaFile;
    }

    public JFileChooser getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(JFileChooser seleccionado) {
        this.seleccionado = seleccionado;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public void setGraph(Grafo graph) {
        this.graph = graph;
    }

}
