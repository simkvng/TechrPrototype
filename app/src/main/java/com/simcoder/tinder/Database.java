package com.simcoder.tinder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Database {

	private static String COMMA = ",";

	public void loadDatabase(ProductList list) throws FileNotFoundException
	{
		Scanner fileReader = new Scanner(new File("database1.txt"));		
		parseDatabase(fileReader, list);
	}

	public void parseDatabase(Scanner file, ProductList pList)
	{
		String line;
		String[] lineArr = null;
		int numProducts;
		String productName, productCategory;
		String[] sections = null;
		double price;
		String[] images = null;
		double rating;
		String url;
		Product product;
		
		numProducts = file.nextInt();
		file.nextLine();
		for(int p = 0; p < numProducts; p++)
		{
			line = file.nextLine();
			lineArr = line.split(COMMA);
			productName = lineArr[0];
			productCategory = lineArr[1];
			pList.addCategory(productCategory);

			
			line = file.nextLine();
			sections = line.split(COMMA);
			for(String section : sections)
				pList.addSubcat(productCategory, section);
			
			price = file.nextDouble();
			
			file.nextLine();
			
			line = file.nextLine();
			images = line.split(COMMA);
			
			rating = file.nextDouble();
			file.nextLine();
			
			url = file.nextLine();
			
			product = new Product(productName, productCategory, sections, 
								  price, images, rating, url);
			pList.addToEnd(product);
		}
		
	}
}
