# UMGC-242 - Course 8 - List, Set, Map Advanced Topics & Final Project

## Section 8a: List, Sets, Maps

We already talked about lists, sets and trees. We just have one more data structure to add called Maps.
- Maps are a data structure that consist of a set of key and a value.
- Each key can exist in the map only once.
- Each key can only have one value. 

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(list);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        System.out.println(set);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "threeeeee");
        map.put(3, "three");
        System.out.println(map);
    }
}
```

## Section 8b: Hotel Project Continued...

You guys do great work but we really need some additional things
- We have a new hotel that has a 100 rooms so the system needs to support larger hotel sizes. 
- Each room will have a room type (Single, Double)
- Each hotel will consist of specific number of singles and doubles.
- We need to be able to quickly track for each hotel how many singles/doubles are available (not just the total number).
- We need to be able to search for a hotel guests room number (quickly).

## Section 8c: Project Review
- Create a database of students
- Have a UI that allow you to insert/delete/find and update a student.
- Add student grades and compute GPAs. 

## References
Online Material for this week:

https://docs.oracle.com/javase/tutorial/collections/implementations/set.html
https://docs.oracle.com/javase/tutorial/collections/implementations/map.html

Google Code Style: 
https://google.github.io/styleguide/javaguide.html

Online compile tool:
https://www.jdoodle.com/online-java-compiler-ide/

