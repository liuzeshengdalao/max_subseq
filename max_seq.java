package max_seq;

import java.util.*;
import java.lang.Math;

public class seq_max {
	public static StringBuffer dp_max_seq(String str1,String str2){
		int arr1_leng = str1.length();
		int arr2_leng = str2.length();
		int [][]dp = new int[arr1_leng+1][arr2_leng+1];
		StringBuffer res = new StringBuffer();
		//≥ı ºªØ
		for(int i=1; i<arr1_leng+1; ++i){
			for(int j=1; j<arr2_leng+1; ++j){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);	
				}
			}
		}
		int loc1 = arr1_leng;
		int loc2 = arr2_leng;
		while(loc1>0 && loc2>0 ){
			if(str1.charAt(loc1-1)==str2.charAt(loc2-1)){
				res.append(str1.charAt(loc1-1));
				loc1--;loc2--;
			}
			else if(dp[loc1][loc2-1]>=dp[loc1-1][loc2]){
				loc2--;
			}
			else{
				loc1--;	
			}
		}
		return res;
	}
  public static void main(String []args){
	  String str1="acbc";
	  String str2="abc";
	  StringBuffer res = dp_max_seq(str1, str2);
	  res = res.reverse();
	  System.out.println(res);
  }
}
