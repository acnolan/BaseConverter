import java.util.Scanner;

import javax.swing.JFrame;

public class Converter {
	public Converter() {
		
	}
	public String convert(int oldBase, int newBase, String toConvert) {
		String result="";
		int decimal = makeBaseTen(oldBase, toConvert);
		if(decimal<0) {
			return "Please enter a non negative number in the proper base's format.";
		}else if(decimal==0) {
			return "0";
		}else {
			while(decimal>0) {
				result= checkLetter(newBase, decimal % newBase) + result;
				decimal=decimal/newBase;
			}
		}
		return result;
	}
	
	private String checkLetter(int base, int toChange) {
		if(base>10) {
			switch(toChange) {
			case 10: return "a";
			case 11: return "b";
			case 12: return "c";
			case 13: return "d";
			case 14: return "e";
			case 15: return "f";
			default: return ""+toChange;
			}
		}
		return ""+toChange;
	}
	
	private int makeBaseTen(int base, String toChange) {
		int len = toChange.length();
		int power = 1;
		int num = 0;
	    int i;
	    for (i = len - 1; i >= 0; i--){
	    	if (val(toChange.charAt(i)) >= base){
	    		//System.out.println("base: " + base+ " toChange: "+val(toChange.charAt(i)));
	    		return -1;
		    }
	    	num += val(toChange.charAt(i)) * power;
	    	power = power * base;
	    }
	    return num;
	}
	
	private int val(char c)
	{
		c=Character.toLowerCase(c);
	    if (c >= '0' && c <= '9')
	        return (int)c - '0';
	    else
	        return (int)c - 'a' + 10;
	}
}
