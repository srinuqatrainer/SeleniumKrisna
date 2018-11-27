package com.BasicPrograms;

public class ObjectArray {

	public static void main(String[] args)
	{
		
		// object ArrayName[] = new object[size];
		
		Object  a[] = new Object[3];
		
		a[0] = "Krishna";
		a[1] = 10;
		a[2] = 12.3456;
		
		// for each loop
		
		for(Object idx:a)
		{
			System.out.println(idx);
		}

	}

}
