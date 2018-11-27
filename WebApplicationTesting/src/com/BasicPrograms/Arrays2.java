package com.BasicPrograms;

public class Arrays2 {

	public static void main(String[] args)
	{

		/*dataType ArrayName[][] = new dataType[size][size]
		dataType [][]ArrayName = new dataType[size][size]*/
		
		String a[][] = new String[2][2];
		
		a[0][0] = "Krishna";
		a[0][1] = "Hello";
		
		a[1][0] = "Chaitanya";
		a[1][1] = "Hii";
		
				
		//System.out.println(a[0][1]);
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}

	}

}
