package com.BasicPrograms;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) 
	{

		// List<dataType>ArrayName = new ArrayList<>();
		
		List<String>a = new ArrayList<>();
		
		a.add("Selenium");
		a.add("Loadrunner");
		a.add("QTP");
		a.add("Jmeter");
		
		/*for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}*/
		
		for(Object index:a)
		{
			System.out.println(index);
		}
			
		
		

	}

}
