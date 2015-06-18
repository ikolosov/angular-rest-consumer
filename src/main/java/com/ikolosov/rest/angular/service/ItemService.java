package com.ikolosov.rest.angular.service;

import com.ikolosov.rest.angular.model.Item;

import javax.ejb.Singleton;
import java.util.Collection;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author ikolosov
 */
@Singleton
public class ItemService {

	private static final SortedSet<Item> itemStore = new ConcurrentSkipListSet<Item>() {{
		add(new Item("First item", true));
		add(new Item("Second item", false));
		add(new Item("Third item", true));
	}};

	public void addItem(Item item) {
		boolean added = itemStore.add(item);
		System.out.println("[] --- Item: "
				+ (item != null ? item.toString() : null)
				+ "\nwas " + (added ? "" : "not ") + "added to item store");
	}

	public void deleteItem(int id) {
		boolean removed = itemStore.remove(new Item(id));
		System.out.println("[] --- Item: "
				+ "id = " + id
				+ "\nwas " + (removed ? "" : "not ") + "deleted from item store");
	}

	public Collection<Item> getItems() {
		System.out.println("[] --- Items queried:");
		itemStore.stream().forEach(item -> System.out.println("Item: " + (item != null ? item.toString() : null)));
		return itemStore;
	}
}
