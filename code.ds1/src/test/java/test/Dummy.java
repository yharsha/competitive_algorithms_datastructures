package test;

public class Dummy {
	
    public static int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result =(result%1000000007)* factor;
            
        }

        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(100));
	}

}
