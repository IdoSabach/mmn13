
class Ex13 {

  // Q1

  /* In this method I receive an array as a parameter and look for 
  three numbers in this array whose product is the highest, 
  and I return the sum. */

  // time = O(n)
  // place = O(1)

  public static int maxMul3(int[] arr) {
    int i = 0, j = 1, x = 2;
    int num1 = 0, num2 = 0, num3 = 0;
    int sunMul = arr[i] * arr[j] * arr[x];

    if (arr.length < 3) {
      return Integer.MIN_VALUE;
    }

    while (i < arr.length - 3) {
      if (arr[i] * arr[j] * arr[x] > sunMul) {
        sunMul = arr[i] * arr[j] * arr[x];
        num1 = arr[i];
        num2 = arr[j];
        num3 = arr[x];
      } else {
        x++;
      }

      if (x == arr.length - 1) {
        j++;
        x = j + 1;
      }

      if (j == arr.length - 2) {
        i++;
        j = i + 1;
        x = j + 1;
      }
    }
    System.out.println(num1 + " * " + num2 + " * " + num3 + " = " + sunMul);
    return sunMul;
  }


  // Q2

  /* In this method I receive two arrays as a parameter 
  and search in these arrays for the middle of the two 
  and return the average number of their middle i.e. median. */

  // time = O(n) i need O(Log(n))
  // place = O(1)
  
  public static int findMedian(int[] arr1, int[] arr2) {
    int n = arr1.length + arr2.length;
    int[] mergedArray = new int[n];

    int i = 0, j = 0, k = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] <= arr2[j]) {
        mergedArray[k++] = arr1[i++];
      } else {
        mergedArray[k++] = arr2[j++];
      }
    }

    int median = mergedArray.length /2;

    if(mergedArray.length % 2 == 1 ){
      return mergedArray[median];
    }else{
      return (mergedArray[median] + mergedArray[median-1]) / 2;
    }
  }


  // Q3


  // Q4

  /* In this method I get a 2D array as a parameter and go
   through each cell recursively and look for the longest route to the last cell, 
   returning the longest route in number. */ 

  public static int maxSnake(int[][] mat) {
    int sum = maxSnake(mat, 0, 0, mat[0][0], 1);
    if (sum <= 1) {
      return Integer.MIN_VALUE;
    } else {
      return sum;
    }
  }

  private static int maxSnake(int[][] mat, int i, int j, int prev, int lengthWay) {
    if (i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1 || mat[i][j] == -1) {
      return Integer.MIN_VALUE;
    }

    if (i == mat.length - 1 && j == mat[0].length - 1) {
      return 0;
    }

    int current = mat[i][j];

    if (Math.abs(current - prev) == 1 || current == prev) {
      mat[i][j] = -1;

      int down = maxSnake(mat, i + 1, j, current, lengthWay + 1);
      int right = maxSnake(mat, i, j + 1, current, lengthWay + 1);
      int up = maxSnake(mat, i - 1, j, current, lengthWay + 1);
      int left = maxSnake(mat, i, j - 1, current, lengthWay + 1);

      mat[i][j] = current;

      return Math.max(Math.max(down, right), Math.max(up, left));
    }
    return lengthWay;
  }



   public static void main(String[] args) {
    int[] arr = { -8, 1, -4, 11, 9, -15, 10, 8, -3 };
    maxMul3(arr);
    int[][] mat = {
        { 4, 5, 2, 3, 1 },
        { 3, 4, 1, 4, 4 },
        { 1, 5, 6, 7, 8 },
        { 3, 4, 5, 8, 9 },
        { 3, 2, 2, 7, 6 }
    };
    System.out.println(maxSnake(mat));

    int[] a1 = { 1, 12, 15, 26, 38 };
    int[] a2 = { 12, 13, 18, 30, 45 };
    
    System.out.println(findMedian(a1, a2));

    // String str = "hello world";
    // System.out.println(str.substring(6));
  }

}
