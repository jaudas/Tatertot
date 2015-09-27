package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import model.Company;
import model.Computer;
import utils.FormatUtils;

/*import javax.persistence.EntityManagerFactory;
 import javax.persistence.EntityManager;
 import model.manager.DaoManager;*/

public class ComputerDaoImpl implements ComputerDao {

	private static final String URL = "jdbc:mysql://127.0.0.1:8889/computer-database-db?zeroDateTimeBehavior=convertToNull";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static ComputerDao INSTANCE;

	static {
		// Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new RuntimeException("Can not load Driver", e);
		}

	}

	private int noOfRecords;

	private ComputerDaoImpl() {

	}

	/** HIBERNATE **/
	@Override
	public List<Computer> getAll() {

		List<Computer> listComputer = new LinkedList<Computer>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM computer LEFT JOIN company ON company.id = computer.company_id;";
			resultSet = statement.executeQuery(sql);

			// Lecture du resultSet
			while (resultSet.next()) {

				// Lecture de la table ordinateur
				Long idComputer = resultSet.getLong("computer.id");
				String nameComputer = resultSet.getString("computer.name");
				Timestamp introduced = resultSet
						.getTimestamp("computer.introduced");
				Timestamp discontinued = resultSet
						.getTimestamp("computer.discontinued");

				// Lecture de la table company
				int idCompany = resultSet.getInt("company.id");
				String nameCompany = resultSet.getString("company.name");
				Company company = new Company(idCompany, nameCompany);

				// Cr�ation de l'objet computer
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoUtils.closeAll(resultSet, statement, connection);
		}

		return listComputer;
	}

	
	
	public List<Computer> getAll(
            int offset, 
            int noOfRecords){

		List<Computer> listComputer = new LinkedList<Computer>() ;
		
		Connection connection = null;
		Statement statement = null;

		String query = "select SQL_CALC_FOUND_ROWS * from computer LEFT JOIN company ON company.id = computer.company_id limit "
				+ offset + ", " + noOfRecords;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				// Lecture de la table ordinateur
				Long idComputer = resultSet.getLong("computer.id");
				String nameComputer = resultSet.getString("computer.name");
				Timestamp introduced = resultSet
						.getTimestamp("computer.introduced");
				Timestamp discontinued = resultSet
						.getTimestamp("computer.discontinued");

				// Lecture de la table company
				int idCompany = resultSet.getInt("company.id");
				String nameCompany = resultSet.getString("company.name");
				Company company = new Company(idCompany, nameCompany);

				// Cr�ation de l'objet computer
				Computer c = new Computer();
				c.setIdComputer(idComputer);
				c.setNameComputer(nameComputer);
				c.setIntroduced(FormatUtils.timeStampToDate(introduced));
				c.setDiscontinued(FormatUtils.timeStampToDate(discontinued));
				c.setCompany(company);
				listComputer.add(c);
				System.out.println(c.toString());
			}
			resultSet.close();
			System.out.println("Nb ordi : " + listComputer.size());

			resultSet = statement.executeQuery("SELECT FOUND_ROWS()");
			if (resultSet.next())
				this.noOfRecords = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listComputer;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	/*
	 * @SuppressWarnings("unchecked") public List<Computer> getAll(){
	 * EntityManagerFactory entityManagerFactory =
	 * DaoManager.getInstance().getEntityManagerFactory(); EntityManager
	 * entityManager = entityManagerFactory.createEntityManager(); return
	 * entityManager.createQuery("select c from Computer c").getResultList();
	 * 
	 * }
	 */

	public static ComputerDao getInstance() {
		if (INSTANCE == null) {
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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "INSERT INTO computer (id, name, introduced, discontinued, company_id) VALUES (NULL,?,?,?,?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, computer.getNameComputer());
			statement.setTimestamp(2,
					FormatUtils.dateToTimestamp(computer.getIntroduced()));
			statement.setTimestamp(3,
					FormatUtils.dateToTimestamp(computer.getDiscontinued()));
			statement.setLong(4, computer.getCompany().getIdCompany());
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoUtils.closeAll(resultSet, statement, connection);
		}

	}


}
