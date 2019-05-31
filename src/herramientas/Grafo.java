package herramientas;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import main.Arista;

public class Grafo {

    private List<Arista> G[];

    public Grafo(int nroVertices) {
            G = new LinkedList[nroVertices];

            for (int i = 0; i < G.length; i++) {
                G[i] = new LinkedList<>();
            }
    }

    public void crearEnlace(int origen, int destino, int distancia) {
        G[origen].add(0, new Arista(destino, distancia));
        G[destino].add(0, new Arista(origen, distancia));
    }

    /**
     * Crea un nuevo arreglo mas grande al crear una nueva ciudad
     * @param nroVertices = Nro de ciudades existentes
     * @param graphViejo = Estructura de la lista de adyacencia vieja
     * @return = nueva lista de adyacencia
     */
    public void cargarNuevaCiudad(int nroVertices, List<Arista>[] graphViejo) {

        if (nroVertices > G.length) {

            List<Arista> nuevo[] = new LinkedList[nroVertices];

            for (int i = 0; i < nuevo.length; i++) {
                if (i < nroVertices - 1) {
                    nuevo[i] = G[i];
                } else {
                    nuevo[i] = new LinkedList<>();
                }

            }
            
            G = nuevo;

        }

    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < G.length; i++) {
            r += i + " => " + G[i] + "\n";
        }
        return r;
    }

    public List<Arista>[] getGraphEstructura() {
        return G;
    }

    public void setGraphEstructura(List<Arista>[] G) {
        this.G = G;
    }

    
    
}
