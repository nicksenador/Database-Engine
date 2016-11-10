import java.io.*;
import java.util.*;

public class Database {

  private Map<String,Relation> relations;

  // METHODS

  // Constructor; creates the empty HashMap object
  public Database() {
	  relations=new HashMap<String,Relation>();
  }

  // Add relation r with name rname to HashMap
  // if relation does not already exists.
  // Make sure to set the name within r to rname.
  // return true on successful add; false otherwise
  public boolean addRelation(String rname, Relation r) {
	  if (relations.containsValue(rname)){
		  return false;
	  } else {
		  relations.put(rname,r);
		  return true;
	  }
  }

  // Delete relation with name rname from HashMap
  // if relation exists. return true on successful delete; false otherwise
  public boolean deleteRelation(String rname) {
	  if (relations.containsValue(rname)) {
		  relations.remove(rname);
		  return true;
	  } else {
		  return false;
	  }
  }

  // Return true if relation with name rname exists in HashMap
  // false otherwise
  public boolean relationExists(String rname) {
	  if (relations.containsValue(rname)) {
		  return true;
	  } else {
		  return false;
	  }
  }

  // Retrieve and return relation with name rname from HashMap;
  // return null if it does not exist.
  public Relation getRelation (String rname) {
	  return relations.get(rname);
  }

  // Print database schema to screen.
  public void displaySchema() {
	  System.out.println("Database Schema");
	  System.out.println("-------- ------");
	  System.out.println();
	  for (Map.Entry<String, Relation> entry : relations.entrySet()) {
		  Relation r = entry.getValue();
		  r.displaySchema();
	  }
	  System.out.println();
  }

  //Create the database object by reading data from several files in directory dir
  public void initializeDatabase(String dir) {
	FileInputStream fin1, fin2 = null;
	BufferedReader infile1, infile2 = null;
	try {
		fin1 = new FileInputStream(dir + "/catalog.dat");
		infile1 = new BufferedReader(new InputStreamReader(fin1));
		String s = infile1.readLine();
		int num = Integer.parseInt(s);
		for (int i = 1; i <= num;  i++){
			String name = infile1.readLine();
			String t = infile1.readLine();
			int numAttr = Integer.parseInt(t);
			ArrayList<String> attr = new ArrayList<String>();
			ArrayList<String> dom = new ArrayList<String>();
			for (int j = 1; j <= numAttr; j++){
				String attrName = infile1.readLine();
				String attrDom = infile1.readLine();
				attr.add(attrName);
				dom.add(attrDom);
			}
			Relation r = new Relation(name,attr,dom);
			try {
				fin2 = new FileInputStream(dir + "/" + name + ".dat");
				infile2 = new BufferedReader(new InputStreamReader(fin2));
				String a = infile2.readLine();
				int numTups = Integer.parseInt(a);
				for (int k = 1; k <= numTups; k++){
					Tuple tt = new Tuple(attr,dom);
					for (int l = 0; l < dom.size(); l++){
						String b = infile2.readLine();
						if (dom.get(l).equals("VARCHAR")){
							tt.addStringComponent(b);
						}	
						else if (dom.get(l).equals("DECIMAL")){
							tt.addDoubleComponent(Double.parseDouble(b));
						}	
						else {
							tt.addIntegerComponent(Integer.parseInt(b));
						}	
					}
					r.addTuple(tt);
				}
				fin2.close();
				addRelation(name,r);
			} catch (IOException e) {
				System.out.println("Error reading file");
			}
		} fin1.close();
	} catch (IOException e) {
		System.out.println("Error reading file");
	}
  }
}