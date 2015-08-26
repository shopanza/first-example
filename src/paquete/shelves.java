package paquete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by francisco on 15-08-15.
 */
public class shelves {
    public shelves(String n){
        name=n;
        System.out.println("\tNew Shelve: "+name);
    }
    public String getName(){
        return name;
    }
    public void addResource(String name, String author,String type,String categoria){
        System.out.println("\tAdding a resource to the shelve "+getName()+" el tip es: "+type);
        if(type.equals("Books")){
            mi_estante.add(new Books(name, author, categoria));
            System.out.println("\tBook added!: "+name+"; author: "+author);
            return;
        }
        else if (type.equals("Magazine")){
            mi_estante.add(new Magazines(name, author, categoria));
            System.out.println("\tMagazine added!: " + name + "; author: " + author);
            return;
        }
        else if(type.equals("Newspaper")) {
            mi_estante.add(new NewsPaper(name, author, categoria));
            System.out.println("\tNewspaper added!: " + name + "; author: " + author);
            return;
        }
        System.out.println("\tTry again, just add Books, Magazine or Newspaper!! Case-sensitive");
    }
    public int removeResource(String nombre){
        //si el nombre calza con el resource, eliminamos de la lista.
        //retornamos algo para que se salga del loop de shelves y este del section
        for(int i = 0; i < mi_estante.size(); i++) {
            if (nombre.equals(mi_estante.get(i).getName()) && !mi_estante.get(i).getClass().getSimpleName().equals("NewsPaper")) {

                System.out.println("\tremove: " + nombre+"; author: "+mi_estante.get(i).getName());
                System.out.println("\tThanks! Keep on reading!");
                mi_estante.remove(i);
                return 1;
            }
            else if(nombre.equals(mi_estante.get(i).getName()) && mi_estante.get(i).getClass().getSimpleName().equals("NewsPaper"))
                System.out.println("\tIt's a Newspaper, cannot remove!");
        }
        return 0;
    }

    //SOLO PARA IMPRIMIR
    public void articulos(){
        for(int i = 0; i < mi_estante.size(); i++)
            System.out.println(mi_estante.get(i).getInfo());

    }
    //BUSQUEDA DE ELEMENTOS POR NOMBRE O AUTOR; devolvemos un print si algo se parece
    public ArrayList search(String n){
        //Rellenaremos la lista con los recursos
        ArrayList<Resources> recursos = new ArrayList<Resources>();
        System.out.println("\tSearching on the shelve "+getName());
        for(int i = 0; i < mi_estante.size(); i++)
            if (n.equals(mi_estante.get(i).getName())) {
                recursos.add(mi_estante.get(i));
                System.out.println("\tResource found: "+mi_estante.get(i).getInfo()+" in shelve: "+getName());
            }
        for(int i = 0; i < mi_estante.size(); i++)
            if (n.equals(mi_estante.get(i).getAuthor())){
                recursos.add(mi_estante.get(i));
                System.out.println("\tResource found: "+mi_estante.get(i).getInfo()+" in shelve: "+getName());
            }
        return recursos;

    }
    //BUSQUEDA POR NOMBRE Y AUTOR;  devolvemos un print si algo se parece
    public ArrayList search(String nombre, String autor){
        //Buscar una vez por nombre y/o autor
        //Rellenaremos la lista con los recursos
        ArrayList<Resources> recursos = new ArrayList<Resources>();
        System.out.println("\tSearching for "+nombre+"; author: "+autor);
        for(int i = 0; i < mi_estante.size(); i++)
            if (nombre.equals(mi_estante.get(i).getName()) && autor.equals(mi_estante.get(i).getAuthor())) {
                recursos.add(mi_estante.get(i));
                System.out.println("\tResource found "+mi_estante.get(i).getInfo()+" in shelve: "+getName());
            }
        return recursos;
    }


    private String name;
    private String category;
    //lista de recursos en la estantería
    private ArrayList<Resources> mi_estante = new ArrayList<Resources>();
    //categorias
    private static final List<String> categories =
            Collections.unmodifiableList(Arrays.asList("Science", "Entertainment","Kids"));
}
