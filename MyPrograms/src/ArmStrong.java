import java.util.*;
import java.lang.Character;

public class ArmStrong {

    private int number;
    ArmStrong(){
	readNumberFromInput();
	System.out.println(" === Your entered number is ArmStrong : " + checkArmStrong() + " ====");
	
    }
    
    private void readNumberFromInput(){
	System.out.println("Please enter a 3 digit number to find if its an Armstrong number:");
        number = new Scanner(System.in).nextInt();
    }
    /*
     * There are just four numbers, after unity, which are the sums of the cubes of their digits:153, 370, 371, 407
     * */
    private boolean checkArmStrong(){
	int totalSum = 0;
	int digit = -1;
	int newNumber = number;
	while(newNumber != 0 ){
	    digit = newNumber % 10;
	    newNumber = newNumber/10;
	    System.out.println("newNumber : " + newNumber + " , digit : "+ digit);
	    totalSum = totalSum + (digit * digit * digit);
	}
	
	return (totalSum == number);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	new ArmStrong();
    }

}
