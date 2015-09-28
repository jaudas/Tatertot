package service;

import java.util.List;

import dao.ComputerDao;
import dao.ComputerDaoImpl;
import model.Computer;

public class ComputerServiceImpl implements ComputerService {
	private ComputerDao computerDao;
	private static ComputerService INSTANCE = null;
	
	private ComputerServiceImpl(){
		this.computerDao = ComputerDaoImpl.getInstance();
	}

	@Override
	public List<Computer> getAll() {
		return computerDao.getAll();
	}

	@Override
	public Computer getById(Long id) {
		return computerDao.getById(id);
	}

	@Override
	public void insert(Computer computer) {
		computerDao.insert(computer);
	}
	
	public static ComputerService getInstance(){
		if (INSTANCE == null){
			INSTANCE = new ComputerServiceImpl();
		}
		return INSTANCE;
	}

	@Override
	public List<Computer> getAll(int offset, int noOfRecords, String searchString) {
		return computerDao.getAll(offset, noOfRecords, searchString);
		
	}

}
