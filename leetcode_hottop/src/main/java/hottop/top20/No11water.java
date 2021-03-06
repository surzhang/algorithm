package hottop.top20;

/**
 * @ fileName:No11water
 * @ description:盛最多水的容器
 * @ author:zyk
 * @ createTime:2021/12/10 21:00
 * @ version:1.0.0
 */
public class No11water {
    public int maxArea(int[]height){
        int max=0;
        for (int i=0,j=height.length-1;i<j;){
            int minHeight=height[i]<height[j]?height[i++]:height[j--];
            int area = (j-i+1)*minHeight;
            max=Math.max(max,area);
        }
        return max;
    }

}
