package model;

public class Company {
	
	private int idCompany;
	private String nameCompany;
	
	public Company(int idCompany, String nameCompany) {

		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
	}
	
	public Company(int idCompany) {

		super();
		this.idCompany = idCompany;
		this.nameCompany = "noName";
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	@Override
	public String toString() {
		return "Company [idCompany=" + idCompany + ", nameCompany=" + nameCompany + "]";
	}
	
	

}
