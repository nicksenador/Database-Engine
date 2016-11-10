import java.io.*;
import java.util.*;

public class Relation {
  // Name of the relation.
  private String name;
  
  // Attribute names for the relation
  private ArrayList<String> attributes;

  // Domain classes or types of attributes; possible values: INTEGER, DECIMAL, VARCHAR
  private ArrayList<String> domains;

  // Actual data storage (list of tuples) for the relation.
  private ArrayList<Tuple> table;

  // METHODS

  // Constructor; set instance variables
  public Relation (String name, ArrayList<String> attributes, ArrayList<String> dNames) {
	  this.name=name;
	  this.attributes=attributes;
	  domains=dNames;
	  table=new ArrayList<Tuple>();
  }

  // returns true if attribute with name aname exists in relation schema
  // false otherwise
  public boolean attributeExists(String aname) {
	  //this is not used yet
	  return false;
  }

  // returns domain type of attribute aname; return null if not present
  public String attributeType(String aname) {
	  //this is not used yet
	  String s="";
	  return s;
  }

  // Print relational schema to screen.
  public void displaySchema() {
	  System.out.print(name + "(");
	  System.out.print(attributes.get(0) + ":" + domains.get(0));
	  for (int i=1; i<attributes.size(); i++) {
		  System.out.print("," + attributes.get(i) + ":" + domains.get(i));
	  }
	  System.out.println(")");
  }

  // Set name of relation to rname
  public void setName(String rname) {
	  name=rname;
  }

  // Add tuple tup to relation; Duplicates are fine.
  public void addTuple(Tuple tup) {
	  table.add(tup);
  }

  // Print relation to screen (see output of run for formatting)
  public void displayRelation() {
	  System.out.print(name + "(");
	  System.out.print(attributes.get(0) + ":" + domains.get(0));
	  for (int i=1; i<attributes.size(); i++) {
		  System.out.print("," + attributes.get(i) + ":" + domains.get(i));
	  }
	  System.out.println(")");
	  System.out.println("Number of tuples: " + table.size());
	  System.out.println();
	  for (int i=0; i<table.size(); i++) {
		  Tuple t=table.get(i);
		  System.out.println(t);
	  }
	  System.out.println();
  }

  // Return String version of relation; See output of run for format.
  public String toString() {
	  System.out.print(name + "(");
	  System.out.print(attributes.get(0) + ":" + domains.get(0));
	  for (int i=1; i<attributes.size(); i++) {
		  System.out.print("," + attributes.get(i) + ":" + domains.get(i));
	  }
	  System.out.println(")");
	  System.out.println("Number of tuples: " + table.size());
	  System.out.println();
	  String s = "";
	  for (int i=0; i<table.size(); i++) {
		  Tuple t=table.get(i);
		  s = s + t + "\n";
	  }
	  return s;
  }
  
  //Remove duplicate tuples from this relation
  public void removeDuplicates() {
	  for (int i = 0; i < table.size(); i++ ){
		for (int j = i + 1;j < table.size(); j++){
			if (table.get(i).equals(table.get(j))){
				table.remove(i);
				j--;
			}
		  }
	  }
  }
  
  public boolean member(Tuple t){
	  for (int i = 0; i < table.size(); i++){
		  if (table.get(i).equals(t)){
			  return true;
		  }
	  }
	  return false;
  }
  
