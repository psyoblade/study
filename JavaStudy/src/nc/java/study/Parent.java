package nc.java.study;

public class Parent {

	public void foo() {
		System.out.println("parent::foo");
	}
	
	void bar() {
		System.out.println("parent::default::bar");
	}
	
	protected void bar2() {
		System.out.println("parent::protected::bar2");
	}
}
