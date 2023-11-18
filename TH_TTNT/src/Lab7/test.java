package Lab7;

public class test {
	public static void main(String[] args) {
		GA_NQueenAlgo ga_NQueenAlgo = new GA_NQueenAlgo();
		Node re = ga_NQueenAlgo.execute();
		System.out.println(re.getH());
	}
}
