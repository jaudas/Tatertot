package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import model.Company;
import model.Computer;

import utils.FormatUtils;

public class ComputerDaoImpl implements ComputerDao {
	

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/computer-database-db?zeroDateTimeBehavior=convertToNull";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static ComputerDao INSTANCE;
	
	static{
		//Driver
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e){
			throw new RuntimeException ("Can not load Driver", e);
		}
		
	}
	
	private ComputerDaoImpl(){
		
	}


	@Override
	public List<Computer> getAll() {

		List<Computer> listComputer = new LinkedList<Computer>() ;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM computer LEFT JOIN company ON company.id = computer.company_id;";
			resultSet = statement.executeQuery(sql);
			
			//Lecture du resultSet
			while (resultSet.next()){
				
				//Lecture de la table ordinateur
				Long idComputer = resultSet.getLong("computer.id");				
				String nameComputer = resultSet.getString("computer.name");
				Timestamp introduced = resultSet.getTimestamp("computer.introduced");
				Timestamp discontinued = resultSet.getTimestamp("computer.discontinued");
				
				
				//Lecture de la table company
				Long idCompany = resultSet.getLong("company.id");				
				String nameCompany = resultSet.getString("company.name");
				Company company = new Company(idCompany, nameCompany);
				
				//Création de l'objet computer
				Computer c = new Computer();
				c.setIdComputer(idComputer);
				c.setNameComputer(nameComputer);
				c.setIntroduced(FormatUtils.timeStampToDate(introduced));
				c.setDiscontinued(FormatUtils.timeStampToDate(discontinued));
				c.setCompany(company);
				
				System.out.println("/n L'ordinateur : " + c);
				

				
				listComputer.add(c);
			}

		    System.out.println(resultSet);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoUtils.closeAll(resultSet, statement, connection);
		}
		
		
		
		return listComputer;
	}

	
	
	public static ComputerDao getInstance(){
		if(INSTANCE == null){
			INSTANCE = new ComputerDaoImpl();
		}
		
		return INSTANCE;
	}


	@Override
	public Computer getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(Computer computer) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void create(Computer Computer) {
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		
		try{
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "INSERT INTO user (id, login, password) VALUES (NULL,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.execute();
			
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoUtils.closeAll(resultSet, statement, connection);
		}
		
	}*/

}
