package com.ikolosov.rest.angular.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ikolosov
 */
public final class Item implements Comparable<Item> {

	private static final AtomicInteger idSeq = new AtomicInteger(0);

	private final int id;
	private final String name;
	private final boolean flag;

	private Item(int id, String name, boolean flag) {
		this.id = id;
		this.name = name;
		this.flag = flag;
	}

	public Item(String name, boolean flag) {
		this.id = idSeq.getAndIncrement();
		this.name = name;
		this.flag = flag;
	}

	public Item(int id) {
		this(id, null, false);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isFlag() {
		return flag;
	}

	@Override
	public int compareTo(Item item2) {
		int id1 = this.id;
		int id2 = item2 != null ? item2.getId() : Integer.MIN_VALUE;
		return (id1 < id2) ? -1 : ((id1 == id2) ? 0 : 1);
	}

	@Override
	public String toString() {
		return "{" +
				"id: " + id +
				", name: " + name +
				", flag: " + flag +
				'}';
	}
}
