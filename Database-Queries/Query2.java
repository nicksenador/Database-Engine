import java.util.*;

public class Query2 {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    
    System.out.println("Query 2: For every project located in \"Stafford\", list the project number, the controlling department number, and the department manager's last name, address, and birth date.");
    System.out.println("----- -");
    
    /*Relation r1 = db.getRelation("PROJECTS");
    Relation r2 = db.getRelation("DEPARTMENT");
    Relation r3 = r1.select("col", "PLOCATION", "=", "str", "Stafford");
    ArrayList<String> a = new ArrayList<String>();
    a.add("DNAME");
    a.add("DNUM");
    a.add("SSN");
    a.add("MGRSTARTDATE");
    Relation r4 = r2.rename(a);
    Relation r5 = r3.join(r4);
    Relation r6 = db.getRelation("EMPLOYEE");
    Relation r7 = r5.join(r6);
    ArrayList<String> b = new ArrayList<String>();
    b.add("PNUMBER");
    b.add("DNUM");
    b.add("LNAME");
    b.add("ADDRESS");
    b.add("BDATE");
    Relation r8 = r7.project(b);
    System.out.print(r8);*/
    
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();
    a.add("DNAME");
    a.add("DNUM");
    a.add("SSN");
    a.add("MGRSTARTDATE");
    b.add("PNUMBER");
    b.add("DNUM");
    b.add("LNAME");
    b.add("ADDRESS");
    b.add("BDATE");
    
    Relation answer = db.getRelation("PROJECTS").select("col", "PLOCATION", "=", "str", "Stafford").join(db.getRelation("DEPARTMENT").rename(a)).join(db.getRelation("EMPLOYEE")).project(b);
    answer.setName("ANSWER");
    System.out.print(answer);
  }
  
}