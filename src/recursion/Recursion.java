package recursion;

public class Recursion {
	
	public int factorial(int n) {
		if(n < 1) {
			return -1;
		}
		
		if(n==0 || n == 1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public int fibonacci(int n) {
		if(n<0) {
			return -1;
		}
		
		if(n==0 || n==1) {
			return n;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public int sumOfDigits(int num) {
		if(num==0 || num<0) {
			return 0;
		}
		
//		if(num >= 0 && num<=9) {
//			return num;
//		}
		return num%10 + sumOfDigits(num/10);
	}
	
	public int power(int base, int exp) {
		// x^n = x * x ^ (n-1)
		if(exp < 0) {
			return -1;
		}
		if(exp == 0) {
			return 1;
		}
//		if(exp == 1) {
//			return base;
//		}
		return base * power(base, exp-1);
	}
	
	public int gcd(int a, int b) {
		if(a < 0 || b<0) {
			return -1;
		}
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	public int decimalToBinary(int num) {
		if(num == 0) {
			return 0;
		}
		return num%2 + 10*decimalToBinary(num/2);
		
	}
					
	
}
