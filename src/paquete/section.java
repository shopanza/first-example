package paquete;

import java.util.ArrayList;

/**
 * Created by francisco on 17-08-15.
 */
public class section {
    public section(String n){
        System.out.println("Creating Section "+n);
        name = n;

    }
    public String getName(){return name;}

    //crear estantes
    public void createShelves(String n){
        System.out.println("Creating Shelves: "+n);
        mi_section.add(new shelves(n));
    }

    //agregar libros a estantes
    public void addResource(String name_shelve, String name, String author,String type,String categoria){
        for(int i = 0; i < mi_section.size(); i++) {
            if (name_shelve.equals(mi_section.get(i).getName())) {
                mi_section.get(i).addResource(name, author,type,categoria);
                return;
            }
        }
        System.out.println("Can't find the shelve named "+name_shelve);
    }
    //buscar libros en estantes
    public void searchResource(String nombre){
        for(int i = 0; i < mi_section.size(); i++) {
            System.out.println("Searching in: "+mi_section.get(i).getName());
            mi_section.get(i).search(nombre);
        }
    }
    public void searchResource(String nombre, String autor){
        for(int i = 0; i < mi_section.size(); i++) {
            System.out.println("buscando en el estante: "+mi_section.get(i).getName());
            mi_section.get(i).search(nombre, autor);
        }
    }
    //sacar libros de estantes
    public int removeResource(String name){
        for(int i = 0; i < mi_section.size(); i++) {
            System.out.println("Searching in: "+mi_section.get(i).getName());
            if (mi_section.get(i).removeResource(name) == 1)
                return 1;
        }
        return 0;

    }

    private String name;
    private ArrayList<shelves> mi_section = new ArrayList<shelves>();

}
