package com.agencyBack.entity;

public enum TypeOfContract {
	TORENT(1),
	TOBUY(2);

	private int value;


	TypeOfContract(int i) {
		this.value = i;
	}

	public int getValue(){
		return value;
	}
}
