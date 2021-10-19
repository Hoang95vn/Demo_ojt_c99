package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ExpenseEntity;

public interface IExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

}
