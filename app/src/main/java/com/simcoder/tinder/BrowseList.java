package com.simcoder.tinder;
import java.util.ArrayList;

public class BrowseList extends ProductList {
	
	public void setBrowseList(ArrayList<Product> productList)
	{
		list = productList;
	}

	public void displayProducts() 
	{
		for (int i = 0; i < list.size(); i++) {
			Product currProd = list.get(i);
			System.out.println((i+1) + ". " + currProd.getName());
		}
	}

}