  public Relation union(Relation r2){
	  ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  attrs.addAll(this.attributes);
	  doms.addAll(this.domains);
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i++){
		  Tuple t = this.table.get(i).clone(attrs);
		  rel.addTuple(t);
	  }
	  for (int i = 0; i < r2.table.size(); i++){
		  Tuple s = r2.table.get(i).clone(attrs);
		  rel.addTuple(s);
	  }
	  rel.removeDuplicates();
	  return rel;
  }
  
  public Relation intersect(Relation r2) {
	  /*ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  attrs.addAll(this.attributes);
	  doms.addAll(this.domains);
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i++) {
		  if (r2.member(this.table.get(i))) {
			  Tuple t = this.table.get(i).clone(attrs);
			  rel.addTuple(t);
		  }
	  }
	  return rel; */
	  Relation rel = minus(r2);
	  return minus(rel);
  }
  
  public Relation minus(Relation r2) {
	  ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  attrs.addAll(this.attributes);
	  doms.addAll(this.domains);
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i++) {
		  if (!r2.member(this.table.get(i))) {
			  Tuple t = this.table.get(i).clone(attrs);
			  rel.addTuple(t);
		  }
	  }
	  return rel;
  }
  
  public Relation rename(ArrayList<String> cnames) {
	  ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  attrs.addAll(cnames);
	  doms.addAll(this.domains);
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i ++) {
		  rel.addTuple(this.table.get(i).clone(attrs));
	  }
	  return rel;
  }
  
  public Relation times(Relation r2) {
	  ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  for (int i = 0; i < this.attributes.size(); i ++) {
		  if (r2.attributes.contains(this.attributes.get(i))) {
			  attrs.add("r1." + this.attributes.get(i));
			  doms.add(this.domains.get(i));
		  } else {
			  attrs.add(this.attributes.get(i));
			  doms.add(this.domains.get(i));
		  }
	  }
	  for (int i = 0; i < r2.attributes.size(); i ++) {
		  if (this.attributes.contains(r2.attributes.get(i))) {
			  attrs.add("r2." + r2.attributes.get(i));
			  doms.add(r2.domains.get(i));
		  } else {
			  attrs.add(r2.attributes.get(i));
			  doms.add(r2.domains.get(i));
		  }
	  }
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i ++) {
		  for (int j = 0; j < r2.table.size(); j ++) {
			  rel.addTuple(this.table.get(i).concatenate(r2.table.get(j), attrs, doms));
		  }
	  }
	  return rel;
  }
  
  public Relation project(ArrayList<String> cnames) {
	  ArrayList<String> attrs = new ArrayList<String>();
	  ArrayList<String> doms = new ArrayList<String>();
	  for (int i = 0; i < cnames.size(); i ++) {
		  attrs.add(cnames.get(i));
		  doms.add(this.domains.get(this.attributes.indexOf(cnames.get(i))));
	  }
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i ++) {
		  rel.table.add(this.table.get(i).clone(this.attributes).project(cnames));
	  }
	  rel.removeDuplicates();
	  return rel;
  }
  
  public Relation select(String lopType, String lopValue, String comparison, String ropType, String ropValue) {
	  ArrayList<String> attrs = this.attributes;
	  ArrayList<String> doms = this.domains;
	  Relation rel = new Relation(null, attrs, doms);
	  for (int i = 0; i < this.table.size(); i ++) {
		  Tuple t = this.table.get(i);
		  if (t.select(lopType, lopValue, comparison, ropType, ropValue)) {
			  rel.addTuple(t.clone(this.attributes));
		  }
	  }
	  return rel;
  }
  
  public Relation join(Relation r2) {
	  ArrayList<String> attr = new ArrayList<String>();
	  ArrayList<String> dom = new ArrayList<String>();
	  attr.addAll(this.attributes);
	  dom.addAll(this.domains);
	  for (int i = 0; i < r2.attributes.size(); i ++) {
		  if(!this.attributes.contains(r2.attributes.get(i))) {
			  attr.add(r2.attributes.get(i));
			  dom.add(r2.domains.get(i));
		  }
	  }
	  Relation rel = new Relation(null, attr, dom);
	  for (int i = 0; i < this.table.size(); i++) {
		  for (int j = 0; j < r2.table.size(); j++) {
			  Tuple t1 = this.table.get(i).clone(this.attributes);
			  Tuple t2 = r2.table.get(j).clone(r2.attributes);
			  if (t1.join(t2, attr, dom) != null) {
				  rel.addTuple(t1.join(t2, attr, dom));
			  }
		  }
	  }
	  return rel;
  }
  
}