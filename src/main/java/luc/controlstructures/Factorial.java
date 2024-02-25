package luc.controlstructures;

import java.util.Scanner;

/**
 * The program is designed to ask a user for input and find the 
 * factorial of the number.
 *
 * @author		Luc Gremillion, S02597411
 * @version		2022-2-5, CSC-240 Assignment 3 - Factorial
 */
public class Factorial {
    
private final static Scanner input = new Scanner(System.in);

/**
 * Main entry point.
 * <p>
 * Execute: </p>
 * <pre>luc.controlstructures.Factorial</pre>
 *
 * @param args	           not used
 */  
public static void main(String[] args) { 
    System.out.println("Please Enter a Positive number: ");
    long n = input.nextLong();
    long temp = n;
    long b = n - 1L;
    do{
        n = n * b;
        b--;
        if(!(n < -1L))
            System.out.printf("Using %d gives us %d as the factorial%n", temp, n); 
        
        if(!(n > -1L)){
            System.out.println("Number has become to large to continue");
            n = 0L;
        }
    }while(n != 0L);
    input.close();
}
}
