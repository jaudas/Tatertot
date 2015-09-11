package dao;

import java.util.List;

import model.Computer;

public interface ComputerDao {

	List<Computer> getAll();

	Computer getById(Long id);

	void insert(Computer computer);
}
