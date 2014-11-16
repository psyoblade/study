package nc.java.study.child;

import nc.java.study.Parent;

public class Child extends Parent {

	public void foo() { // override parent::foo
		System.out.println("child::foo");
	}
	
	public void bar() { // no method for public void bar
		System.out.println("child::bar");
	}
	
	public void testBar2() {
		super.bar2();
	}
	
}
