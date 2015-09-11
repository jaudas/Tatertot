package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;



import model.Computer;


public class ComputerDaoImpl implements ComputerDao {
	

	private static final String URL = "jdbc:mysql://127.0.0.1/computer-database-db";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static ComputerDao INSTANCE;
	
	static{
		//Driver
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e){
			throw new RuntimeException ("Can not load Driver", e);
		}
		
	}


	@Override
	public List<Computer> getAll() {

		List<Computer> listComputer = null ;
		
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
				
				Long idComputer = resultSet.getLong("id");				
				String nameComputer = resultSet.getString("name");
				Timestamp introduced = resultSet.getTimestamp("introducted");
				Timestamp discontinued = resultSet.getTimestamp("discontinued");
				Long idCompany = resultSet.getLong("id");
				String companyName = resultSet.getString("company.name");
				
				Computer c = new Computer();
				c.setIdComputer(idComputer);
				
				c.setCompanyId(idComputer);
				c.setNameComputer(nameComputer);
				c.setIntroduced(introduced);
				c.setDiscontinued(discontinued);
				c.setCompanyId(idCompany);
				

				
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
	public void create(Computer user) {
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
