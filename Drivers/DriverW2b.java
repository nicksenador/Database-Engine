import java.util.*;

public class DriverW2b {
  public static void main(String args[]) {
    Database db = new Database();
    ArrayList<String> attr = new ArrayList<String>();
    attr.add("SID");
    attr.add("SNAME");

    ArrayList<String> dom = new ArrayList<String>();
    dom.add("INTEGER");
    dom.add("VARCHAR");

    Relation r = new Relation("STUDENT",attr,dom);

    Tuple t = new Tuple(attr,dom);
    t.addIntegerComponent(1111);
    t.addStringComponent("Robert Adams");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1113);
    t.addStringComponent("Donald James");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1112);
    t.addStringComponent("Charles Bailey");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1114);
    t.addStringComponent("Michael James");
    r.addTuple(t);

    t = new Tuple(attr,dom);
    t.addIntegerComponent(1113);
    t.addStringComponent("Donald James");
    r.addTuple(t);

    db.addRelation("STUDENT",r);

    System.out.println("Before Removing Duplicates: \n"+r);
    r.removeDuplicates();
    System.out.println("After Removing Duplicates: \n"+r);
  }
}