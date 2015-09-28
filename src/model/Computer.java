package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Computers")
public class Computer {
	@Id
	private Long idComputer;
	private String nameComputer;
	private String introduced;
	private String discontinued;
	private Company company;



	public Computer(Long idComputer, String nameComputer, String introduced,
			String discontinued, Company company) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.introduced = introduced;
		this.discontinued = discontinued; 
		this.company = company;

	}
	
	public Computer(){
		
	}

	
	@Override
	public String toString() {
		return "Computer [idComputer=" + idComputer + ", nameComputer=" + nameComputer + ", introduced=" + introduced
				+ ", discontinued=" + discontinued + ", company=" + company + "]";
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

	public String getIntroduced() {
		return introduced;
	}

	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	
}
