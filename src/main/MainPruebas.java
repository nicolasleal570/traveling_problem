package main;

import ventanas.Principal;


public class MainPruebas {

    public static void main(String[] args) {
        Lienzo lienzo = new Lienzo();
        Principal v = new Principal(lienzo);
        
        
        v.setVisible(true);
    }
    
}
