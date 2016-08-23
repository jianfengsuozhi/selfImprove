package com.test;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Person {
    private String name;
    private int age;
    
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
            // if deriving: appendSuper(super.hashCode()).
            append(name).
            append(age).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Person))
            return false;
        if (obj == this)
            return true;

        Person rhs = (Person) obj;
        return new EqualsBuilder().
            // if deriving: appendSuper(super.equals(obj)).
            append(name, rhs.name).
            append(age, rhs.age).
            isEquals();
    }
    public static void main(String[] args) {
    	Person person1 = new Person("魏德亮", 23);
    	Person person2 = new Person("魏德亮", 23);
    	
    	System.out.println(person1.hashCode());
    	System.out.println(person1.equals(person2));
	}
}
