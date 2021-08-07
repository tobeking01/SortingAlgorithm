
/**
 * @author Tobechi Onwenu
 *  Sorting class to create objects to be sorted
 */

public class Sorting implements Comparable<Sorting> {
	private String word;
	private double price;
	private int number;

	@Override
	public String toString() {
		return word + "\t\t$" + price + "\t\t" + number;
	}

	public Sorting(int numbers) {
		word = "";
		setPrice(0);
		number = numbers;
	}
	
	public Sorting(String words, double prices, int numbers) {
		word = words;
		price = prices;
		number = numbers;
	}

	@Override
	public int compareTo(Sorting object) {
		return word.compareToIgnoreCase(object.getWords());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Sorting)) {
			return false;
		}
		Sorting other = (Sorting) obj;
		if (word == null) {
			if (other.word != null) {
				return false;
			}
		} else if (!word.equalsIgnoreCase(other.word)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the words
	 */
	public String getWords() {
		return word;
	}

	/**
	 * @param words
	 *            the words to set
	 */
	public void setWords(String words) {
		this.word = words;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the numbers
	 */
	public int getNumbers() {
		return number;
	}

	/**
	 * @param numbers
	 *            the numbers to set
	 */
	public void setNumbers(int numbers) {
		this.number = numbers;
	}

}
