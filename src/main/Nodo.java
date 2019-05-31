package main;

import java.awt.Color;
import java.awt.Graphics;


public abstract class Nodo {

    protected int ciudad_id;
    protected Nodo pNext;

    private int x, y;
    public static final int d = 60;
    
    private int red = (int) (Math.random() * 256);
    private int green = (int) (Math.random() * 256);
    private int blue = (int) (Math.random() * 256);
    
    public Nodo(int ciudad_id) {
        this.ciudad_id = ciudad_id;
        pNext = null;
    }

    public void pintar(Graphics g) {
        g.setColor(new Color(red, green, blue));
        g.fillOval(x - d / 2, y - d / 2, d, d);
//        g.drawOval(x - d/2, y - d/2, d, d);
        g.setColor(Color.black);
        g.drawString(ciudad_id+"", x, y);
    }

    public int gettInfo() {
        return ciudad_id;
    }

    public void settInfo(int tInfo) {
        this.ciudad_id = tInfo;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
    
    
    
    
}
