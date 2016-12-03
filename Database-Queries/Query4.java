import java.util.*;

public class Query4 {

	public static void main(String args[]) {
	    Database db = new Database();
	    db.initializeDatabase(args[0]);
	    
	    System.out.println("Query 4: Make a list of project numbers for projects that involve an employee whose last name is \"Smith\", either as a worker or as a manager of the department that controls the project.");
	    System.out.println("----- -");
	    
	    Relation r00 = db.getRelation("WORKS_ON");
	    Relation r0 = db.getRelation("PROJECTS");
	    Relation r1  = db.getRelation("EMPLOYEE");
	    Relation r2 = db.getRelation("DEPARTMENT");
	    ArrayList<String> a = new ArrayList<String>();
	    a.add("DNAME");
	    a.add("DNUMBER");
	    a.add("SSN");
	    a.add("MGRSTARTDATE");
	    Relation r3 = r2.rename(a);
	    Relation r4 = r1.join(r3);
	    Relation r5 = r4.select("col", "LNAME", "=", "str", "Smith");
	    ArrayList<String> b = new ArrayList<>();
	    b.add("DNUMBER");
	    Relation r6 = r5.project(b);
	    ArrayList<String> c = new ArrayList<String>();
	    c.add("DNUM");
	    Relation r7 = r6.rename(c);
	    Relation r8 = r7.join(r0);
	    ArrayList<String> d = new ArrayList<String>();
	    d.add("PNUMBER");
	    Relation r9 = r8.project(d);
	    Relation r10 = r1.select("col", "LNAME", "=", "str", "Smith");
	    ArrayList<String> e = new ArrayList<String>();
	    e.add("SSN");
	    Relation r11 = r10.project(e);
	    ArrayList<String> f = new ArrayList<String>();
	    f.add("ESSN");
	    Relation r12 = r11.rename(f);
	    Relation r13 = r12.join(r00);
	    Relation r14 = r13.union(r9);
	    ArrayList<String> g = new ArrayList<String>();
	    g.add("PNO");
	    Relation r15 = r14.project(g);
	    r15.setName("ANSWER");
	    System.out.println(r15);
	}
	
}
