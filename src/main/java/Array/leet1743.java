package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 题目描述
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class leet1743 {


    //构建哈希表  存放元素及其相邻元素的映射关系
    Map<Integer, List<Integer>> container = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        // 哈希表
        int len = adjacentPairs.length;
        // 边界判断
        if(len==1){
            return adjacentPairs[0];
        }

        int[] result = new int[len+1];

        // 放入哈希表
        for(int i=0;i<len;i++){
            int[] currArr = adjacentPairs[i];
            // 存映射关系
            this.putVal(currArr[0],currArr[1]);
            this.putVal(currArr[1],currArr[0]);
        }

        // 找到首尾
        Map.Entry<Integer, List<Integer>> entry = this.container.entrySet().stream().filter(en-> en.getValue().size() == 1).findFirst().get();
        result[0] = entry.getKey();
        result[1] = entry.getValue().get(0);

        // 组装原数组
        for(int i=2;i<=len;i++){
            int last = result[i-1];
            int pre = result[i-2];
            // 取出映射关系
            List<Integer> mapping = this.container.get(last);
            result[i] = mapping.get(0) == pre ? mapping.get(1) : mapping.get(0);
        }
        return result;
    }
    // 向缓存容器中放键对值
    public void putVal(Integer key, Integer val){
        List<Integer> list = this.container.get(key);
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(val);
        this.container.put(key,list);
    }



    public static void main(String[] args) {

    }

}


