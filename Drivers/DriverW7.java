import java.util.*;

public class DriverW7 {
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

    System.out.println(r1);

    ArrayList<String> cnames1 = new ArrayList<String>();
    cnames1.add("SID");
    cnames1.add("GPA");
    Relation r2 = r1.project(cnames1);
    r2.setName("PROJECT_SID_GPA_STUDENT");
    System.out.println(r2);

    ArrayList<String> cnames2 = new ArrayList<String>();
    cnames2.add("MAJOR");
    cnames2.add("GPA");
    Relation r3 = r1.project(cnames2);
    r3.setName("PROJECT_MAJOR_GPA_STUDENT");
    System.out.println(r3);

    ArrayList<String> cnames3 = new ArrayList<String>();
    cnames3.add("MAJOR");
    Relation r4 = r1.project(cnames3);
    r4.setName("PROJECT_MAJOR_STUDENT");
    System.out.println(r4);
  }
}