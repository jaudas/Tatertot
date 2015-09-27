package dao;

import java.util.List;

import model.Computer;

public interface ComputerDao {

	List<Computer> getAll();
	List<Computer> getAll(int offset, int noOfRecords);

	Computer getById(Long id);
	

	void insert(Computer computer);
	int getNoOfRecords();
}
