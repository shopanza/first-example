package paquete;

import java.util.ArrayList;

/**
 * Created by francisco on 17-08-15.
 */


public class section {
    public section(String n){
        System.out.println("Creating Section "+n);
        name = n.trim();

    }
    /**
     * @return return the name of the Shelve
     */
    public String getName(){return name;}

    /**
     *
     * @param n name of the section, won't accept section's with the same name.
     */
    public void createShelves(String n){
        if(n.replace(" ","").equals("")){
            System.out.println("Please, give the shelves a name");
        }
        for(int i=0;i<mi_section.size();i++) {
            if (n.trim().equals(mi_section.get(i).getName())) {
                System.out.println("Shelve already exists inside the section "+getName());
                return;
            }
        }
        mi_section.add(new shelves(n));
    }

    /**
     *
     * @param name_shelve Name of the Shelve that belong to this Section, all shelves will have different names.
     * @param name Name of the resource
     * @param author Author of the resource
     * @param type Type: Books, Magazine or NewsPaper, will reject the resources if is not one of this three types.
     * @param categoria Category: Science, Entertainment and Kids.
     */
    public void addResource(String name_shelve, String name, String author,String type,String categoria){
        for(int i = 0; i < mi_section.size(); i++) {

            if (name_shelve.equals(mi_section.get(i).getName())) {
                mi_section.get(i).addResource(name, author,type,categoria);
                return;
            }
        }
        System.out.println("Can't find the shelve named "+name_shelve);
    }

    /**
     *
     * @param nombre Search resources by name or author
     * @return List of resources that fits the input
     */
    public ArrayList searchResource(String nombre){
        ArrayList<Resources> recursos = new ArrayList<>();
        ArrayList<Resources> aux = new ArrayList<Resources>();
        for(int i = 0; i < mi_section.size(); i++) {
            System.out.println("Searching in: " + mi_section.get(i).getName());
            aux = mi_section.get(i).search(nombre);
            for(int a =0;a< aux.size();a++) {
                System.out.println("entramos nuevamente: "+a);
                recursos.add(aux.get(a));
                System.out.println("section traspasamos " + aux.get(a).getInfo()+" nos queda: "+aux.size());
            }
        }
        /*
        for(int a =0;a< recursos.size();a++){
            System.out.println("se imprimen los libros buscados" + recursos.get(a).getInfo());
        }*/
        System.out.println("Retornamos de recursos");
        return recursos;


    }

    /**
     *
     * @param nombre search resource with this name
     * @param autor search resource with this author
     * @return List with the matches found
     */
    public ArrayList searchResource(String nombre, String autor){
        ArrayList<Resources> recursos = new ArrayList<>();
        ArrayList<Resources> aux = new ArrayList<Resources>();
        for(int i = 0; i < mi_section.size(); i++) {
            aux = mi_section.get(i).search(nombre, autor);
            for(int a =0;a< aux.size();a++) {
                recursos.add(aux.get(a));
            }
        }
        return recursos;
    }

    /**
     *
     * @param name removes the resource with this name (names won't collide, if it doesn't exist,
     *             when someone returns the resource will be delivered immediately.). Newspaper can't be removed!
     * @return 1 if the resource was found and removed from the list!
     */
    public int removeResource(String name) {
        for (int i = 0; i < mi_section.size(); i++) {
            System.out.println("Searching in: " + mi_section.get(i).getName());
            if (mi_section.get(i).removeResource(name.trim())==1){
                System.out.println("\tFound resource in Section/shelve "+getName()+"/"+mi_section.get(i).getName());
                System.out.println("\tThanks! Keep on reading!");
                return 1;
            }
        }
        return 0;

    }

    private String name;
    private ArrayList<shelves> mi_section = new ArrayList<shelves>();

}