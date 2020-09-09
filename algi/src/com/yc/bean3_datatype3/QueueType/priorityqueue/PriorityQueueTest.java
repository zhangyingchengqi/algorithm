package com.yc.bean3_datatype3.QueueType.priorityqueue;

import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {
        // 模拟10条投诉记录
        ComplainLog log1 = new ComplainLog(101, 8650, "质量不行");
        ComplainLog log2 = new ComplainLog(101, 8651, "书皮烂了，垃圾物流");
        ComplainLog log3 = new ComplainLog(101, 7921, "牛肉不新鲜，怀疑是假货");
        ComplainLog log4 = new ComplainLog(101, 7963, "卖假货，封了他家店！！！");
        ComplainLog log5 = new ComplainLog(102, 6217, "店家态度不好，给他降权");
        ComplainLog log6 = new ComplainLog(102, 6245, "衣服撕了。。。");
        ComplainLog log7 = new ComplainLog(102, 5214, "就是想投诉");
        ComplainLog log8 = new ComplainLog(103, 5215, "。。。");
        ComplainLog log9 = new ComplainLog(104, 4632, "2333333");
        ComplainLog log10 = new ComplainLog(104, 4632, "有人吗");
        ComplainLog log11 = new ComplainLog(104, 4632, "有人吗,aaaaaa");

        List<ComplainLog> complainLogList = new ArrayList<ComplainLog>();
        complainLogList.add(log1);
        complainLogList.add(log2);
        complainLogList.add(log3);
        complainLogList.add(log4);
        complainLogList.add(log5);
        complainLogList.add(log6);
        complainLogList.add(log7);
        complainLogList.add(log8);
        complainLogList.add(log9);
        complainLogList.add(log10);
        complainLogList.add(log11);
        // 统计出每家店铺的投诉次数
        HashMap<Integer, Integer> complainCountMap = new HashMap<Integer, Integer>();
        for (ComplainLog complainLog : complainLogList) {
            if (complainCountMap.get(complainLog.storeId) == null) {
                complainCountMap.put(complainLog.storeId, 1);
            } else {
                complainCountMap.put(complainLog.storeId, complainCountMap.get(complainLog.storeId) + 1);
            }
        }
        List<ComplainCount> complainCountList = new ArrayList<ComplainCount>();
        for (Map.Entry<Integer, Integer> entry : complainCountMap.entrySet()) {
            ComplainCount complainCount = new ComplainCount(entry.getKey(), entry.getValue());
            complainCountList.add(complainCount);
        }
        // 通过PriorityQueue找出投诉记录最多的前3个商家
        PriorityQueue<ComplainCount> queue = new PriorityQueue<ComplainCount>(new Comparator<ComplainCount>() {
            @Override
            public int compare(ComplainCount o1, ComplainCount o2) {
                return o1.complainCount.compareTo(o2.complainCount);
            }
        });
        // 创建一个小根堆（PriorityQueue默认就是小根堆）
        // 小根堆中元素的数量小于3的时候就直接向集合中添加元素
        // 当堆中的元素个数等于3的时候，通过peek方法取出堆顶元素（最小的那个）与当前遍历到的元素比较
        // 如果当前遍历到的元素大于堆顶元素，就把原堆顶元素移除，把当前元素加入堆中
        // 移除的元素都小于堆中的元素
        // 所以最后堆中保留下来的就是最大的N个元素
        int topN = 3;
        for (ComplainCount complainCount : complainCountList) {
            if (queue.size() < topN) {
                queue.offer(complainCount);
            } else {
                if (queue.peek().complainCount < complainCount.complainCount) {
                    queue.poll();
                    queue.offer(complainCount);
                }
            }
        }
        for (ComplainCount complainCount : queue) {
            System.out.println(complainCount.storeId + ":" + complainCount.complainCount);
        }

    }
}
