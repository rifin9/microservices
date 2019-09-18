package com.java.certification;

public class Soal7 extends Soal implements AbstractSoal{

	@Override
	public void getJawaban() {
		foo(10);
	}
	
	public static void foo(Integer i) {
		System.out.println("foo(Integer)");
	}
	
	public static void foo(short i) {
		System.out.println("foo(short)");
	}
	
	public static void foo(long i) {
		System.out.println("foo(long)");
	}
	
	public static void foo(int ... i) {
		System.out.println("foo(int ...)");
	}
}
