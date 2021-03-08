package bo;

import java.util.Date;
import lombok.Data;

@Data
public class Article {

	public int no_article;
	public String nom_article;
	public String description;
	public Date date_debut_encheres;
	public Date date_fin_encheres;
	public int prix_initial;
	public int prix_vente;
	public int no_utilisateur;
	public int no_categorie;
}
