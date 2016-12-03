import java.util.*;

public class Query5 {

	public static void main(String args[]) {
		Database db = new Database();
	    db.initializeDatabase(args[0]);
	    
	    System.out.println("Query 5: List the names of all employees with two or more dependents.");
	    System.out.println("----- -");
	    
	    Relation r1 = db.getRelation("DEPENDENT");
	    Relation r2 = db.getRelation("EMPLOYEE");
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("ESSN");
	    a.add("DEPENDENT_NAME");
	    Relation r3 = r1.project(a);
	    ArrayList<String> b = new ArrayList<String>();
	    b.add("ESSN1");
	    b.add("DNAME1");
	    Relation r4 = r3.rename(b);
	    Relation r5 = r1.project(a);
	    ArrayList<String> c = new ArrayList<String>();
	    c.add("ESSN2");
	    c.add("DNAME2");
	    Relation r6 = r5.rename(c);
	    Relation r7 = r4.times(r6);
	    Relation r8 = r7.select("col", "ESSN1", "=", "col", "ESSN2");
	    Relation r9 = r8.select("col", "DNAME1", "<>", "col", "DNAME2");
	    ArrayList<String> d = new ArrayList<String>();
	    d.add("ESSN1");
	    Relation r10 = r9.project(d);
	    ArrayList<String> e = new ArrayList<String>();
	    e.add("SSN");
	    Relation r11 = r10.rename(e);
	    Relation r12 = r11.join(r2);
	    ArrayList<String> f = new ArrayList<String>();
	    f.add("FNAME");
	    f.add("LNAME");
	    Relation r13 = r12.project(f);
	    r13.setName("ANSWER");
	    System.out.println(r13);
	}
	
}
