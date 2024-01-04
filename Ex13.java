import javax.print.DocFlavor.STRING;

class Ex13 {

  public static void main(String[] args) {
    int [] arr = {-8,1,-4,11,9,-15,10,8,-3};
    maxMul3(arr);

    // int [] a1 = {1,12,15,26,38};
    // int [] a2 = {12,13,18,30,45};
    // findMedian(a1, a2);

    String str = "hello world";
    System.out.println(str.substring(6));
  }


  // Q1
  //time = O(n)
  //place = O(1)
  public static int maxMul3 (int [] arr){
    int i=0 , j=1 , x=2 ;
    int num1=0 , num2=0 , num3=0;
    int sunMul = arr[i] * arr[j] * arr[x];

    if(arr.length < 3){
      return Integer.MIN_VALUE;
    }

    while(i<arr.length-3){
      if(arr[i] * arr[j] * arr[x] > sunMul){
        sunMul = arr[i] * arr[j] * arr[x];
        num1 = arr[i];
        num2 = arr[j];
        num3 = arr[x];
      }else{
        x++;
      }

      if(x==arr.length-1){
        j++;
        x = j+1;
      }

      if(j==arr.length-2){
        i++;
        j = i+1;
        x = j+1;
      }
    }
    System.out.println(num1 + " * " + num2 + " * " + num3 + " = " + sunMul);
    return sunMul;
  }


  // Q2
  // public static int findMedian (int[] arr1, int[] arr2){
  //   int low = 0 , high = arr1.length+arr2.length , mid = (arr1.length + arr2.length)/2;
  //   System.out.println(low);
  //   System.out.println(mid);
  //   System.out.println(high);

  //   while(low<=high){

  //   }
    
  //   return mid;
  // }
}
