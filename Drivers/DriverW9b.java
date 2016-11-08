import java.util.*;

public class DriverW9b {
  public static void main(String args[]) {
    Database db = new Database();
    ArrayList<String> attr1 = new ArrayList<String>();
    attr1.add("SID");
    attr1.add("SNAME");
    attr1.add("PHONE");
    attr1.add("MAJOR");
    attr1.add("GPA");
    ArrayList<String> dom1 = new ArrayList<String>();
    dom1.add("INTEGER");
    dom1.add("VARCHAR");
    dom1.add("INTEGER");
    dom1.add("VARCHAR");
    dom1.add("DECIMAL");
    Relation r1 = new Relation("REL1",attr1,dom1);
    Tuple t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1111);
    t.addStringComponent("Robert Adams");
    t.addIntegerComponent(1234);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(4.0);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    t.addIntegerComponent(5656);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1113);
    t.addStringComponent("David Beatle");
    t.addIntegerComponent(1212);
    t.addStringComponent("Mathematics");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);
    t = new Tuple(attr1,dom1);
    t.addIntegerComponent(1114);
    t.addStringComponent("Graham Gooch");
    t.addIntegerComponent(5678);
    t.addStringComponent("Computer Science");
    t.addDoubleComponent(3.5);
    r1.addTuple(t);

    db.addRelation("STUDENT",r1);

    ArrayList<String> attr2 = new ArrayList<String>();
    attr2.add("SID");
    attr2.add("COURSE");
    attr2.add("GRADE");
    ArrayList<String> dom2 = new ArrayList<String>();
    dom2.add("INTEGER");
    dom2.add("VARCHAR");
    dom2.add("VARCHAR");
    Relation r2 = new Relation("REL2",attr2,dom2);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1111);
    t.addStringComponent("Csc 4710");
    t.addStringComponent("A");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1114);
    t.addStringComponent("Csc 2310");
    t.addStringComponent("B");
    r2.addTuple(t);
    t = new Tuple(attr2,dom2);
    t.addIntegerComponent(1114);
    t.addStringComponent("Csc 2310");
    t.addStringComponent("A");
    r2.addTuple(t);

    db.addRelation("ENROLL",r2);

    ArrayList<String> attr3 = new ArrayList<String>();
    attr3.add("COURSE");
    attr3.add("TITLE");
    attr3.add("CREDITS");
    ArrayList<String> dom3 = new ArrayList<String>();
    dom3.add("VARCHAR");
    dom3.add("VARCHAR");
    dom3.add("INTEGER");
    Relation r3 = new Relation("REL3",attr3,dom3);
    t = new Tuple(attr3,dom3);
    t.addStringComponent("Csc 4710");
    t.addStringComponent("Database Systems");
    t.addIntegerComponent(4);
    r3.addTuple(t);
    t = new Tuple(attr3,dom3);
    t.addStringComponent("Csc 2010");
    t.addStringComponent("Java I");
    t.addIntegerComponent(3);
    r3.addTuple(t);
    t = new Tuple(attr3,dom3);
    t.addStringComponent("CSc 2310");
    t.addStringComponent("Java II");
    t.addIntegerComponent(3);
    r3.addTuple(t);

    db.addRelation("COURSES",r3);

    System.out.println(r1);
    System.out.println(r2);
    System.out.println(r3);

    // Lets formulate a query to list names of students who got "A" in course titled "Database Systems"
    Relation t1 = r2.select("col","GRADE","=","str","A");
    Relation t2 = r3.select("col","TITLE","=","str","Database Systems");
    Relation t3 = r1.join(t1).join(t2);
    ArrayList<String> attr = new ArrayList<String>();
    attr.add("SNAME");
    Relation result = t3.project(attr);
    result.setName("ANSWER");
    
    System.out.println(result);
  }
}