package com.example.demo.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.mapper.IExpenseMapper;
import com.example.demo.repository.IExpenseRepository;
import com.example.demo.service.IExpenseService;

@Service
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired
	IExpenseRepository expenseRepository;

	@Override
	public ExpenseDTO saveOrUpdate(ExpenseDTO object) {
		ExpenseEntity entity = expenseRepository.save(IExpenseMapper.INSTANCE.convertToEntity(object));
		return IExpenseMapper.INSTANCE.convertToDTO(entity);

	}

	@Override
	public ExpenseDTO getById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("id is null");
		try {
			return IExpenseMapper.INSTANCE.convertToDTO(expenseRepository.getById(id));
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Expense with id: " + id + " is not found");
		}
	}

	@Override
	public List<ExpenseDTO> getAll() {
		return IExpenseMapper.INSTANCE.convertToDTOs(expenseRepository.findAll());
	}

	@Override
	public boolean deleteById(Long id) {
		try {
			expenseRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Delete Expense fail because id is null!!");
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException(
					"Delete Expense fail because have no Expense with id: " + id + " exists", 0);
		}

	}

}
