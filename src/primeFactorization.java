import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class primeFactorization {
	public static void main(String args[]){
		factor(welcome());
	}
	private static long welcome(){ //Welcomes user and returns a long integer
		System.out.println("Welcome to the Prime Factorization Program!");
		System.out.println("(This program is still buggy)");
		System.out.println("Enter a number to find the prime factorizations for:");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		MyLongHolder input = new MyLongHolder(0);
		do{
		input.n = scan.nextInt();
		if(input.n<=0||input.n>=250000){
			System.out.println("Invalid number, Please retry:");
		}
		}while(input.n<=0||input.n>=250000);
		return input.n;
	}
	public static void factor(long n){ //factors a long integer
		boolean stopTF = false; //declare used variables & arrays
		final List<Long> arrPrimes = primeGenerator(n);
		int sizePrimes = arrPrimes.size();
		
		if(checkNisPrime(arrPrimes, sizePrimes, n)==true){  //check if "n" is prime
			stopTF = true;
		}
		if(stopTF == false){  //if "n" is not prime AND not a multiple of two
			nNotPrime(n, arrPrimes, sizePrimes);
		}
	}
	private static List<Long> primeGenerator(long n){ // Return array of prime numbers
		List<Long> primeArray = new ArrayList<Long>();
		long x, y;
		for(x = n; x >= 2; x--){
			if(x % 2 != 0 || x == 2){
				for(y = 2; y <= x / 2; y++){
					if(x % y == 0){
						break;
					}
				}
				if(y > x / 2){
					primeArray.add(x);
				}
			}
		}
	return primeArray;
	}
	private static boolean checkNisPrime(List<Long> arrPrimes, int sizePrimes, long n){
		for(int i = 0; i < sizePrimes; i++){
			if(n==arrPrimes.get(i)){  //if n is prime then...
				System.out.println("That number is a prime number!");
				return true;
			}
		}
		return false;
	}
	private static void nNotPrime(long n, List<Long> arrPrimes, int sizePrimes){
		List<Long> arrFactors = new ArrayList<Long>();
		long test = n;
		//long someNum = n;
		System.out.println("Here are the numbers: ");
		for(int i = 0; i < sizePrimes; i++){  //loop through primes
				ifDivisiblePrime(n,arrPrimes, i, arrFactors);
				if(n == 1){
					System.out.printf("There are all the numbers!");
					break;
				}
			}
		if(test==n){  //if n is same after everything
			System.out.printf("Wait, that number is not divisible by any prime numbers");
		}
	}
	// TODO FIX THIS
	private static void ifDivisiblePrime(long n, List<Long> arrPrimes, int i, List<Long> arrFactors){
		if(n % arrPrimes.get(i) == 0){  //if n is again a divisible prime number then...
				n /= arrPrimes.get(i);
				arrFactors.add(arrPrimes.get(i));
				ifDivisiblePrime(n,arrPrimes, i, arrFactors);
		}
	}
}