public class GaussFilter {
	private ArrayList<Double> dataArrayList;
	private int length;

	public GaussFilter(ArrayList<Double> arrayList) {
		this.dataArrayList = arrayList;
		this.length = arrayList.size();
	}

	public ArrayList<Double> calc() {
		if (dataArrayList.size() < 2) {
			return dataArrayList;
		}
		double average = calcAverage(dataArrayList);
		double sigma = calcSigma(dataArrayList, length, average);
		double minFilter = sigma * 0.15 + average;
		double maxFilter = sigma * 3.09 + average;
		ArrayList<Double> newDataArrayList = new ArrayList<Double>();
		for (int i = 0; i < length; i++) {
			if (dataArrayList.get(i) >= minFilter
					&& dataArrayList.get(i) <= maxFilter) {
				newDataArrayList.add(dataArrayList.get(i));
			}
		}
		return newDataArrayList;
	}

	public double calcAverage(ArrayList<Double> array) {
		double sum = 0;
		for (int i = 0; i < array.size(); i++) {
			sum += array.get(i);
		}
		return (double) sum / array.size();
	}

	public double calcSigma(ArrayList<Double> array, int n, double average) {
		double tempSum = 0;
		for (int i = 0; i < n; i++) {
			double delta = (double) array.get(i) - average;
			tempSum += Math.pow(delta, 2);
		}
		return (double) Math.sqrt((tempSum / n));
	}
}
