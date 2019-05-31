package herramientas;

public class LimpiarString {

    public static String limpiarStringComboBox(String txt) {
        String r = "";

        String [] data = txt.split("Id: ");
        String[] id = data[1].split(",");
        r = id[0];
        
        return r;
    }

}
