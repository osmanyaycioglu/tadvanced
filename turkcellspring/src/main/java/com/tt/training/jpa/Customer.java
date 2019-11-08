package com.tt.training.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;

@Entity
@Table(name = "Musteri",indexes = {@Index(name="isim_surname_index",columnList = "isim,age",unique = true)})
@SecondaryTable(name="MusteriEx")
public class Customer {
	@Id
	@GeneratedValue
	private long custId;

	@Size(min = 2,max=50,message = "sadhsd asdhjsad")
	@Column(name = "isim",nullable = true,unique = true,length = 50)
	private String name;
	@Column(table = "MusteriEx")
	private String surname;
	
	@Max(150)
	@Min(10)
	private int age;
	
	@OneToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL,mappedBy = "customer" )
	private ExtraInfo exraInfo;
	
	@OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL,mappedBy = "customer" )
	private List<Order> orders;
	
	@Embedded
	private CustomerInfo customerInfo;
	
	@PrePersist
	@PostPersist
	@PreUpdate
	@PostUpdate
	@PreRemove
	@PostRemove
	@PostLoad
	public void met() {
		System.out.println("");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	
}
