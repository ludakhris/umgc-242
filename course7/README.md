# UMGC-242 - Course 7 - Data Structures, Generics & Java Collections Framework

## Section 7a: Data Structures

What is a data structure? 

A data structure is any complext structure that is used to hold a collection of elements. They hide from the user the "pain" of being aware how elements are added/removed, etc. They usually have a "contract" or interface" that you have to follow and some gaurantees for space and time performance of certain opertations. 

We've already seen and used the most basic version of a data structure, arrays.

However Arrays are terrible, since we have to do all the management of the elements ourselves. 

Lets create a class that called FancyList that improves how we interface with an array so it isn't so manual. 

## Section 7b: Create a FancyList
My developers heavily use arrays in pretty much all of their code. 90% of our bugs are because developers make mistakes doing "index math" and similar things. Can you please create a class that that represents a List of strings that has simple operations like add(), remove(), insert() display(), get().

## Section 7c: Create FancySet
My developers absolutely LOVE this class you've created. However in one part of our application we need a list that can never contain duplicates! 

Can you create us a class with the same operations as your List class but that prevent duplicates from being added? 

## Section 7d: Common Data Structures
- Lists
- Sets/Stacks/Queues
- Trees
- Maps

## Section 7e: Lists
A list is a linear data structure that stores a collection of elements in sequence. Very similar to arrays they typically allow operations to add/remove elemnts by index (aka any element in the list). 

A specialized version of a List, called a LinkedList instead of containing the elemnts themsevles they contain a "Node" this node has the original data element but also has a "reference" to other nodes in the list (often called the previous and next). 

The difference between the two list types are how they are implemented. Lists typically have a fixed size where linked lists never do. 


## Section 7f: Sets
A set is also a linear data structure that often doesn't allow duplicates. These data structures (unlike lists) are often stored in a LIFO (also called stacks) or FIFO (also called queues). These data structures usually have operations like "push/pop" which allow adding/removing elements. They also have concepts of "top/head/tail" which allow you to easily jump to or get the start/end of the set. 

## Section 7g: Trees
Trees are our first "nonlinear" data structure. They can be defined recursively as:

- A tree is either empty or consists of an element (called a node).
- A node contains a piece of data and any number (N) subtrees.

(draw an example)

There are lots of specialized versions of trees. One called "binary trees". We define a binary tree as:

- A binary tree is either empty or contains ONE element (called a root).
- A root contains a piece of data and two subtrees (called left and right). 

(draw an example)

## Section 7h: Generics
Java generics allow us to parameterize types and make our software more reusable. 

The general form of a generic class definition is as follows:

```java
class ClassName<T> { 
   //use T -- for example:
   //private T varName;
   //…
   public void methodName(T var) {
      //use var
      //…
   }
   //…
}
```
The general form of instantiating a generic class is as follows:
```java
ClassName<Double> doubleInstance = new ClassName<Double>();
```

## Section 7i: Generics Exercise (Time to get paid!)
My developers absolutely LOVE the List and Set classes you've created. However we really need to be able to put more into them than strings! Can you do this please! 

## Section 7j: Java Collections Framework

The Java Collections Framework provides a standardized architecture for representing and efficiently manipulating data structures. It is an assortment of related generic interfaces, generic abstract and concrete class implementations, and algorithms located in the java.util package.

All of the types we have talked about today are in the JCF. 

The JCF has this basic hierarchy: 
![JCF hierarchy](https://content.umuc.edu/file/753eb507-2559-4788-8e6a-8e7f2b250959/1/CMIS242-1109.zip/Modules/M5-Module_5/images/HierarchiesCoreInterfaceCol.gif "JCF Hierarchy")


## References
Online Material for this week:

https://learn.umuc.edu/d2l/le/content/426317/viewContent/15690302/View
https://docs.oracle.com/javase/tutorial/extra/generics/index.html
https://docs.oracle.com/javase/tutorial/collections/TOC.html
http://www.tutorialspoint.com/java/java_collections.htm

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

