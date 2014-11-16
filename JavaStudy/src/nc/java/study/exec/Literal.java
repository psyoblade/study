package nc.java.study.exec;

public class Literal {

	public void printLiteral() {
		long flag = 0x10L;
		flag = 0x20L;
		flag = 0x1000L;
		double flagCalc = Math.pow(16, 3);
		flag = 0x80000000L; // Math.pow(16, 7) * 8;
		flagCalc = Math.pow(16, 7) * 8; // 21억 양의정수 최대값은 패딩비트를 제외한 나머지는 모두 1로 채워졌다는 의미.
		int max = Integer.MAX_VALUE; // 0x80000000L == INT_MAX - 1;
		int val = 0x12345678;
		while (flag > 0) {
			if ((val & flag) == 0) {
				System.out.print("0");
			} else {
				System.out.print("1");
			}
			flag = flag >> 1; // 2로 나누는 결과. 21억 > 10.5억 > 5.25억 > ... 상위비트는 밀기전의 바로 앞의 자리로 채워짐. 
			// 양수의 경우 패리티 비트가 0이므로 0으로 채워짐.
		}
	}

}
