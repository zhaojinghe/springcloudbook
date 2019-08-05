package com.bjpowernode.po;

import java.util.Date;

public class OsOrderStatus {
    private Long orderStatusId;

    private Long orderId;

    private Byte orderStatus;

    private Date createTime;

    private Byte createStatus;

    private String remarks;
 
    private int is_pay;
    private String subject;
    private Date buy_time;


    public int getIs_pay() {
		return is_pay;
	}

	public void setIs_pay(int is_pay) {
		this.is_pay = is_pay;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(Date buy_time) {
		this.buy_time = buy_time;
	}

	public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(Byte createStatus) {
        this.createStatus = createStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}