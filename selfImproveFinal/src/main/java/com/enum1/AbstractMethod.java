package com.enum1;

public enum AbstractMethod {
	One{
		@Override
		public void print() {
			System.out.println("1");
		}
	},
	Two{
		@Override
		public void print() {
			System.out.println("2");
		}
	};
	
	public abstract void print();
}
