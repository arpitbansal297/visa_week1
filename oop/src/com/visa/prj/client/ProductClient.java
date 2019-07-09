package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.TV;

public class ProductClient {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Product[] products = new Product[4]; // Array of 4 pointers
		products[0] = new TV(133,"Sony Bravia",135000.00,"LED");
		products[1] = new Mobile(453,"MotoG",12999.00,"4G");
		products[2] = new TV(634,"Onida Thunder",3500.00,"CRT");
		products[3] = new Mobile(621,"iPhone XR",99999.00,"4G");
		
		printExpensive(products);
		printInfo(products);
		printInfoOCP(products);

	}

	/*
	 * Print details usinnnnng open to extension , closed for change
	 * Done using Reflection APIs
	 * @param products
	 */
	
	
	private static void printInfoOCP(Product[] products) 
	{
		for (Product p : products) 
		{
			Class clazz = p.getClass();
			
			Method[] methods = clazz.getMethods();
			
			for(Method m: methods)
			{
				if(m.getName().startsWith("get"))
				{
					try
					{
						Object ret = m.invoke(p);
						System.out.println(ret);
						
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
			System.out.println("*************");
			
		}
		
	}

	private static void printInfo(Product[] products) 
	{
		for (Product p: products) 
		{
			
			System.out.println(p.getName() + " : "  + p.getPrice());
			
			if(p instanceof TV)
			{
				TV t = (TV) p;
				System.out.println(t.getScreenType());
			}
			
			if(p.getClass() == Mobile.class)
			{
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
						
			}
			
			
			
		}
		
	}

	private static void printExpensive(Product[] products) 
	{
		for (Product product : products) 
		{
			if(product.isExpensive())
			{
				System.out.println(product.getName() + " is expensive !!!");
			}
		}
		
	}

}
