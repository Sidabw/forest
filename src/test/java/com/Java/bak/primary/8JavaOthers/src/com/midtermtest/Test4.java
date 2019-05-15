package com.midtermtest;

public class Test4 {
	public static void main(String[] args) {
		Circle circle=new Circle(2);
		circle.show();
		
		System.out.println("=============================================");
		Cylinder cylinder=new Cylinder(2,2);
		cylinder.show();
		
	}

}
class Circle
{
	private double radius;
	public Circle() {
		// TODO Auto-generated constructor stub
		radius=0;
	}
	public Circle(double radius)
	{
		this.radius=radius;
	}
	public double gerArea()
	{
		return 3.14*radius*radius;
	}
	public double getPerimeter()
	{
		return 2*3.14*radius;
	}
	public void show()
	{
		System.out.println("此圆的半径是"+radius);
		System.out.println("此圆的周长是"+this.getPerimeter());
		System.out.println("此圆的面积是"+this.gerArea());
	}
	
}
class Cylinder extends Circle
{
	private double high;
	public Cylinder()
	{
		super();
	}
	public Cylinder(double radius,double high)
	{
		super(radius);
		this.high=high;
	}
	public double getVolume()
	{
		return super.gerArea()*high;
	}
	public void show()
	{
		System.out.println("此圆柱体的体积是："+this.getVolume());
	}
	
}
