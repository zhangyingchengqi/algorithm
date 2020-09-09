package com.yc.bean3_datatype3.QueueType.priorityqueue;

// 投诉日志实体类
class ComplainLog {
    // 商家id
    public Integer storeId;
    // 商品id
    public Integer productId;
    // 投诉记录
    public String remark;

    ComplainLog(Integer storeId, Integer productId, String remark) {
        this.storeId = storeId;
        this.productId = productId;
        this.remark = remark;
    }
}
