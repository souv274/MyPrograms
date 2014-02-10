import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;


public class FirstClass {
	double d = Double.MAX_VALUE;
	Double d1;
    	String str;
    	char[] c = new char[100];
        Character[] c1 = new Character[100];
        @SuppressWarnings("rawtypes")
	ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();
    	
	FirstClass(){
	   //method1();
	   //replace( str, 's', 'z');
	   //System.out.println("Output : " + reverseRecursion("abc"));
	   // System.out.println("Data : " + 1111%300);
	   //System.out.println("Output : " + exponentialRecursion(8, 3));
	   //System.out.println("Output : " + binarytoDecimal("001101", "001101".length(), 0));
	   
	    //********* Given a array of numbers , find the contiguous sub array whose sum is k
	    //int[] intArray = {1, 5, 6, 7, 8};
	    //findContigousArrayWithSum(intArray, 17);
	   
	    //********* the maximum sub array problem is the task of finding the contiguous sub array 
	    //********* within a one-dimensional array of numbers (containing at least one positive number) 
	    //********* which has the largest sum
	    //int[] intArray1 = {-2, 1, -3, 4, -1,2, 1, -5, 4};
	    //findContigousWithMaxSum(intArray1);
	    //****** Reverse the words of a sentence
	    //System.out.println("Reverse: " + reverseSentence("A word of mouth"));
	    //***** Find if unique characters in a string ASCII [ 256]
	    //findUnique("SOUVVIK");
	    //System.out.println("REVERSE:  " + reverse("SOUVIK"));
	    //***find anagrams for a given string
	    permutation("", "dog");
	}
	
	private void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }

	}
	
	public String reverse(String str){
	    if(str.length() <=1 ){
		return str;
	    }else{
		    return reverse( str.substring(1)) + str.charAt(0);
	    }
	    
	}
	
	public void findUnique(String unique){
	    boolean[] str = new boolean[256];
	    char[] ch = unique.toCharArray();
	    for (int i=0; i < ch.length; i++){
		System.out.println("str[(int)ch[i] : "+ str[(int)ch[i]] + " , (int)ch[i] : " + (int)ch[i]);
		if(str[(int)ch[i]] == false)
		str[(int)ch[i]] = true;
		else {
		    System.out.println("Not Unique");
		    return;
		}
	    }
	    System.out.println("Unique");
	}
	
	
	public String reverseSentence(String str){
	    String str1 ="";
	    StringTokenizer tokenizer = new StringTokenizer(str," ");
	    while(tokenizer.hasMoreElements()){
		str1 = tokenizer.nextElement() + " " +str1;
	    }
	    
	    return str1;
	}
	public void method1(){
	    /* Java's float and double types, like pretty much any other language out there 
	     * (and pretty much any hardware FP unit), implement the IEEE 754 standard for 
	     * floating point math, which mandates division by zero to return a special "infinity" value. 
	     * Throwing an exception would actually violate that standard.*/
	    System.out.println("Result : " + d/0 + " , Wrapper 0 division : " + d1/0);
	    
	    //Type conversions
	    int i = (int)d; //Causes data loss , int would only have its own max value
	    System.out.println("Type Converstion example double : " + d);
	    System.out.println("Type Converstion example int : "+ i + " , Max Value : " + Integer.MAX_VALUE);
	    
	    
	}
	
	public int binarytoDecimal(String binary, int count, int data){
	    
	    if(count <= 1) return data; 
	    return binarytoDecimal(binary.substring(1), 
		    --count, 
		    data+(Integer.parseInt(binary.substring(0, 1)) * exponentialRecursion (2, count))
	    );
	    
	}
	
	public void findContigousArrayWithSum(int[] intArray, int k){
	    int sum =0;
	    int start =0, end =0;
	    boolean found = false;
	    
	    if(intArray[0] == k){
		System.out.println("Start: " + start + " , End : " + end + " , sum : " + k);
	    }
	    else{
		if(k > intArray[0]){
		   while(start < intArray.length){
    		   	while(end < intArray.length){
    		   	    sum = sum + intArray[end];
    		   	    if(sum > k) break;
    		   	    if(sum == k){
    		   		System.out.println("FOUND with Start: " + start + " , End : " + end + " , sum : " + k);
    		   		found = true;
    		   		break;
    		   	    }
    		   	    end++;
    		   	    
        		}
    		   	sum =0;
    		   	start++;
    		   	end = start;
		   }
		   if(!found) System.out.println("Max sum not found");
		}	
	    }
	}
	
	public void findContigousWithMaxSum(int[] intArray){
	    int start=0, end=0;
	    int sum=0, maxSum = 0;
	    
	    while(start < intArray.length){
		while(end < intArray.length){
		    sum = sum + intArray[end];
		    end++;
		    if(sum > maxSum) maxSum = sum;
		}
		
		sum = 0;
		start++;
		end = start;
	    }
	    
	    System.out.println("Max Sum : " + maxSum);
	}
	
	public void replace(){
	    String str= "amazon".toLowerCase();
	    String chars ="And".toLowerCase();
		
	    char[] new1 = chars.toCharArray();
	    char[] orig= str.toCharArray();
	    for (int i = 0; i < new1.length; i++) {
		char ch = new1[i];
		for(int j=0; j <  orig.length; j++){
		    if( orig[j] == ch || orig[j] == ch+27){
			orig[j] = ' ';
		    }
		}
	    }
	    System.out.println("\n"+new String(orig).replace(" ", ""));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    long temp;
	    temp = Double.doubleToLongBits(d);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
	    result = prime * result + ((str == null) ? 0 : str.hashCode());
	    return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    FirstClass other = (FirstClass) obj;
	    if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
		return false;
	    if (d1 == null) {
		if (other.d1 != null)
		    return false;
	    } else if (!d1.equals(other.d1))
		return false;
	    if (str == null) {
		if (other.str != null)
		    return false;
	    } else if (!str.equals(other.str))
		return false;
	    return true;
	}

	public String reverseRecursion(String abc){
	    System.out.println(abc);
	    if(abc.length()<=1)
		return abc;
	    else return reverseRecursion(abc.substring(1)) + abc.charAt(0);
	    
	}
	
	public int exponentialRecursion(int number, int power){
	    System.out.println("Power:" + power);
	    if(power <= 1) return number;
	    else return exponentialRecursion(number, (--power)) * number;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    new FirstClass();
	}

}
