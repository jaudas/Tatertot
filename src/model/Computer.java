package model;

import java.sql.Timestamp;

public class Computer {
	private Long idComputer;
	private String nameComputer;
	private Timestamp introduced;
	private Timestamp discontinued;
	private Company company;



	public Computer(Long idComputer, String nameComputer, Timestamp introduced,
			Timestamp discontinued, Company company) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;

	}
	
	public Computer(){
		
	}
	
	


	public Long getIdComputer() {
		return idComputer;
	}

	public void setIdComputer(Long idComputer) {
		this.idComputer = idComputer;
	}

	public String getNameComputer() {
		return nameComputer;
	}

	public void setNameComputer(String nameComputer) {
		this.nameComputer = nameComputer;
	}

	public Timestamp getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}

	public Timestamp getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	
}
