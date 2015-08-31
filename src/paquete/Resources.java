package paquete;

/**
 * Created by francisco on 13-08-15.
 */
/*lase padre: recursos
* crear clase hija: SoftResources
* crear clase hija: HardResources -> clases hijas: Books; Magazines; Newsletter
* */

public class Resources implements Comparable<Resources>{

    public Resources(String nombre, String autor, String categoria){
        name = nombre.trim();
        author = autor.trim();
        category = categoria.trim();
        System.out.println("\t\tResource created, name: "+name+"; Author: "+author+"; Category: "+category);
    }
    /*
    Return the info of the Resource: name and author, separated by ;
     */
    public String getInfo(){
        return name+"; "+author;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }

    public int compareTo(Resources compareResource) {

        return name.toUpperCase().compareTo(compareResource.getName().toUpperCase());
    }


    private void setName(String n){
        name=n;
    }
    private void setAuthor(String a){
        author=a;
    }
    private String name;
    private String author;
    private String category;

}

class HardResource extends Resources{
    public HardResource(String nombre, String autor, String categoria){
        super(nombre, autor, categoria);

    }

}


class Books extends HardResource{
    public Books(String nombre, String autor, String categoria){
        super(nombre, autor, categoria);
    }

}

class Magazines extends HardResource{
    public Magazines(String nombre, String autor, String categoria){
        super(nombre, autor, categoria);
    }

}

class NewsPaper extends HardResource{
    public NewsPaper(String nombre, String autor, String categoria){super(nombre, autor, categoria);}

}
