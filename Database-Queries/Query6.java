import java.util.*;

public class Query6 {
	  public static void main(String args[]) {
	    Database db = new Database();
	    db.initializeDatabase(args[0]);
	    
	    System.out.println("Query 6: Retrieve the names of employees who have no dependents.");
	    System.out.println("----- -");
	    
	    /*Relation r1 = db.getRelation("EMPLOYEE");
	    Relation r2 = db.getRelation("DEPENDENT");
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("SSN");
	    Relation r3 = r1.project(a);
	    ArrayList<String> b = new ArrayList<String>();
	    b.add("ESSN");
	    Relation r4 = r2.project(b);
	    Relation r5 = r3.minus(r4);
	    Relation r6 = r5.join(r1);
	    ArrayList<String> c = new ArrayList<String>();
	    c.add("LNAME");
	    c.add("FNAME");
	    Relation r7 = r6.project(c);
	    System.out.print(r7);*/
	    
	    ArrayList<String> a = new ArrayList<String>();
	    ArrayList<String> b = new ArrayList<String>();
	    ArrayList<String> c = new ArrayList<String>();
	    a.add("SSN");
	    b.add("ESSN");
	    c.add("LNAME");
	    c.add("FNAME");
	    
	    System.out.print(db.getRelation("EMPLOYEE").project(a).minus(db.getRelation("DEPENDENT").project(b)).join(db.getRelation("EMPLOYEE")).project(c));
	  }

}