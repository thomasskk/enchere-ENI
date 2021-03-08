package bo;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Encheres {

	public int noUtilisateur;
	public int noArticle;
	public Date dateEncheres;
	public int montantEnchere;
	public List<Encheres> encheres;

}
