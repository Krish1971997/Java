
public class LeetcodeMedianofTwoSortedArrays {
public static void main(String[] args){
int nums1 [] = {1,3}, nums2[] = {2};
int mergedArray=new int[nums1+nums2];
double res=0.00000;
for(int i=0,j=0,k=0;i<mergedArray.length;i++){
if(nums1.length>i)
mergedArray[j++]=nums[i];
else
mergedArray[j++]=nums[k++];
}
Arrays.sort(mergedArray);
if(mergedArray.length%2==0){
int divide=mergedArray.length/2;
res=(mergedArray[divide]+mergedArray[divide-1])/2;

}else{
int divide=mergedArray.length/2;
res=mergedArray[divide];
}
System.out.println("Result ---> "+res);

}    
}
