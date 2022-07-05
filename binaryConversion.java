import java.util.Scanner;
public class binaryConversion {

	public static void main(String[] args) {
        int[] denaryPlaceholders = { 128, 64, 32, 16, 8, 4, 2, 1 };
        String binaryPattern = "";
        int denaryNumber = 0;
        int count = 0;
        
        // Add your code here
        System.out.println("Enter a 8 digit binary pattern");
        Scanner input = new Scanner(System.in);
        binaryPattern = input.next();
        int lengthBinary = binaryPattern.length();
        while(lengthBinary != 8 ) {
        	System.out.println("Enter a 8 digit binary pattern");
        	binaryPattern = input.next();}
        
        	if(lengthBinary == 8) {
        		System.out.println("Thank you");
        		for(int i = 0; i < lengthBinary;i++) {
        			char bp = binaryPattern.charAt(i);
        				if(bp == '1') {
        					denaryNumber += denaryPlaceholders[i];
        					//count++;
        					
        			}
        				
        			
        		
        	        }
        	   }  
        
        	System.out.println("The denary equivavelent for the binary number" + " " + binaryPattern + " is" + " "+ denaryNumber); 
        
        
	


input.close();
    } // End of main program   
} // End of class