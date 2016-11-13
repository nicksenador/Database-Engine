import java.util.*;

public class Query1 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    
   System.out.println("Query 1: Retrieve the name and address of employess who work for the \"Research\" department.");
    System.out.println("----- -");
    
   /* Relation r1 = db.getRelation("DEPARTMENT");
    Relation r2 = db.getRelation("EMPLOYEE");
    Relation r3 = r1.select("col", "DNAME", "=", "str", "Research");
    ArrayList<String> a = new ArrayList<String>();
    a.add("DNAME");
    a.add("DNO");
    a.add("MGRSSN");
    a.add("MGRSTARTDATE");
    Relation r4 = r3.rename(a);
    Relation r5 = r4.join(r2);
    ArrayList<String> b = new ArrayList<String>();
    b.add("FNAME");
    b.add("LNAME");
    b.add("ADDRESS");
    Relation r6 = r5.project(b);
    System.out.print(r6 + "\n");*/
    
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();
    a.add("DNAME");
    a.add("DNO");
    a.add("MGRSSN");
    a.add("MGRSTARTDATE");
    b.add("FNAME");
    b.add("LNAME");
    b.add("ADDRESS");
    
    System.out.print(db.getRelation("DEPARTMENT").select("col", "DNAME", "=", "str", "Research").rename(a).join(db.getRelation("EMPLOYEE")).project(b));
  }
  
}