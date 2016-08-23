package com.generic;

public class Generics01<T extends String> {
	private T value;

	public T getValue() {
		System.out.println("调用value");
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public <V> V getInteger(V a){
		return a;
	}
	
}

