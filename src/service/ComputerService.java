package service;

import java.util.List;

import model.Computer;

public interface ComputerService {
	
	List<Computer> getAll();
	
	Computer getById(Long id);

	void insert(Computer user);

}
