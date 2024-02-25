package luc.controlstructures;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is designed to test control statements and loops, while 
 * making a mock store menu, that contains items, cost and quantity.
 *
 * @author		Luc Gremillion, S02597411
 * @version		2022-2-5, CSC-240 Assignment 3 - Calculating Sales
 */
public class CalculatingSales {
    
 /**
 * Contains a series of dash marks to simplify to a name instead 
 */   
private static final String DASH_LINES = "--------------------------------------"
        + "----------------------------------------";

/**
 * contain a list sections that are offered by the store
 */
private final String[] menuList = {"Item", "Quantity", "Price", "Extension "};

/**
 * contain a list items that are offered by the store
 */
private final String[] menuItem = {"SOAP", "SHAMPOO", "LOTION","CONDITIONER","MOISTURIZER"};

/**
 * each value contains a section for a item in the customers cart
 */
private final int[] cart = {0,0,0,0,0,0};

/**
 * contains each price for each item the store offers
 */
private final double[] cost = {2.98,4.50,9.98,4.49,6.87};

/**
 * Scanner class added to grab user input
 */
private final Scanner input = new Scanner(System.in);

/**
 * Display's whats currently in the cart and adds up the total for the
 * items in the cart.
 * 
 */
private void showCart(){
    System.out.print("     |");
    
    for(String menuList1 : menuList)
        System.out.printf("    %-13s|",menuList1);
    
    System.out.println("\n" + DASH_LINES);
    
    double extCost;
    double totalCost = 0;
    for(int x=0; x<menuItem.length; x++){
        extCost = cart[x] * cost[x];
        totalCost += extCost;
        if(cart[x] != 0){
            System.out.printf("%2s %-2d|%2s %-14s|%2s %-14d|%2s $%-13.2f|%3s $%-13.2f|%n", " ",x + 1 , 
                "", menuItem[x],"",cart[x],"",cost[x]," ", extCost);
        }
        
    }
    System.out.printf("%41s|   Total Cost    |    $%-13.2f|%n", " ",totalCost);
    System.out.println(DASH_LINES);
}


/**
 * Display's the current menu and will ask user what they would like to order. 
 * 
 * @returns                 true or false                     
 */
private boolean orderMenu(){
    int grabUser = 0;
    boolean x = false;

    while(x != true){ 
        for(int b=0; b<menuItem.length; b++) 
            System.out.printf("%2d  |%-12s| $%-5.2f|%n",b + 1, menuItem[b],cost[b]);
        
        System.out.println("Enter a product number from 1 to 5 (or 0 to stop): ");
        grabUser = validInput(grabUser);
        if(grabUser == 0){           
            return false;
        }if(grabUser > 0 && grabUser <= menuItem.length){
            grabUser = grabUser - 1;
            System.out.printf("How many of %s would you like to add or update to? %n", menuItem[grabUser]);
            System.out.println("Enter quantity ordered: ");
            cart[grabUser] = input.nextInt();
        }else{
            System.out.println("Invalid Input - Out of Bounds");
        }
    }
    return true;
}

/**
 * Grabs user input and if not an int throws an error exception
 * 
 * @param                       grabUser
 * @returns                     grabUser
 */
private int validInput(int grabUser){
    try{
        grabUser = input.nextInt();
    }catch(InputMismatchException ex){
        System.out.println("Invalid Input - Mismatched type");
    }
    return grabUser;
}


/**
 * Main entry point.
 * <p>
 * Execute: </p>
 * <pre>luc.controlstructures.CalculatingSales</pre>
 *
 * @param args	           not used
 */  
public static void main(String[] args) {
    CalculatingSales sales = new CalculatingSales();
    int userInput = -1;
    boolean mainLoop = true;
    
    while(mainLoop != false){
        System.out.println(" 1 |   List of Products   |\n"
                + " 2 |      Cart Menu       |\n 0 |         Exit         |");
        System.out.println("Please choose an option from the menu: ");
        userInput = sales.validInput(userInput);
        switch(userInput){
            case 1:
                sales.orderMenu();
                break;
            case 2:
                sales.showCart();
                break;
            case 0:
                mainLoop = false;
                break;
            default:
                System.out.println("Invalid Input - Please enter a number from 0-2");
        } 
    }  
}

}
