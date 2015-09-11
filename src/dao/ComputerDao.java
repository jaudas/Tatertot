package dao;

import java.util.List;

import model.Computer;

public interface ComputerDao {

	List<Computer> getAll();

	void create(Computer user);
}
