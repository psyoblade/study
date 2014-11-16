package nc.java.study;

import nc.java.study.animal.Tiger;
import nc.java.study.child.Child;
import nc.java.study.exec.Bonuses;
import nc.java.study.exec.Literal;
import nc.java.study.exec.Reference;
import nc.java.study.numeric.Numeric;
import nc.java.study.util.SingleTon;

public class Main {

	public static void exit() {
		System.exit(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Numeric numeric = new Numeric();
		Bonuses bonuses = new Bonuses();
		int[] points = { 1, 2, 3, 4, 5 };
		int[] results = new int[points.length];
		results = bonuses.getDivision(points);
		numeric.printPoints(results);
		exit();
		
		numeric.convertFloat();
		
		numeric.printPoints(points);
		numeric.passByValue(points);
		numeric.printPoints(points);
		exit();
		
		// method override
		Parent child = new Child();
		child.foo(); // method override
		child.bar(); // default access method

		// extends
		Parent parent = new Parent();
		parent.bar(); // default method can access
		parent.bar2(); // protected method can access

		Friend friend = new Friend();
		friend.foo();

		Parent[] children = { parent, child };
		int i = 0;
		for (Parent c : children) {
			System.out.print(++i);
			c.foo();
		}

		// abstract class extends
		Animal animal = new Tiger();
		animal.eat();
		
		// singleton class
		if (SingleTon.getInstance().contains("psyoblade")) {
			System.out.println(SingleTon.getInstance().get("psyoblade"));
		}

		// comparing reference string
		Reference ref = new Reference();
		ref.compareTwoStrings();
		
		// shifting numbers
		Literal literal = new Literal();
		literal.printLiteral();
	}

}
