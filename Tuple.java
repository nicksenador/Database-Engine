import java.util.ArrayList;

public class Tuple {

  private ArrayList<String> attributes;
  private ArrayList<String> domains;
  private ArrayList<Comparable> tuple;

  // METHODS
  
  // Constructor; set instance variables
  public Tuple (ArrayList<String> attr, ArrayList<String> dom) {
	  attributes=attr;
	  domains=dom;
	  tuple = new ArrayList<Comparable>();
  }

  // Add String s at the end of the tuple
  public void addStringComponent(String s) {
	  tuple.add(s);
  }

  // Add Double d at the end of the tuple
  public void addDoubleComponent(Double d) {
	  tuple.add(d);
  }

  // Add Integer i at the end of the tuple
  public void addIntegerComponent(Integer i) {
	  tuple.add(i);
  }

  // return String representation of tuple; See output of run for format.
  public String toString() {
	  String s = "";
	  for (int i=0; i<tuple.size(); i++) {
		  Comparable x=tuple.get(i);
		  s=s+x+":";
	  }
	  return s;
  }

  //Return true if this tuple is equal to compareTuple; false otherwise
  public boolean equals(Tuple compareTuple) {
	  for (int i = 0; i < tuple.size(); i++){
		  if(this.tuple.get(i).toString().compareTo(compareTuple.tuple.get(i).toString()) != 0){
			  return false;
		  }
	  }
	  return true;
  } 
  
  public Tuple clone(ArrayList<String> attr){
	  Tuple clone = new Tuple(attr, domains);
	  for (int i = 0; i < tuple.size(); i++){
		  if (domains.get(i).equals("INTEGER")){
			  int x = new Integer((Integer) Integer.parseInt(tuple.get(i).toString()));
			  clone.addIntegerComponent(x);
		  } else if (domains.get(i).equals("VARCHAR")){
			  String y = new String((String) tuple.get(i).toString());
			  clone.addStringComponent(y);
		  } else {
			  Double z = new Double((Double) Double.parseDouble(tuple.get(i).toString()));
			  clone.addDoubleComponent(z);
		  }
	  }
	  return clone;
  }

  public Tuple concatenate(Tuple t2, ArrayList<String> attrs, ArrayList<String> doms) {
	  Tuple con = new Tuple(attrs, doms);
	  for (int i = 0; i < this.tuple.size(); i ++){
		  if (doms.get(i).equals("INTEGER")) {
			  int x = new Integer((Integer) Integer.parseInt(this.tuple.get(i).toString()));
			  con.addIntegerComponent(x);
		  } else if (domains.get(i).equals("VARCHAR")) {
			  String y = new String((String) this.tuple.get(i).toString());
			  con.addStringComponent(y);
		  } else {
			  Double z = new Double((Double) Double.parseDouble(this.tuple.get(i).toString()));
			  con.addDoubleComponent(z);
		  }
	  }
	  for (int i = 0; i < t2.tuple.size(); i++) {
		  if (doms.get(i).equals("INTEGER")) {
			  int x = new Integer((Integer) Integer.parseInt(t2.tuple.get(i).toString()));
			  con.addIntegerComponent(x);
		  } else if (domains.get(i).equals("VARCHAR")) {
			  String y = new String((String) t2.tuple.get(i).toString());
			  con.addStringComponent(y);
		  } else {
			  Double z = new Double((Double) Double.parseDouble(t2.tuple.get(i).toString()));
			  con.addDoubleComponent(z);
		  }
	  }
	  return con;
  }
  
