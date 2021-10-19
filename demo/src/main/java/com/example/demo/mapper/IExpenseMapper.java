package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.ExpenseDTO;
import com.example.demo.entity.ExpenseEntity;

@Mapper(componentModel = "spring")
public interface IExpenseMapper {
	IExpenseMapper INSTANCE = Mappers.getMapper( IExpenseMapper.class );
	
	public ExpenseDTO convertToDTO(ExpenseEntity expenseEntity);
	
	public ExpenseEntity convertToEntity(ExpenseDTO expenseEntity);
	
	public List<ExpenseDTO> convertToDTOs(List<ExpenseEntity> expenseEntities);
	
	public List<ExpenseEntity> convertToEntities(List<ExpenseDTO> expenseDTOs);
}
