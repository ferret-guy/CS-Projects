/* Proj10_DBObjects
*
* CSc 127A Fall 15, Project 08
*
* Author: Mark Omo
* Section: K
*
* ---
*
* record object
*/

public class Record{
    String firstName, lastName;
    int age;
    public Record (String first, String last, int age) { 
        this.firstName = first; 
        this.lastName = last; 
        this.age = age; 
    } 
    
    public Record() { 
        this.firstName = ""; 
        this.lastName = ""; 
        this.age = 0; 
    }
    public String toString(){
        return this.firstName+" "+this.lastName+" "+this.age;
    }
}