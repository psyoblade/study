package nc.java.study.exec;

public class Bonuses {
	public void sortPoints(int[] points) {
		for (int i = 0; i < points.length; i++) {
			int max_index = i;
			for (int j = i + 1; j < points.length; j++) {
				if (points[max_index] < points[j]) {
					max_index = j;
				}
			}
			if (i != max_index) {
				int temp = points[i];
				points[i] = points[max_index];
				points[max_index] = temp;
			}
		}
	}
	public int[] getDivision(int points[]) {
		sortPoints(points);
		int totalPoints = 0;
		for (int i = 0; i < points.length; i++) {
			totalPoints += points[i];
		}
		int[] percents = new int[points.length];
		int totalPercents = 0;
		for (int i = 0; i < points.length; i++) {
			percents[i] = (points[i] * 100) / totalPoints;
			totalPercents += percents[i];
		}
		if (totalPercents < 100) {
			int remained = 100 - totalPercents;
			int topn = (points.length < remained ? points.length : remained);
			for (int i = 0; i < topn; i++) {
				percents[i] += 1;
			}
		}
		return percents;
	}
}