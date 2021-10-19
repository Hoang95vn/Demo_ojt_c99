package com.example.demo.service;

import java.util.List;

public interface IApiService<T> {

	public T saveOrUpdate(T object);

	public T getById(long id);

	public List<T> getAll();

	public boolean deleteById(long id);
}
