package com.runningstore.entity;
// Generated 14 May 2020, 14:19:44 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "category", catalog = "runningstoredb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries({
	@NamedQuery(name="Category.findAll", query="SELECT c from Category c ORDER BY c.name"),
	@NamedQuery(name="Category.countAll", query="SELECT COUNT(c) FROM Category c"),
	@NamedQuery(name="Category.findByName", query="SELECT c from Category c WHERE c.name = :name")
})
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer categoryId;
	private String name;
	private Set<Trainer> trainers = new HashSet<Trainer>(0);

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(Integer categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public Category(String name, Set<Trainer> trainers) {
		this.name = name;
		this.trainers = trainers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", unique = true, nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Trainer> getTrainers() {
		return this.trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

}
