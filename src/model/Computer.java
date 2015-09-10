package model;

import java.sql.Timestamp;

public class Computer {
	private Long idComputer;
	private String nameComputer;
	private Timestamp introduced;
	private Timestamp discontinued;
	private Long company_id;
	

	public Computer(Long idComputer, String nameComputer, Timestamp introduced,
			Timestamp discontinued, Long company_id) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
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

	public Long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}

	
}