package com.java.certification;

public class Soal implements AbstractSoal{
	protected void spliter() {
		System.out.println("============================================");
	}
	
	public Soal build() {
		spliter();
		return this;
	}

	@Override
	public void getJawaban() {
		System.out.println("");
	}
	
	public void soal1() {
		String s1 = "hi";
		String s2 = new String("hi");
		String s3 = "hi";
		
		System.out.println("s1 == s2 : "+ (s1 == s2));
		System.out.println("s1.equals(s2) : "+ s1.equals(s2));
		System.out.println("s1 == s3 : "+ (s1 == s3));
	}
	
}
