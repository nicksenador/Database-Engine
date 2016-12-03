import java.util.*;

public class Query7 {

	public static void main(String args[]) {
		Database db = new Database();
	    db.initializeDatabase(args[0]);
	    
	    System.out.println("Query 7: List the names of managers who have at least one dependent.");
	    System.out.println("----- -");
	    
	    Relation r0 = db.getRelation("DEPENDENT");
	    Relation r1 = db.getRelation("DEPARTMENT");
	    Relation r2 = db.getRelation("EMPLOYEE");
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("MGRSSN");
	    Relation r3 = r1.project(a);
	    ArrayList<String> b = new ArrayList<String>();
	    b.add("SSN");
	    Relation r4 = r3.rename(b);
	    ArrayList<String> c = new ArrayList<String>();
	    c.add("ESSN");
	    Relation r5 = r0.project(c);
	    Relation r6 = r5.rename(b);
	    Relation r7 = r4.join(r6);
	    Relation r8 = r7.join(r2);
	    ArrayList<String> d = new ArrayList<String>();
	    d.add("LNAME");
	    d.add("FNAME");
	    Relation r9 = r8.project(d);
	    r9.setName("ANSWER");
	    System.out.println(r9);
	}
	
}
