package com.day01;
/**
 *	instanceof �����������������ʱָ�������Ƿ����ض����һ��ʵ����
 *	instanceofͨ������һ������ֵ��ָ������������Ƿ�������ض�����������������һ��ʵ����
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
    B b2=new C();	//���������ָ������Ķ���
    
    res = b2 instanceof A;
    System.out.println("b2 instanceof A: " + res);
    
    res = b2 instanceof B;
    System.out.println("b2 instanceof B: " + res);
    
    res = b2 instanceof C;
    System.out.println("b2 instanceof C: " + res);
 }
}


