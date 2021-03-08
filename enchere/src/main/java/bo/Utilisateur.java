package bo;


import lombok.Data;

@Data
public class Utilisateur {

	public int no_utilisateur;
	public String pseudo;
	public String nom;
	public String prenom;
	public String email;
	public int telephone;
	public String rue;
	public String code_postal;
	public String ville;
	public String mot_de_passe;
	public int credit = 100;
	public byte administrateur;
}
