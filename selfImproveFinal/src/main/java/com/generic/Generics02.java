package com.generic;

import java.util.Collection;

public class Generics02{
	void eatAll(Collection<? extends String> str){
		
	}
	<T extends Number & Comparable<T>> void a(){
		
	}

}
