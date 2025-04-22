package Model;

public class Client {
	private int id;
    private String nom;
    private String email;
    private String telephone;
    public Client() {}
    public Client (String nom,String email,String Telephone) {
    	this.setId(id);
    	this.setEmail(email);
    	this.setTelephone(Telephone);
    	this.setNom(nom);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}


