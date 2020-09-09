package com.yc.bean3_datatype3.QueueType.priorityqueue;

// 商家被投诉次数实体类
class ComplainCount {
    // 商家id
    public Integer storeId;
    // 投诉次数
    public Integer complainCount;

    ComplainCount(Integer storeId, Integer complainCount) {
        this.storeId = storeId;
        this.complainCount = complainCount;
    }
}
