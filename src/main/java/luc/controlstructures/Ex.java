package luc.controlstructures;

import static java.lang.Double.isInfinite;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The program is designed to ask a user for two different input's 
 * and uses the exponent to number of terms to find an estimate.
 *
 * @author		Luc Gremillion, S02597411
 * @version		2022-2-5, CSC-240 Assignment 3 - Ex
 */
public class Ex {
    
/**
 * Scanner class added to grab user input
 */
private final Scanner input = new Scanner(System.in);


/**
 * Grabs user input and if not an int throws an error exception
 * 
 * @param                       getUser
 * @return                      getUser
 */
private int validInt(int getUser){
    try{
        getUser = input.nextInt();
    }catch(InputMismatchException ex){
        System.out.println("Invalid Input - Mismatched type");
    }
    return getUser;
}

/**
 * Grabs user input and if not an int throws an error exception
 * 
 * @param                       getUser
 * @return                      getUser
 */
private double validDouble(double getUser){
    try{
        getUser = input.nextFloat();
    }catch(InputMismatchException ex){
        System.out.println("Invalid Input - Mismatched type");
    }
    return getUser;
}
 
/**
 * runs the math for the program and output the information
 */
private void runExponent() {
    while(true){
        int terms = -1;
        System.out.println("Enter a positive number of terms or 0 to Exit: ");
        terms = validInt(terms);
        if(terms < -1){
            System.out.println("Invalid input cannot be negative or 0"
                    + "\nEnter Number of terms: ");
            terms = validInt(terms);
        }
        
        if(terms == 0)
            break;
        
        double exponent = 0.0;
        System.out.println("Enter an exponent value: ");
        exponent  = validDouble(exponent);


        double count = 1.0;
        double answer = 1.0;	

        for(int x = 1;x <= terms;x++){
                count = count * exponent / x;				
                answer += count;
        }

        if(isInfinite(answer)){
            System.out.println("Invalid - Number too is large/infinite");
        }else{
            System.out.printf("Using %d terms to estimate, e to "
                    + "the power of %.3f is %.15g %n",terms,exponent,answer);
        }
    }
}


/**
 * Main entry point.
 * <p>
 * Execute: </p>
 * <pre>luc.controlstructures.Ex</pre>
 *
 * @param args	           not used
 */  
public static void main(String[] args) {
    Ex ex = new Ex();
    ex.runExponent();
}
}
