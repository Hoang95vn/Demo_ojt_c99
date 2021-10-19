package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "Expense")
public class ExpenseEntity extends StandardEntity {
	
	@Column(name = "title", length = 50)
	private String title;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "amount")
	private double amount; 

}
