package utilities;

public class Pair implements Comparable<Pair> {
	public int x;
	public int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return x + y;
	}
	

	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair) obj;
		return (p.x == x && p.y == y);
	}

	@Override
	public int compareTo(Pair p) {
		return Integer.compare(this.x, p.x);
	}
	
}
