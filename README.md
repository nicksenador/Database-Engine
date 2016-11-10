# Database-Engine
An in-memory relational database in Java

The idea of this project is to create, manipulate, and query data. It is a relational database which includes databases, relations, and tuples. Each database can include multiple Relations. Each relation has a schema that is true for all rows in the relation. The schema is composed of attributes(what the column of that relation is) and domains(the data type for each column. Each relation has tuples, which are the rows of the relation. These tuples store data for each attribute and domain combination in the relation.

Drivers
-------
Week 1 - Driver.java - Week 1 was the initial set up of the code for Database.java, Relation.java, and Tuple.java. Database.java constructs a database object with a hashmap including database names and relation objects. With this database object, we created methods to add relations, delete relations, get relations, display relations, display database schema, and return whether a relation with a given name already exists in the database or not. Relation.java constructs a relation object that has a name, attributes, and domains. Methods implemented in Relation.java were return whether or not attribute exists, return domain type of attribute, print relation schema, set name of relation, add tuple, print relation, and to string of relation. Tuple.java constructs a tuple object which includes the attribute and domains of the relation and an arraylist. Methods implemented in tuple.java were add a string component, add a double component, add a integer component, and to string of the tuple.

Week 2 - DriverW2a.java and DriverW2b.java - The goal of week 2 was to initialize a database from reading several files in a directory. Methods implemented were initialDatabase in Database.java that reads the files in the directory and creates the database, removeDuplicates in Relation.java that removes duplicate tuples from the relation, and equals in Tuple.java that tests the equality of tuples.

Week 4 - DriverW4.java - Methods implemented were Tuple.clone, Relation.member, Relation.union, Relation.intersect, and Relation.minus.

Week 6 - DriverW6.java - Methods implemented were Relation.rename, Relation.times, and Tuple.concatenate.

Week 7 - DriverW7.java - Methods implemented were Relation.project and Tuple.project.

Week 8 - DriverW8.java -  Methods implemented were Relation.select and Tuple.select.

Week 9 - DriverW9a.java and DriverW9b.java - Methods implemented were Relation.join and Tuple.join.
