
class WordBreak{
private static Set<String> dictionary = new HashSet<>();
public static void main(String [] args){
String temp_dictionary[] = { i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango};
for (String temp :temp_dictionary)
		{
			dictionary.add(temp);
		}
        
        System.out.println(wordBreak("ilikesamsung"));
}
public static boolean wordCheck(String word){

int n=word.length();
if(n.length()==0)
    return true;
    
    for(int i=0;i<n;i++){
    if((dictionary.contains(word.substring(0,i)))&&
    (dictionary.contains(word.substring(0,i)))))
    return true;
    
    }
    return false;

}
}
}
