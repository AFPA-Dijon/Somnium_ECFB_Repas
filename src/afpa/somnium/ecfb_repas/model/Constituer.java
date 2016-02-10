package afpa.somnium.ecfb_repas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 21011-23-04 on 09/02/2016.
 */
@DatabaseTable (tableName = "constituer")
public class Constituer {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField (
			canBeNull = false,
			columnName = "repas_id",
			foreign = true,
			foreignAutoRefresh = true)
	private Repas repas;

	@DatabaseField (
			canBeNull = false,
			columnName = "aliment_id",
			foreign = true,
			foreignAutoRefresh = true)
	private Aliment aliment;

	@DatabaseField (columnName = "quantite", canBeNull = false)
	private int quantite;

	/**
	 * Construct
	 */

	public Constituer() {}

	public Constituer(Aliment aliment, int quantite) {
		this.aliment = aliment;
		this.quantite = quantite;
	}

	public Constituer(Repas repas, Aliment aliment, int quantite) {
		this.repas = repas;
		this.aliment = aliment;
		this.quantite = quantite;
	}

	/**
	 * GET / SET
	 */

	public int getId() {
		return id;
	}

	public Repas getRepas() {
		return repas;
	}

	public void setRepas(Repas repas) {
		this.repas = repas;
	}

	public Aliment getAliment() {
		return aliment;
	}

	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