  public Tuple project(ArrayList<String> cnames) {
	  ArrayList<String> doms = new ArrayList<String>();
	  for (int i = 0; i < cnames.size(); i ++){
		  doms.add(this.domains.get(this.attributes.indexOf(cnames.get(i))));
	  }
	  Tuple tup = new Tuple(cnames, doms);
	  for (int i = 0; i < cnames.size(); i ++) {
		  if (doms.get(i).equals("INTEGER")) {
			  int x = new Integer((Integer)this.tuple.get(this.attributes.indexOf(cnames.get(i))));
			  tup.addIntegerComponent(x);
		  } else if (doms.get(i).equals("VARCHAR")){
			  String y = new String((String)this.tuple.get(this.attributes.indexOf(cnames.get(i))));
			  tup.addStringComponent(y);
		  } else {
			  Double z = new Double((Double)this.tuple.get(this.attributes.indexOf(cnames.get(i))));
			  tup.addDoubleComponent(z);
		  }
	  }
	  return tup;
  }
  
  public boolean select(String lopType, String lopValue, String comparison, String ropType, String ropValue) {
	  if (lopType.equals("num") && ropType.equals("num")) {
		  double x = Double.parseDouble(ropValue);
		  double y = Double.parseDouble(lopValue);
		  if (comparison.equals("<")) {
			  return x<y;
		  } else if (comparison.equals("<=")) {
			  return y<=x;
		  } else if (comparison.equals("=")) {
			  return y==x;
		  } else if (comparison.equals(">")) {
			  return y>x;
		  } else if (comparison.equals(">=")) {
			  return y>=x;
		  } else if (comparison.equals("<>")) {
			  return y!=x;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("str") && ropType.equals("str")) {
		  String x = ropValue;
		  String y = lopValue;
		  if (comparison.equals("<")) {
			  return y.compareTo(x) < 0;
		  } else if (comparison.equals("<=")) {
			  return y.compareTo(x) < 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("=")) {
			  return y.compareTo(x) == 0;
		  } else if (comparison.equals(">")) {
			  return y.compareTo(x) > 0;
		  } else if (comparison.equals(">=")) {
			  return y.compareTo(x) > 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("<>")) {
			  return y.compareTo(x) != 0;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("col") && ropType.equals("num")) {
		  double x = Double.parseDouble(ropValue);
		  double y = Double.parseDouble(this.tuple.get(attributes.indexOf(lopValue)).toString());
		  if (comparison.equals("<")) {
			  return y<x;
		  } else if (comparison.equals("<=")) {
			  return y<=x;
		  } else if (comparison.equals("=")) {
			  return y==x;
		  } else if (comparison.equals(">")) {
			  return y>x;
		  } else if (comparison.equals(">=")) {
			  return y>=x;
		  } else if (comparison.equals("<>")) {
			  return y!=x;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("col") && ropType.equals("str")) {
		  String x = ropValue;
		  String y = this.tuple.get(attributes.indexOf(lopValue)).toString();
		  if (comparison.equals("<")) {
			  return y.compareTo(x) < 0;
		  } else if (comparison.equals("<=")) {
			  return y.compareTo(x) < 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("=")) {
			  return y.compareTo(x) == 0;
		  } else if (comparison.equals(">")) {
			  return y.compareTo(x) > 0;
		  } else if (comparison.equals(">=")) {
			  return y.compareTo(x) > 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("<>")) {
			  return y.compareTo(x) != 0;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("num") && ropType.equals("col")) {
		  double y = Double.parseDouble(ropValue);
		  double x = Double.parseDouble(this.tuple.get(attributes.indexOf(lopValue)).toString());
		  if (comparison.equals("<")) {
			  return y<x;
		  } else if (comparison.equals("<=")) {
			  return y<=x;
		  } else if (comparison.equals("=")) {
			  return y==x;
		  } else if (comparison.equals(">")) {
			  return y>x;
		  } else if (comparison.equals(">=")) {
			  return y>=x;
		  } else if (comparison.equals("<>")) {
			  return y!=x;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("str") && ropType.equals("col")) {
		  String y = ropValue;
		  String x = this.tuple.get(attributes.indexOf(lopValue)).toString();
		  if (comparison.equals("<")) {
			  return y.compareTo(x) < 0;
		  } else if (comparison.equals("<=")) {
			  return y.compareTo(x) < 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("=")) {
			  return y.compareTo(x) == 0;
		  } else if (comparison.equals(">")) {
			  return y.compareTo(x) > 0;
		  } else if (comparison.equals(">=")) {
			  return y.compareTo(x) > 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("<>")) {
			  return y.compareTo(x) != 0;
		  } else {
			  return false;
		  }
	  } else if (lopType.equals("col") && ropType.equals("col")) {
		  String x = this.tuple.get(attributes.indexOf(ropValue)).toString();
		  String y = this.tuple.get(attributes.indexOf(lopValue)).toString();
		  if (comparison.equals("<")) {
			  return y.compareTo(x) < 0;
		  } else if (comparison.equals("<=")) {
			  return y.compareTo(x) < 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("=")) {
			  return y.compareTo(x) == 0;
		  } else if (comparison.equals(">")) {
			  return y.compareTo(x) > 0;
		  } else if (comparison.equals(">=")) {
			  return y.compareTo(x) > 0 || y.compareTo(x) == 0;
		  } else if (comparison.equals("<>")) {
			  return y.compareTo(x) != 0;
		  } else {
			  return false;
		  }
	  } else {
		  return false;
	  }
	  
  }
  
  public Tuple join(Tuple t2, ArrayList attr, ArrayList dom) {
	  ArrayList<Integer> leftJoinColumns = new ArrayList<Integer>();
	  ArrayList<String> leftJoinDomains = new ArrayList<String>();
	  ArrayList<Integer> rightJoinColumns = new ArrayList<Integer>();
	  ArrayList<String> rightJoinDomains = new ArrayList<String>();
	  Tuple join = new Tuple(attr, dom);
	  for (int i = 0; i < this.attributes.size(); i++) {
		 if (t2.attributes.contains(this.attributes.get(i))) {
			 leftJoinColumns.add(i);
			 leftJoinDomains.add(this.domains.get(i));
		 }
	  }
	  for (int i = 0; i < t2.attributes.size(); i++) {
		 if (this.attributes.contains(t2.attributes.get(i))) {
			 rightJoinColumns.add(i);
			 rightJoinDomains.add(t2.domains.get(i));
		 }
	  }
	
	  ArrayList<Comparable> left = new ArrayList<Comparable>();
	  for (int i = 0; i < leftJoinColumns.size(); i ++) {
		  left.add(this.tuple.get(leftJoinColumns.get(i)));
	  }
	  ArrayList<Comparable> right = new ArrayList<Comparable>();
	  for (int i = 0; i < rightJoinColumns.size(); i ++) {
		  right.add(t2.tuple.get(rightJoinColumns.get(i)));
	  }
	  
	  for (int i = 0; i < left.size(); i++) {
		   if (left.get(i).compareTo(right.get(i)) != 0)
		     return null;
	  }
	  
	  for (int i = 0; i < this.tuple.size(); i ++) {
		  if (this.domains.get(i).equals("INTEGER")){
			  int x = new Integer((Integer) this.tuple.get(i));
			  join.addIntegerComponent(x);
		  } else if (this.domains.get(i).equals("VARCHAR")){
			  String y = new String((String) this.tuple.get(i));
			  join.addStringComponent(y);
		  } else {
			  Double z = new Double((Double) this.tuple.get(i));
			  join.addDoubleComponent(z);
		  }
	  }
	  for (int i = 0; i < t2.tuple.size(); i ++) {
		  if (!rightJoinColumns.contains(i)) {
			  if (t2.domains.get(i).equals("INTEGER")){
				  int x = new Integer((Integer) t2.tuple.get(i));
				  join.addIntegerComponent(x);
			  } else if (t2.domains.get(i).equals("VARCHAR")){
				  String y = new String((String) t2.tuple.get(i));
				  join.addStringComponent(y);
			  } else {
				  Double z = new Double((Double) t2.tuple.get(i));
				  join.addDoubleComponent(z);
			  }
		  }
	  }
	  return join;
  }
  
}