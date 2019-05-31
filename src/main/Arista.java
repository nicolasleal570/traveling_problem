package main;

import java.awt.Color;
import java.awt.Graphics;

public class Arista {

    private int vertice, distancia;

    public Arista(int vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    /*public void pintar(Graphics g){
        g.setColor(Color.black);
        g.drawLine(x1, y1, x2, y2);
    }*/

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "(" + vertice + ", " + distancia + ")";
    }

}
