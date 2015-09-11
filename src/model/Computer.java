package model;

import java.sql.Timestamp;

public class Computer {
	private Long idComputer;
	private String nameComputer;
	private Timestamp introduced;
	private Timestamp discontinued;
	private Long companyId;
	private String companyName;



	public Computer(Long idComputer, String nameComputer, Timestamp introduced,
			Timestamp discontinued, Long companyId) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.companyId = companyId;

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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long company_id) {
		this.companyId = company_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
}
