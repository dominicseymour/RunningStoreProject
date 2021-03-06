package com.runningstore.entity;

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "trainer", catalog = "runningstoredb", uniqueConstraints = @UniqueConstraint(columnNames = "brand"))
@NamedQueries({
	@NamedQuery(name="Trainer.findAll", query="SELECT t from Trainer t ORDER BY t.brand"),
	@NamedQuery(name="Trainer.findByModel", query="SELECT t from Trainer t WHERE t.model = :model"),
	@NamedQuery(name="Trainer.countAll", query="SELECT COUNT(t) FROM Trainer t"),
})

public class Trainer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer trainerId;
	private Category category;
	private String brand;
	private String model;
	private String description;
	private byte[] image;
	private String base64Image;
	private float price;
	private Date releaseDate;
	private Date lastUpdatedOn;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Trainer() {
	}

	public Trainer(Category category, String brand, String model, String description, byte[] image, float price,
			Date releaseDate, Date lastUpdatedOn) {
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.image = image;
		this.price = price;
		this.releaseDate = releaseDate;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Trainer(Category category, String brand, String model, String description, byte[] image, float price,
			Date releaseDate, Date lastUpdatedOn, Set<Review> reviews, Set<OrderDetail> orderDetails) {
		this.category = category;
		this.brand = brand;
		this.model = model;
		this.description = description;
		this.image = image;
		this.price = price;
		this.releaseDate = releaseDate;
		this.lastUpdatedOn = lastUpdatedOn;
		this.reviews = reviews;
		this.orderDetails = orderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "trainer_id", unique = true, nullable = false)
	public Integer getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "brand", unique = true, nullable = false, length = 64)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "model", nullable = false, length = 64)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "release_date", nullable = false, length = 10)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_on", nullable = false, length = 19)
	public Date getLastUpdatedOn() {
		return this.lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}

	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	
}
