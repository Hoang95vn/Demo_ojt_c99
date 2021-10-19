package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.IExpenseService;

@RestController
@CrossOrigin
public class ExpneseController {

	@Autowired
	IExpenseService expenseService;

	@GetMapping(value = "/expenses")
	public ResponseEntity<List<ExpenseDTO>> getAllExpense() {
		List<ExpenseDTO> expenseDTOs = expenseService.getAll();

		// Check null and return
		if (expenseDTOs != null) {
			return ResponseEntity.ok(expenseDTOs);
		} else {
			throw new NotFoundException("Expense list is null");
		}
	}

	@GetMapping(value = "/expenses/{id}")
	public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable(name = "id") long id) {
		ExpenseDTO expenseDTO = expenseService.getById(id);
		return ResponseEntity.ok(expenseDTO);
	}

	@PostMapping(value = "/expenses")
	public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
		if (expenseDTO == null)
			throw new IllegalArgumentException("Create new Expense fail because the input expense is null!");
		ExpenseDTO result = expenseService.saveOrUpdate(expenseDTO);
		return ResponseEntity.ok(result);
	}

	@PutMapping(value = "/expenses")
	public ResponseEntity<ExpenseDTO> updateExpense(@RequestBody ExpenseDTO expenseDTO) {
		if (expenseDTO == null)
			throw new IllegalArgumentException("Update Expense fail because the input expense is null!");
		if (expenseDTO.getId() == null)
			throw new IllegalArgumentException("Update Expense fail because the input expense is null!");
		ExpenseDTO result = expenseService.saveOrUpdate(expenseDTO);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping(value = "/expenses/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable(name = "id") long id) {
		expenseService.deleteById(id);
		return ResponseEntity.ok("Success");
	}

}
