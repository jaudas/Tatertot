package main;

import dao.ComputerDao;
import dao.ComputerDaoImpl;

public class Main {
	
	public static void main (String[] args){
		ComputerDao computerDao = ComputerDaoImpl.getInstance();
		computerDao.getAll();
	}

}
