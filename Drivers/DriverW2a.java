import java.util.*;

public class DriverW2a {
  public static void main(String args[]) {
    Database db = new Database();
    db.initializeDatabase(args[0]);
    db.displaySchema();
    Relation r1 = db.getRelation("BAR");
    System.out.println(r1);
    Relation r2 = db.getRelation("DRINKER");
    System.out.println(r2);
    Relation r3 = db.getRelation("SELLS");
    System.out.println(r3);
  }
  
}