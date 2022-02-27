/*
================================ Length of distinct longest substring ======================
The program expects a string input from STDIN which then is processed iteratively
to ditermine the length of substring that that have distinct characters and is 
maximum over the provided input.
============================================================================================

Authored By : TensorNd

*/
import java.util.*;

public class LengthOfLongestSubstring{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String input_string;
		input_string=sc.nextLine();
		int end;
		int max_length=0;
		Vector<Character> distinct=new Vector<Character>(); 
		for(int i=0;i<input_string.length();i++){
			end=i;
			distinct.clear();
			while((end<input_string.length()) && (distinct.indexOf(input_string.charAt(end))==-1)){
				distinct.add(input_string.charAt(end));
				end++;
				if((end-i)>max_length){
					max_length=end-i;
				}

			}


		}
		System.out.println(max_length);
	}
}
