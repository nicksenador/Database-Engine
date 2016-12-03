import java.util.*;

public class Query3 {
	public static void main(String args[]) {
	   Database db = new Database();
	   db.initializeDatabase(args[0]);
	    
	   System.out.println("Query 3: Find the names of employees who work on all the projects controlled by department number 5.");
	   System.out.println("----- -");
	   
	   Relation r1 = db.getRelation("PROJECTS");
	   Relation r2 = db.getRelation("EMPLOYEE");
	   Relation r3 = db.getRelation("WORKS_ON");
	   Relation r4 = r1.select("col", "DNUM", "=", "num", "5");
	   ArrayList<String> a = new ArrayList<String>();
	   a.add("PNUMBER");
	   Relation r5 = r4.project(a);
	   ArrayList<String> b = new ArrayList<String>();
	   b.add("SSN");
	   Relation r6 = r2.project(b);
	   Relation r7 = r6.times(r5);
	   ArrayList<String> c = new ArrayList<String>();
	   c.add("ESSN");
	   c.add("PNO");
	   Relation r8 = r3.project(c);
	   ArrayList<String> d = new ArrayList<String>();
	   d.add("SSN");
	   d.add("PNUMBER");
	   Relation r9 = r8.rename(d);
	   Relation r10 = r7.minus(r9);
	   Relation r11 = r10.project(b);
	   Relation r12 = r2.project(b);
	   Relation r13 = r12.minus(r11);
	   Relation r14 = r2.join(r13);
	   ArrayList<String> e = new ArrayList<String>();
	   e.add("LNAME");
	   e.add("FNAME");
	   Relation r15 = r14.project(e);
	   r15.setName("ANSWER");
	   System.out.println(r15);
	   
	}

}
