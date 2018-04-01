package com.simcoder.tinder;
import java.util.ArrayList;
import java.util.Scanner;

public class Preference {

	private int minRange;
	private int maxRange;
	private ArrayList<String> section = new ArrayList<>();
	private double rating;
	private Scanner userInput = new Scanner(System.in);

	Preference(int minRange, int maxRange, ArrayList<String> section, double rating)
	{
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.section = section;
		this.rating = rating;
	}
	
	Preference(String mainCategory)
	{
		minRange = 0;
		maxRange = Integer.MAX_VALUE;
		section.add(mainCategory);
		rating = 0;
	}
	
	public Preference() {
		// TODO Auto-generated constructor stub
	}

	public int getMinRange() {
		return minRange;
	}

	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	public ArrayList<String> getSection() {
		return section;
	}

	public void setSection(ArrayList<String> section) {
		this.section = section;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Preference createPreference(String category)
	{
		ArrayList<String> updatedSection = section;
		updatedSection.add(0,category);
		return new Preference (minRange, maxRange, updatedSection, rating);
	}
	public Preference chooseSubcategory(String subcategory)
	{
		ArrayList<String> updatedSection = section;
		updatedSection.add(1,subcategory);
		return new Preference (minRange, maxRange, updatedSection, rating);	
	}
	
	public void addSection(String section)
	{
		this.section.add(section);
	}
	
	public void displaySections()
	{
		for(String sect : section)
			System.out.println(sect);
	}
	public void selectPriceRange()
	{	
		System.out.print("Enter minimum price: ");
		setMinRange(userInput.nextInt()); 
		System.out.print("Enter maximum price: ");
		setMaxRange(userInput.nextInt());
	}
	
	public void selectRating()
	{		
		System.out.print("Enter preferred rating: ");
		setRating(userInput.nextDouble());
	}
}
