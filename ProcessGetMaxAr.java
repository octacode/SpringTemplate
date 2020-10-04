import java.util.*;

class ProcessGetMaxAr {

private static int[] getMaxAr(int arr[], boolean isLeft) {
  int maxAr[] = new int[arr.length];
  if (arr == null || arr.length == 0)
  return arr;
  if (isLeft) {
  maxAr[0] = arr[0];
  for (int i=1; i<arr.length; i++) {
    if (arr[i] > maxAr[i-1])
    maxAr[i] = arr[i];
    else
      maxAr[i] = maxAr[i-1];
      }
  } else {
    maxAr[arr.length-1] = arr[arr.length-1];
    for (int i=arr.length-2; i>-1; i--) {
    if (arr[i] > maxAr[i+1])
      maxAr[i] = arr[i];
    else
      maxAr[i] = maxAr[i+1];
    }
  }
    return maxAr;
}

}
