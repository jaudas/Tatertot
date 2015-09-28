package service;

import java.util.List;
import model.Computer;

public interface ComputerService {
	
	List<Computer> getAll();
	List<Computer> getAll(int offset, 
            int noOfRecords,
            String searchString);
	
	Computer getById(Long id);

	void insert(Computer computer);
	void delete(Long idComputer);


}
