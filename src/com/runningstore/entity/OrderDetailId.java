package com.runningstore.entity;
// Generated 14 May 2020, 14:19:44 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailId generated by hbm2java
 */
@Embeddable
public class OrderDetailId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int orderId;
	private int trainerId;
	private int quantity;
	private float subTotal;

	public OrderDetailId() {
	}

	public OrderDetailId(int orderId, int trainerId, int quantity, float subTotal) {
		this.orderId = orderId;
		this.trainerId = trainerId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	@Column(name = "order_id", nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "trainer_id", nullable = false)
	public int getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "sub_total", nullable = false, precision = 12, scale = 0)
	public float getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailId))
			return false;
		OrderDetailId castOther = (OrderDetailId) other;

		return (this.getOrderId() == castOther.getOrderId()) && (this.getTrainerId() == castOther.getTrainerId())
				&& (this.getQuantity() == castOther.getQuantity()) && (this.getSubTotal() == castOther.getSubTotal());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderId();
		result = 37 * result + this.getTrainerId();
		result = 37 * result + this.getQuantity();
		result = 37 * result + (int) this.getSubTotal();
		return result;
	}

}
