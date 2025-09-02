package org.example.inherit;


import org.example.util.Bird;

class Bi extends Bird {
	//moveFast 재정의
	@Override
	public void moveFast() 
	{
	   super.moveFast();
	}
}


class Ostrich extends Bird{
	
	//특징 (구체화 ,특수화)
	void run() {
		System.out.println("run ....");
	}
	@Override
	public void moveFast() 
	{
	   run();
	}
}

public class Ex09_Inherit_Protected {

	public static void main(String[] args) {
		Bi bi = new Bi();
		bi.fly();
		
		Ostrich o = new Ostrich();
		o.moveFast();
	}

}
