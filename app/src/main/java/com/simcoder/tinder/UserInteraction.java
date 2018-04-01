package com.simcoder.tinder;
import java.util.Scanner;

public class UserInteraction {

	private String name;
	private Scanner input = new Scanner(System.in);
	private FavoritesList fList = new FavoritesList();
	private DiscardedList dList = new DiscardedList();
	private BrowseList brList = new BrowseList();
	private Category cat = new Category(name);
	private static final boolean ASCENDING = true;
	private static final boolean DESCENDING = false;
	
	public void displayMenu()
	{	
		System.out.println("TECHR \n");

		System.out.println("1. Browse");
		System.out.println("2. Favorites List");
		System.out.println("3. Previously Viewed");
		System.out.println("4. Quit");
		System.out.println();
	}
	public void preferenceMenu()
	{
		System.out.println("Choose Preference: \n");
		System.out.println("1. Specify Sub Category");
		System.out.println("2. Specify Price Range");
		System.out.println("3. Specify Rating");
	}
	private void favouritesMenu()
	{
		System.out.println("Managing Favourites List: \n");
		System.out.println("1. Clear");
		System.out.println("2. Sort Alphabetical Ascending");
		System.out.println("3. Sort Alphabetical Descending");
		System.out.println("4. Sort Price Ascending");
		System.out.println("5. Sort Price Descending");
		System.out.println("6. Swap");
		System.out.println("7. Remove");
		System.out.println("8. Back");
	}
	private void discardedMenu()
	{
		System.out.println("Manage Discarded List: \n");
		System.out.println("1. Clear");
		System.out.println("2. Back");
	}
	public void browse(ProductList pList)
	{
		pList.displayCategories();
		int sub = 1;
		System.out.print("\nChoose a Category: ");
		int c = input.nextInt(); 
		Preference pref = new Preference(pList.categories.get(c-1).getName());
		
		System.out.print("Specify product preference (type, price etc.)? Enter (y/n): ");
		String choice = input.next();
		if(choice.equals("y"))
		{
			preferenceMenu();
			int prefC = input.nextInt();
			switch(prefC)
			{
				case 1:
					String mainCategory = pref.getSection().get(0);
					cat.displaySubcategories(mainCategory, pList);
					sub = input.nextInt();
					pref.addSection(pList.getCategory(mainCategory).getSubcategories().get(sub - 1));
					break;
				case 2:
					pref.selectPriceRange();
					break;
				case 3:
					pref.selectRating();
					break;
					
			}
		}
		brList.setBrowseList(pList.filteredProducts(pref));
		
		if(choice.equals("y"))
			System.out.println("\nHere is what we found for " + pList.getSubcategories().get(sub-1) + " " + pList.chooseCategory(c).getName() + ":\n");
		else
			System.out.println("\nHere is what we found for " + pList.chooseCategory(c).getName() + ":\n");

		brList.displayProducts();
		dList.setList(brList.getList());
		chooseAProduct(pList);
	}
	
	public void mainMenu(ProductList pList)
	{
		boolean quit = false;
		while(!quit)
		{
			displayMenu();
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			System.out.println();
			switch(choice)
			{
				case 1:
					browse(pList);
					break;
				case 2:
					enterFavList();
					break;
				case 3:
					enterDisList(pList);
					break;
				case 4:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}	
		}
	}
	
	
	private void enterDisList(ProductList pList)
	{
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Discarded List: ");
			dList.displayProducts();
			discardedMenu();
			
			System.out.print("Enter choice: ");
			int choice = input.nextInt();
			switch(choice)
			{
				case 1:
					dList.clearList();
					break;
				case 2:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}
		}
	}
	
	
	private void enterFavList()
	{
		boolean quit = false;
		while(!quit)
		{
			System.out.println("Favourites List: ");
			fList.displayProducts();
			favouritesMenu();
			System.out.print("Enter choice: ");
			int choice  = input.nextInt();
			switch(choice)
			{
				case 1:
					fList.clearList();
					break;
				case 2:
					fList.alphabeticalSort(ASCENDING);
					break;
				case 3:
					fList.alphabeticalSort(DESCENDING);
					break;
				case 4:
					fList.priceSort(ASCENDING);
					break;
				case 5:
					fList.priceSort(DESCENDING);
					break;
				case 6:
					swapFList();
					break;
				case 7:
					removeFromF();
					break;
				case 8:
					quit = true;
					break;
				default:
					System.out.println("invalid choice");
					break;
			}
		}
	}
	
	
	private void swapFList()
	{
		System.out.print("Enter 1st item index: ");
		int first = input.nextInt();
		System.out.print("Enter 2nd item index: ");
		int second = input.nextInt();
		fList.swap(first-1, second-1);
	}
	
	
	private void removeFromF()
	{
		System.out.print("Enter item index: ");
		int index = input.nextInt();
		fList.removeAt(index-1);
	}
	
	
	private void chooseAProduct(ProductList pList)
	{
		System.out.print("Choose a product: ");
		int choice = input.nextInt();
		Product chosen = brList.getList().get(choice-1);
		fList.addToEnd(chosen);
		pList.removeProduct(chosen);
		dList.removeProduct(chosen);
	}
}
