package com.day01;
/**
 *	instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。
 *	instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 * 
 * */
interface A{}
class B implements A
{
 
}
class C extends B 
{
 
}

class IntanceofTest
{
 public static void main(String[] args)
 {
    A a=null;
    B b=null;
    boolean res; 
    
    System.out.println("instanceoftest test case 1: ------------------");
      res = a instanceof A; 
      System.out.println("a instanceof A: " + res);
      
      res = b instanceof B;
      System.out.println("b instanceof B: " + res);
      
    System.out.println("/ninstanceoftest test case 2: ------------------");   
    a=new B();
    b=new B();
    
    res = a instanceof A; 
    System.out.println("a instanceof A: " + res);
    
    res = a instanceof B;
    System.out.println("a instanceof B: " + res);

    res = b instanceof A;
    System.out.println("b instanceof A: " + res);
    
    res = b instanceof B;
    System.out.println("b instanceof B: " + res);
   
    System.out.println("/ninstanceoftest test case 3: ------------------");
    B b2=new C();	//父类的引用指向子类的对象，
    
    res = b2 instanceof A;
    System.out.println("b2 instanceof A: " + res);
    
    res = b2 instanceof B;
    System.out.println("b2 instanceof B: " + res);
    
    res = b2 instanceof C;
    System.out.println("b2 instanceof C: " + res);
 }
}


