/**
 * Created by francisco on 13-08-15.
 */
package paquete;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FirstSampl {
    public static void main(String[] args)throws IOException {
        Resources p1=new Resources("nombre 1","autor","Kids");
        Resources p2=new Resources("nombre 2","autor","Kids");
        Resources p3=new Resources("nombre 3","autor","Kids");
        ArrayList <Resources> r = new ArrayList<Resources>();
        r.add(p1);
        r.add(p2);
        r.add(p3);



        //texting a = new texting();
    }
}
    class texting {
        public texting() throws IOException{
            System.out.println("User manual");
            System.out.println(help);
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String s;
            Boolean t = true;

        while(t){
            s = b.readLine();
            String[] parts = s.split(";");

            switch(parts[0]){
                case "createSection":
                    if(parts.length==2)
                        this.createSection(parts[1]);
                    else{
                        System.out.println("Please, call 'createSection' like this: createSection;Section_Name");
                    }
                    break;
                case "createShelve":
                    if(parts.length==3)
                        this.createShelve(parts[1], parts[2]);
                    else{
                        System.out.println("Please, call 'createShelve' like this: createShelve; Section_Name;Shelve_Name");
                    }
                    break;
                case "addResource":
                    if(parts.length==7)
                        this.addResource(parts[1], parts[2], parts[3], parts[4], parts[5],parts[6]);
                    else{
                        System.out.println("Please, call 'addResource' like this: createShelve; Section_Name;Shelve_Name;Resource_Name;Author;Type; Category");
                    }
                    break;
                case "remove":
                    if(parts.length==2)
                        this.remove(parts[1]);
                    else{
                        System.out.println("Please, call 'remove' like this: Resource_Name");
                    }
                    break;
                case "search":
                    if(parts.length==2)
                        this.search(parts[1]);
                    else if(parts.length==3)
                        this.search(parts[1],parts[2]);
                    else{
                        System.out.println("Please, call 'search' like this: Resource_Name,Resource_author");
                    }
                    break;
                case "Help":
                    System.out.println(help);
                    break;
                case "Quit":
                    t=false;
                    System.out.println("Please, come back latter!");
                    break;
                default:
                    System.out.println("Lost? Please write 'Help' for more info.");
            }
        }

        }
    //crear estantes
    public void createSection(String n){
        mi_lybrarie.add(new section(n));
    }
    //crear shelves; damos el nombre de la seccion y el nombre del nuevo estante
    public void createShelve(String n, String n_shelve){
        for(int i = 0; i < mi_lybrarie.size(); i++)
            if (n.equals(mi_lybrarie.get(i).getName()))
                mi_lybrarie.get(i).createShelves(n_shelve);
    }
    //addResource
    public void addResource(String n, String n_shelve, String name, String author,String type,String categoria){
        for(int i=0; i<resource.size();i++){
            if(name.equals(resource.get(i))){
                resource.remove(i);
                System.out.println("Somebody already asked for this Resource, please give it to her/him. Thanks!");
                return;
            }
        }
        for(int i = 0; i < mi_lybrarie.size(); i++)
            if (n.equals(mi_lybrarie.get(i).getName()))
                mi_lybrarie.get(i).addResource(n_shelve, name, author, type, categoria);
    }

    //search resource
    public void search(String n){
        for(int i = 0; i < mi_lybrarie.size(); i++)
            mi_lybrarie.get(i).searchResource(n);
    }
    public void search(String name, String autor){
        for(int i = 0; i < mi_lybrarie.size(); i++)
            mi_lybrarie.get(i).searchResource(name,autor);
    }
    //removeResource
    public void remove(String name){
        int a;
        for(int i = 0; i < mi_lybrarie.size(); i++) {
            a = mi_lybrarie.get(i).removeResource(name);
            if (a==1)
                return;

        }
        System.out.println("The resource is not available, please hold");
        resource.add(name);
    }

    //variables
    public ArrayList<section> mi_lybrarie = new ArrayList<section>();
    public ArrayList<String> resource = new ArrayList<>();
        public String help="Hi, for use the methods, you will have to write down the name and parameters, " +
                "with ';' separated"
                +"\nCreate Section: createSection; section_name" +
                "\nCreate Shelve: createShelve; section_name; shelve_name" +
                "\nAdd resource: addResource; section_name; shelve_name; name; author; type; category" +
                "\nSearch resource: search; name" +
                "\nSearch resource: search; name; author" +
                "\nRemove resource (names won't clash): remove; name" +
                "\nQuit: just quit the app!" +
                "\ngood luck.\n\n"
                ;
}

