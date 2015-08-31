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
        name=n.trim();
        System.out.println("\tNew Shelve: "+name);
    }

    /**
     *
     * @return Return the name of the Shelve
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @param name add resource with this name
     * @param author this author
     * @param type type of the resource, rejected if it's not a books, magazine or newspaper
     * @param categoria category of the resource
     */
    public void addResource(String name, String author,String type,String categoria){
        System.out.println("\tAdding a resource to the shelve "+getName()+"; "+type);
        switch (categoria.toLowerCase()) {
            case "kids":
                break;
            case "science":
                break;
            case "entertainment":
                break;
            default:
                System.out.println("\t"+categoria+" ->does not belong to any of our categories");
                return;
        }

        if(type.trim().toLowerCase().equals("books")){
            mi_estante.add(new Books(name, author, categoria));
            System.out.println("\tBook added!: "+name+"; "+author);
            return;
        }
        else if (type.trim().toLowerCase().equals("Magazine")){
            mi_estante.add(new Magazines(name, author, categoria));
            System.out.println("\tMagazine added!: " + name + "; " + author);
            return;
        }
        else if(type.trim().toLowerCase().equals("Newspaper")) {
            mi_estante.add(new NewsPaper(name, author, categoria));
            System.out.println("\tNewspaper added!: " + name + "; " + author);
            return;
        }
        System.out.println("\t\t\t\tPLEASE! Try again, just add Books, Magazine or Newspaper!!!!");
    }

    /**
     *
     * @param nombre name of the resource that we wan't to remove
     * @return 1 if resource was found (and eliminated) in this shelve
     */
    public int removeResource(String nombre){
        //si el nombre calza con el resource, eliminamos de la lista.
        //retornamos algo para que se salga del loop de shelves y este del section
        for(int i = 0; i < mi_estante.size(); i++) {
            if (nombre.equals(mi_estante.get(i).getName()) && !mi_estante.get(i).getClass().getSimpleName().equals("NewsPaper")) {

                System.out.println("\tRemoving: '" + nombre+"'\n\tOf "+mi_estante.get(i).getName());
                mi_estante.remove(i);
                return 1;
            }
            else if(nombre.equals(mi_estante.get(i).getName()) && mi_estante.get(i).getClass().getSimpleName().equals("NewsPaper"))
                System.out.println("\tIt's a Newspaper, cannot remove!");
        }
        return 0;
    }

    /**
     * Just for debug
     */
    public void articulos(){
        for(int i = 0; i < mi_estante.size(); i++)
            System.out.println(mi_estante.get(i).getInfo());
    }

    /**
     *
     * @param n search this name or author in the shelve
     * @return List of resources that match this name or author
     */
    public ArrayList search(String n){
        //Rellenaremos la lista con los recursos
        ArrayList<Resources> recursos = new ArrayList<Resources>();
        System.out.println("\tSearching on the shelve "+getName());
        for(int i = 0; i < mi_estante.size(); i++)
            if (n.equals(mi_estante.get(i).getName())) {
                recursos.add(mi_estante.get(i));
                System.out.println("\tResource found by name: "+mi_estante.get(i).getInfo()+" in shelve: "+getName());
            }
        for(int i = 0; i < mi_estante.size(); i++)
            if (n.equals(mi_estante.get(i).getAuthor())){
                recursos.add(mi_estante.get(i));
                System.out.println("\tResource found by last name: "+mi_estante.get(i).getInfo()+" in shelve: "+getName());
            }
        return recursos;

    }

    /**
     *
     * @param nombre search resource with this name
     * @param autor search resource with this author
     * @return List that match name and author
     */
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