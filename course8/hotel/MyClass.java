public class MyClass {
  public int myRecursiveMethod (int aVariable)  
  {  
    System.out.println(aVariable);  
    aVariable--;  
    if (aVariable == 0)  
      return 0;  
    return 1 + myRecursiveMethod(aVariable);  
  } 

  public static void main(String[] args) {
    new MyClass().myRecursiveMethod(5);
  }
}