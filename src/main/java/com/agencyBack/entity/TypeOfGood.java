package com.agencyBack.entity;

public enum TypeOfGood {
	HOUSE(1),
	APARTMENT(2),
	STUDIO(3),
	STORAGE(4),
	OFFICE(5),
	SHOP(6);

	private int value;


	TypeOfGood(int i) {
		this.value = i;
	}

	public int getValue(){
		return value;
	}
}
