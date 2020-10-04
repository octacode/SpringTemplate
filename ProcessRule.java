import java.util.*;

class ProcessRule {
  public static int waterArea(int[] heights) {
  int area = 0;
  int maxL[] = getMaxAr(heights, true);
  int maxR[] = getMaxAr(heights, false);
  for (int i=0; i<heights.length; i++) {
    int water = getWaterForIndex(i, heights, maxL, maxR);
    if (water > 0)
    area+=water;
  }
  return area;
    }
}
