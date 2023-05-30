public class LongestCommonSubsequence{ //(LCS)
public static void main(String[] args){
String s1="AGGTAB",s2="GXTXAYB";
int length=subSequenceLength(s1,s2);
System.out.println("Result --> "+length);
}
public static int subSequenceLength(String s1, String s2){
int count=1;
for(int i=0;i<s1.length();i++){
    for(int j=0;j<s1.length();j++){
        if((s1.charAt(i)==s2.charAt(j))&&s2.charAt(j)!="-1"){
            s2.charAt(j)="-1";
            count++;
        }
    }
}

return count;
}
}
