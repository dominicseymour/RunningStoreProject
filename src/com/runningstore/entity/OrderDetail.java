package com.runningstore.entity;
// Generated 14 May 2020, 14:19:44 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail", catalog = "runningstoredb")
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private OrderDetailId id;
	private Trainer trainer;
	private TrainerOrder trainerOrder;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id, Trainer trainer, TrainerOrder trainerOrder) {
		this.id = id;
		this.trainer = trainer;
		this.trainerOrder = trainerOrder;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
			@AttributeOverride(name = "trainerId", column = @Column(name = "trainer_id", nullable = false)),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity", nullable = false)),
			@AttributeOverride(name = "subTotal", column = @Column(name = "sub_total", nullable = false, precision = 12, scale = 0)) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trainer_id", nullable = false, insertable = false, updatable = false)
	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	public TrainerOrder getTrainerOrder() {
		return this.trainerOrder;
	}

	public void setTrainerOrder(TrainerOrder trainerOrder) {
		this.trainerOrder = trainerOrder;
	}

}
