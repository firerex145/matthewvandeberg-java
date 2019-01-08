import java.util.ArrayList;

public class Names {
    public static void main (String[] args){
        ArrayList<String> name = new ArrayList<>();
        names(name);
        removePlural(name);
    }
    public static void names (ArrayList<String> name){
        name.add("Billy");
        name.add("Johns");
        name.add("Tims");
        name.add("Sally");
        System.out.println(name);
    }
    public static void removePlural (ArrayList<String> name) {
        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).endsWith("s")) {
                name.remove(i);
                i--;
            }
        }
        System.out.println(name);
    }
}
