package com.simcoder.tinder;
import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<String> subcategories = new ArrayList<>();
	
	public Category(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(ArrayList<String> subcategories) {
		this.subcategories = subcategories;
	}
	
	public void displaySubcategories(String category, ProductList pList)
	{
		int i = 1;
		Category cat = pList.getCategory(category);
		for(String sub : cat.getSubcategories())
		{
			System.out.println(i + ". " + sub);
			i++;
		}
	}
	
	public void addSub(String section)
	{
		if(!containsSub(section))
			subcategories.add(section);
	}
	
	protected boolean containsSub(String subcategoryName)
	{
		for(String subcategory : subcategories)
			if(subcategory.equals(subcategoryName))
				return true;
		return false;
	}
	
}
