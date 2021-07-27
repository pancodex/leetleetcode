package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1713 {
    public static int minOperations(int[] target, int[] arr) {
        // 数组 若干互不相同整数，以及另一个整数数组arr,arr有重复元素
        // 每次操作中可以在arr任意位置插证书，
        // 请返回最少操作次数，使得target成为arr的一个子序列
        // 动态规划？

        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<Integer,Integer>();
        // 把target的值按下标存进哈希表
        for(int i=0;i<n;i++){
            pos.put(target[i],i);
        }

        List<Integer> d = new ArrayList<Integer>();
        for(int val : arr){
            // 判断数组中出现的数字在pos中有无出现
            if(pos.containsKey(val)) {
                // 若有出现，取出值所对应的下标
                int idx = pos.get(val);
                // 找出idx在d中的位置，通过二分查找
                int it = binarySearch(d, idx);
                if(it != d.size()){
                    // 若it!= d.size()  则替换it的映射
                    d.set(it, idx);
                }else{
                    // 否则将下标加入d
                    d.add(idx);
                }
            }
        }
        return n - d.size();
    }

    public static int binarySearch(List<Integer> d, int target){
        int size = d.size();
        if( size==0 || d.get(size-1) < target){
            return size;
        }
        int low = 0, high = size - 1;
        while(low<high){
            int mid = (high - low) / 2 + low;
            if(d.get(mid) < target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] target = {6,4,8,1,2,3};
        int[] arr = {4,7,6,2,3,8,6,1};


        System.out.println(minOperations(target,arr));
    }
}
