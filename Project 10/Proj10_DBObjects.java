/* Proj10_DBObjects
*
* CSc 127A Fall 15, Project 08
*
* Author: Mark Omo
* Section: K
*
* ---
*
* Reads a simple DB format and allows quires
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
//import Record;

public class Proj10_DBObjects{ 
    public static void listAll(ArrayList<Record> table){
        //Print out items in db
        for(int i=0;i<table.size();i++){
            System.out.print((i+1)+": ");
            System.out.print(table.get(i)+"\n");
        }
    }
    
    public static void findByLastName(String name,ArrayList<Record> table){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<table.size();i++){
            if (table.get(i).lastName.toLowerCase().equals(name))
                list.add(i);
        }
        for(int i=0;i<list.size();i++){
            System.out.print((list.get(i)+1)+": ");
            System.out.print(table.get(list.get(i))+"\n");
        }   
    }
    
    public static void findByFirstName(String name,ArrayList<Record> table){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<table.size();i++){
            if (table.get(i).firstName.toLowerCase().equals(name))
                list.add(i);
        }
        for(int i=0;i<list.size();i++){
            System.out.print((list.get(i)+1)+": ");
            System.out.print(table.get(list.get(i))+"\n");
        }
    }
    
    public static void findByAge(String age,ArrayList<Record> table){
        try{int a = Integer.parseInt(age);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<table.size();i++){
                if (table.get(i).age == a)
                    list.add(i);
            }
            for(int i=0;i<list.size();i++){
                System.out.print((list.get(i)+1)+": ");
                System.out.print(table.get(list.get(i))+"\n");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Invalid command, valid commands are:\nlistAll\nlastName <last name>\nfirstName <first name>\nage <age>");
        }
    }
    
    public static void main(String[] args){
        //Initilize data structures
        ArrayList<Record> table= new ArrayList<Record>();
        String file = "";
        //Check for valid input
        if (args.length == 1){
            try {
                file = args[0];
                File f = new File(file);
                Scanner s = new Scanner(f);
            
                String l = null;  
                //Run through file
                while (s.hasNextLine()){  
                    l = s.nextLine();
                    if (l.split(" +").length==3){//Handles any size whitespace
                        try{int i = Integer.parseInt(l.split(" +")[2]);
                            table.add(new Record(l.split(" +")[0],l.split(" +")[1],i));}
                        catch (NumberFormatException e){}
                    }
                }
            }
            catch (FileNotFoundException e){
                System.out.println("Error file "+file+" was not found try again!");
                return;
            }
        }
        else{System.out.println("You need just one arg <filename>!");
            return; }
        
        //Interprate commands
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()){
            String[] input = in.nextLine().toLowerCase().split(" +");
            if (input[0].equals("listall")){
                listAll(table);}
            else if (input.length != 2)
                System.out.println("Invalid command, valid commands are:\nlistAll\nlastName <last name>\nfirstName <first name>\nage <age>");
            else if (input[0].equals("lastname")){
                findByLastName(input[1],table);}
            else if (input[0].equals("firstname")){
                findByFirstName(input[1],table);}
            else if (input[0].equals("age")){
                findByAge(input[1],table);}
            else
                System.out.println("Invalid command, valid commands are:\nlistAll\nlastName <last name>\nfirstName <first name>\nage <age>");
            
        }
        
    }
}