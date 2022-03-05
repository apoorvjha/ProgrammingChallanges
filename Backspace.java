/*
===================================== Backspace problem ====================================
In this problem we are provided with two strings we have to write program that can output
"Yes" or "No" strings based on the fact that the first string can be transformed into second 
if instead of typing out a character present in second string we instead ype a backspace
character which removes current and a character before it.
============================================================================================
*/


import java.util.*;

class Solution{
	String isBackspaceDoable(String source, String target){
		Stack<Character> S=new Stack<Character>();
		Stack<Character> T=new Stack<Character>();
		Stack<Character> temp=new Stack<Character>();
		int it=0;
		for(;it<source.length();it++){
			S.push(source.charAt(it));
		}
                for(it=0;it<target.length();it++){
                        T.push(target.charAt(it));
                }
		while((!S.empty()) && (!T.empty())){
			if(S.peek()==T.peek()){
				temp.push(T.pop());
				S.pop();
			}
			else if((S.peek()!=T.peek()) && (S.size()!=1)){
				S.pop();
				S.pop();
			}
			else if((S.peek()!=T.peek()) && (S.size()==1)){
				S.pop();
			}
		}
		if(T.empty()){
			return("Yes");
		}
		else{
			return("No");
		}

	}
}

public class Backspace{
	public static void main(String args[]){
		Solution sol=new Solution();
		// test case 1
		System.out.println("Test case 1 : Source=\"abba\" target=\"ba\" => "+sol.isBackspaceDoable("abba","ba"));
		//test case 2
 		System.out.println("Test case 2 : Source=\"abbaba\" target=\"aab\" => "+sol.isBackspaceDoable("abbaba","aab"));

		//test case 3
		 System.out.println("Test case 3 : Source=\"ccaba\" target=\"cab\" => "+sol.isBackspaceDoable("ccaba","cab"));
	}
}
