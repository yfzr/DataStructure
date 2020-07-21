/** 以下代码由代码生成器自动生成，如无必要，请勿修改！Jun 17, 2020 10:20:30 AM **/
package com.gaohuan.javalearn.springDefaultValue;

import java.time.LocalDateTime;

/**
 * 数据库实体，充电记录表
 */
public class NewChargingRecordInfoEntity {

	/**
	 * 编号
	 */
	private Long id;
	
	/**
	 * 订单编号
	 */
	private String orderId;
	
	/**
	 * 设备编号
	 */
	private String deviceId;
	
	/**
	 * 设备名称
	 */
	private String deviceName;
	
	/**
	 * 开始充电时间
	 */
	private LocalDateTime startTime;
	
	/**
	 * 结束充电时间
	 */
	private LocalDateTime endTime;
	
	/**
	 * 充电时长(毫秒)
	 */
	private Long longTime;
	
	/**
	 * 充电时长(文本)
	 */
	private String longTimeText;
	
	/**
	 * 充电总量
	 */
	private Double electrTotal;
	
	/**
	 * 充电状态
            0、充电中
            1、待支付
            2、已结束
	 */
	private Integer status;
	
	/**
	 * 充电费用
	 */
	private Double money;
	
	/**
	 * 支付时间
	 */
	private LocalDateTime payTime;
	
	/**
	 * 用户编号
	 */
	private Long userId;
	
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	
	/**
	 * 修改时间
	 */
	private LocalDateTime modifiedTime;

	public NewChargingRecordInfoEntity() {
		this.createTime=LocalDateTime.now();
		this.modifiedTime=LocalDateTime.now();
		this.payTime=LocalDateTime.now();
		this.startTime=LocalDateTime.now();
		this.endTime=LocalDateTime.now();
	}
	
	/**
	 * 获取编号
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 获取订单编号
	 */
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 获取设备编号
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * 获取设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * 获取开始充电时间
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	/**
	 * 获取结束充电时间
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	/**
	 * 获取充电时长(毫秒)
	 */
	public Long getLongTime() {
		return longTime;
	}
	
	/**
	 * 获取充电时长(文本)
	 */
	public String getLongTimeText() {
		return longTimeText;
	}
	
	/**
	 * 获取充电总量
	 */
	public Double getElectrTotal() {
		return electrTotal;
	}
	
	/**
	 * 获取充电状态
            0、充电中
            1、待支付
            2、已结束
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 获取充电费用
	 */
	public Double getMoney() {
		return money;
	}
	
	/**
	 * 获取支付时间
	 */
	public LocalDateTime getPayTime() {
		return payTime;
	}
	
	/**
	 * 获取用户编号
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 获取创建时间
	 */
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
	/**
	 * 获取修改时间
	 */
	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}
	
	/**
	 * 设置编号
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置订单编号
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 设置设备编号
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 设置设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * 设置开始充电时间
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * 设置结束充电时间
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * 设置充电时长(毫秒)
	 */
	public void setLongTime(Long longTime) {
		this.longTime = longTime;
	}

	/**
	 * 设置充电时长(文本)
	 */
	public void setLongTimeText(String longTimeText) {
		this.longTimeText = longTimeText;
	}

	/**
	 * 设置充电总量
	 */
	public void setElectrTotal(Double electrTotal) {
		this.electrTotal = electrTotal;
	}

	/**
	 * 设置充电状态
            0、充电中
            1、待支付
            2、已结束
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设置充电费用
	 */
	public void setMoney(Double money) {
		this.money = money;
	}

	/**
	 * 设置支付时间
	 */
	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	/**
	 * 设置用户编号
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置修改时间
	 */
	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "NewChargingRecordInfoEntity{" +
				"id=" + id +
				", orderId='" + orderId + '\'' +
				", deviceId='" + deviceId + '\'' +
				", deviceName='" + deviceName + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", longTime=" + longTime +
				", longTimeText='" + longTimeText + '\'' +
				", electrTotal=" + electrTotal +
				", status=" + status +
				", money=" + money +
				", payTime=" + payTime +
				", userId=" + userId +
				", createTime=" + createTime +
				", modifiedTime=" + modifiedTime +
				'}';
	}

	public static void main(String[] args) {
		NewChargingRecordInfoEntity entity = new NewChargingRecordInfoEntity();
		System.out.println(entity.toString());
	}
}
