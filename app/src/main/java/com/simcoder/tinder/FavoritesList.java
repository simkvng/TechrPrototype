package com.simcoder.tinder;

import java.util.Collections;

public class FavoritesList extends ProductList{
	public static final int ALPHABETICAL = 0;
	public static final int PRICE        = 1;
	
	public void swap(int index1, int index2)
	{
		Product p1 = list.get(index1);
		Product p2 = list.get(index2);
		// Swap
		list.set(index1, p2);
		list.set(index2, p1);
	}
	
	public void alphabeticalSort(boolean ascending)
	{
		Collections.sort(list, Product.alphabetical());
		if(!ascending)
			Collections.reverse(list);
	}
	
	public void priceSort(boolean ascending)
	{	
		Collections.sort(list, Product.price());
		if(!ascending)
			Collections.reverse(list);
	}
	
}
