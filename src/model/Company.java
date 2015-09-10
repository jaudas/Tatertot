package model;

public class Company {
	
	private Long idCompany;
	private String nameCompany;
	

	public Company(Long idCompany, String nameCompany) {
		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
	}

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	
	

}