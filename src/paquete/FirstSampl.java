/**
 * Created by francisco on 13-08-15.
 */
package paquete;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FirstSampl {
    public static void main(String[] args)throws IOException {

        /*
        Resources p1=new Resources("anombre 1","autor","Kids");
        Resources p2=new Resources("cacumenes 2","autor","Kids");
        Resources p3=new Resources("chulo 3","autor","Kids");
        ArrayList <Resources> r = new ArrayList<Resources>();
        r.add(p1);
        r.add(p2);
        r.add(p3);

        Collections.sort(r);

        for(int a =0; a<r.size();a++)
            System.out.println(r.get(a).getInfo());*/

        /*
        ArrayList<Resources> recursos = new ArrayList<Resources>();
        section s1=new section("s1");
        section s3=new section("s1");
        section s2=new section("s2");

        s1.createShelves("estante1");
        s1.createShelves("estante2");
        s1.addResource("estante1", "nombre", "  autor", "Books", "Kids");
        s1.addResource("estante1","nombre2","  autor","BOO ks","Kids");
        s1.addResource("estante2","nombre4","autor  ","Books","Kids");
        s1.addResource("estante2", "nombre3", " autor ", "Books", "Kids");
        recursos = s1.searchResource("autor");

        System.out.println("\n\n");

        for (int i=0;i<recursos.size();i++)
            System.out.println(recursos.get(i).getInfo());*/

        texting a = new texting();
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

            switch(parts[0].toLowerCase()) {
                case "createsection":
                    if (parts.length == 2) {
                        this.createSection(parts[1]);
                    }
                    else {
                        System.out.println("Please, call 'createSection' like this: createSection;Section_Name");
                    }
                    break;
                case "createshelve":
                    if (parts.length == 3){
                        this.createShelve(parts[1], parts[2]);
                    }
                    else{
                        System.out.println("Please, call 'createShelve' like this: createShelve; Section_Name;Shelve_Name");
                    }
                    break;
                case "addresource":
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
                case "help":
                    System.out.println(help);
                    break;
                case "quit":
                    t=false;
                    System.out.println("Please, come back latter!");
                    break;
                default:
                    System.out.println("Lost? Please write 'Help' for more info.");
            }
        }

        }

        /**
         *
         * @param n create section with this name if it doesn't exists
         */
    public void createSection(String n){
        if(n.replace(" ","").equals("")){
            System.out.println("Please, give the Section a name");
        }

        for(int i=0;i<mi_lybrarie.size();i++) {
            if (n.trim().equals(mi_lybrarie.get(i).getName())) {
                System.out.println("Section already created");
                return;
            }
        }
        mi_lybrarie.add(new section(n));
        }

        /**
         *
         * @param n create a shelve in this section
         * @param n_shelve create this shelve if it doesn't exist in this section
         */

    public void createShelve(String n, String n_shelve){
        for(int i = 0; i < mi_lybrarie.size(); i++)
            if (n.equals(mi_lybrarie.get(i).getName()))
                mi_lybrarie.get(i).createShelves(n_shelve);
    }

        /**
         *
         * @param n in this Section
         * @param n_shelve this Shelve
         * @param name add a resource with this name
         * @param author this author
         * @param type this type
         * @param categoria this category
         */
    public void addResource(String n, String n_shelve, String name, String author,String type,String categoria){
        for(int i=0; i<resource.size();i++){
            if(name.trim().equals(resource.get(i))){
                resource.remove(i);
                System.out.println("Somebody already asked for this Resource, please give it to her/him. Thanks!");
                return;
            }
        }

        for(int i = 0; i < mi_lybrarie.size(); i++)
            if (n.equals(mi_lybrarie.get(i).getName()))
                mi_lybrarie.get(i).addResource(n_shelve, name, author, type, categoria);
    }

        /**
         *
         * @param n search a resource with this name or author
         */
    public void search(String n){
        ArrayList<Resources> r = new ArrayList<Resources>();
        ArrayList<Resources> aux = new ArrayList<Resources>();
        for(int i = 0; i < mi_lybrarie.size(); i++) {
            aux.clear();
            aux = mi_lybrarie.get(i).searchResource(n);

            for(int a =0;a< aux.size();a++) {
                r.add(aux.get(a));
            }
        }
        for(int i=0;i<r.size();i++)
            System.out.println(i+1+".- "+r.get(i).getInfo());
    }

        /**
         *
         * @param name search resource with this name
         * @param autor and this author
         */
    public void search(String name, String autor){
        for(int i = 0; i < mi_lybrarie.size(); i++)
            mi_lybrarie.get(i).searchResource(name,autor);
    }

        /**
         *
         * @param name remove resource with this name (name's won't collide). If it doesn't exist, reserve it
         */
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

