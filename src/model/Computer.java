package model;

import java.sql.Timestamp;
import java.util.Date;

public class Computer {
	private Long idComputer;
	private String nameComputer;
	private Date introduced;
	private Date discontinued;
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
	
	@Override
	public String toString() {
		return "Computer [idComputer=" + idComputer + ", nameComputer=" + nameComputer + ", introduced=" + introduced
				+ ", discontinued=" + discontinued + ", company=" + company + "]";
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

	public Date getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}

	public Date getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	
}
