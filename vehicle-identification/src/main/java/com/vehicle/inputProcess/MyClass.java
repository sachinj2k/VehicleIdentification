package com.vehicle.inputProcess;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class MyClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String combinationLine = br.readLine();
            int combination = Integer.parseInt(combinationLine);
           // System.out.println(combination);
            for(int j=0; j<combination;j++)
            {
            	
            	String line1 = br.readLine();
            	char one = line1.split(" ")[0].charAt(0);
            	char two = line1.split(" ")[1].charAt(0);
            	//System.out.println("one"+one+"two"+two);
            	
            	List<Integer> onePositions = getCharPosition(input,one);
                List<Integer> twoPositions = getCharPosition(input,two);
                
		         for(int k=0; i<onePositions.size();i++ )
		         {
		        	 for(int l=0; j<twoPositions.size();j++)
		        	 {
		        		 if(onePositions.get(k)<twoPositions.get(l))
		        		 {
		        			 String subString = input.substring(onePositions.get(k),twoPositions.get(l)+1);
		        			//5 System.out.println(subString);
		        			 if(subString.length()>1)
		        			 {
		        				 count++;
		        			 }
		        		 }
		        	 }
		         }
         
             // System.out.println(count);
            }
        }
        

        System.out.println(count);
    }
    
      static List<Integer> getCharPosition(String str, char mychar) {
        List<Integer> positions = new ArrayList<Integer>();

        if (str.length() == 0)
            return null;

        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == mychar) {
                positions.add(i);
            }
        }

        return positions;
}
}

