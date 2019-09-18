package com.java.certification;

public class Soal6 extends Soal implements AbstractSoal{
	
	public static void overload(Head side) {
		System.out.print(side.getSide());
	}
	
	public static void overload(Tail side) {
		System.out.print(side.getSide());
	}
	
	public static void overload(Side side) {
		System.out.print("Side ");
	}
	
	public static void overload(Object side) {
		System.out.print("Object ");
	}
	
	@Override
	public void getJawaban() {
		Side firstAttemp = new Head();
		Tail secondAttemp = new Tail();
		overload(firstAttemp);
		overload((Object) firstAttemp);
		overload(secondAttemp);
		overload((Side) secondAttemp);
		System.out.println();
	}

}

interface Side {
	String getSide();
}

class Head implements Side {

	@Override
	public String getSide() {
		return "Head ";
	}
	
}

class Tail implements Side {

	@Override
	public String getSide() {
		return "Tail ";
	}
	
}