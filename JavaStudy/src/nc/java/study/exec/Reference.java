package nc.java.study.exec;

public class Reference {

	public void compareTwoStrings() {
		String s1 = "string";
		String s2 = "string";
		String s3 = new String("string");
		String s4 = new String("string");
		if (s1 == s2) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		}
		if (s3 == s4) {
			System.out.println("s3 == s4");
		} else {
			System.out.println("s3 != s4");
		}
	}
}
