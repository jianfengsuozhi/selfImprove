package com.enum1;

public enum Season {
	//Enum constants are instantiated when an enum is referenced for the first time
    WINTER((short)1),//public static final Season WINTER = new Season(1);
    SPRING((short)2),
    SUMMER((short)3),
    FALL((short)4);
    //是enum不可变
    private final Short value;
    
    private Season(Short value) {
		this.value = value;
	}

	public Short getValue() {
		return value;
	}

	public static void display(Season s) {
        System.out.println(s.name());
    }
    
    public static void enumIterate(){
    	for (Season season : Season.values()) {
			System.out.println(season.name());
		}
    }
    
    public static void enumSwitchExample(Season season){
        switch(season) {
        case WINTER:
            System.out.println("It's pretty cold");
            break;
        case SPRING:
            System.out.println("It's warming up");
            break;
        case SUMMER:
            System.out.println("It's pretty hot");
            break;
        case FALL:
            System.out.println("It's cooling down");
            break;
    }
    }
}
