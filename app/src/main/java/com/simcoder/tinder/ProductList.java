package com.simcoder.tinder;
import java.util.ArrayList;

public class ProductList {

	protected ArrayList<Product> list = new ArrayList<>();
	protected ArrayList<Category> categories = new ArrayList<>();
	
	ProductList()
	{

	}

	public ArrayList<String> getSubcategories() {
		ArrayList<String> subcategories = new ArrayList<>();
		for(Category category : categories)
		{
			for(String subCategory : category.getSubcategories())
			{
				subcategories.add(subCategory);
			}
		}
		return subcategories;
	}
	
	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	public void addToEnd(Product prod) //favorites
	{
		list.add(prod);
	}
	
	public void addToFront(Product prod) //discarded
	{
		list.add(0, prod);
	}
	public void removeAt(int index)
	{
		list.remove(index);
	}
	public void clearList()
	{
		list.clear();
	}
	public void sendToOtherList(int index, ArrayList <Product> list)
	{
		Product p = this.list.get(index);
		list.add(p);
	}
	public Category chooseCategory(int index)
	{
		return categories.get(index-1);
	}

	public void removeProduct(Product prod)
	{
		list.remove(prod);
	}
	public void displayCategories()
	{
		System.out.println("Categories");
		for(int i = 0; i < categories.size(); i++)
			System.out.println((i+1) + ". " + categories.get(i).getName());
	}
	public void displayProducts()
	{
		for(int i = 0; i < list.size(); i++)
		{
			Product currProd = list.get(i);
			System.out.println((i+1) + ". " + currProd.getName());
		}
	}
	
	public void addCategory(String categoryName)
	{
		if(!containsCategory(categoryName))
		{
			Category cat = new Category(categoryName);
			categories.add(cat);
		}
	}
	
	protected boolean containsCategory(String categoryName)
	{
		for(Category category : categories)
			if(category.getName().equals(categoryName))
				return true;
		return false;
	}
	
	public void addSubcat(String categoryName, String section)
	{
		Category cat = getCategory(categoryName);
		cat.addSub(section);
	}
	
	protected Category getCategory(String categoryName)
	{
		for(Category category : categories)
		{
			if(categoryName.equals(category.getName()))
			{
				return category;
			}
		}
		return null;
	}
	
	/**
	 * filters out a list of products into a new list of products
	 * using a preference given by a user.
	 * 	(1)	- Checks if a product's sections matches
	 *  (2) - Checks if a product's price is in preference range
	 *  (3) - Checks if a product's rating is greater than or equal to preference's rating
	 * @param p	- preferences of the user
	 * @return 	the new filtered list
	 */
	public ArrayList<Product> filteredProducts(Preference p) {
		ArrayList<Product> filteredList = new ArrayList<>();
		for (Product pr : list)
		{
			if(filterCheck(pr.getCategory(), pr.getSection(), p.getSection()) &&
			   pr.getCategory().equals(p.getSection().get(0)) &&
			   priceRangeCheck(pr.getPrice(), p.getMinRange(), p.getMaxRange()) &&
			   ratingCheck(pr.getRating(), p.getRating()))
				filteredList.add(pr);
		}

		return filteredList;
	}
	/**
	 * is there at least one section in the product's sections
	 * that matches with the preference's sections
	 * @param category		- main category
	 * @param sections		- of the product
	 * @param preferences	- preference sections
	 * @return true if at least one section matches
	 */
	private boolean filterCheck(String category, String[] sections, ArrayList<String> preferences)
	{
		if(preferences.size() > 1)
		{
			for(String section : sections)
				for(String pref : preferences)
					if(section.equals(pref))
						return true;
		}
		else if(preferences.get(0).equals(category))
			return true;
		
		return false;
	}
	
	/**
	 * is the product's price in the preference's range
	 * @param price			- of the product
	 * @param prefMinRange	- minimum preference price range
	 * @param prefMaxRange  - maximum preference price range
	 * @return	whether or not it is in range, true if it is
	 */
	private boolean priceRangeCheck(double price, int prefMinRange, int prefMaxRange)
	{
		if(price >= (double) prefMinRange && price <= (double) prefMaxRange)
			return true;
		else
			return false;
	}
	
	/**
	 * is the product's rating >= preference's rating
	 * @param rating		- of the product
	 * @param prefRating	- rating of the preference
	 * @return true if product rating >= preference rating
	 */
	private boolean ratingCheck(double rating, double prefRating)
	{
		if(rating >= prefRating)
			return true;
		else
			return false;
	}

}
