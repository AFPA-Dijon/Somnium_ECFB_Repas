package afpa.somnium.ecfb_repas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by 21011-23-04 on 09/02/2016.
 */
@DatabaseTable (tableName = "aliment")
public class Aliment {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField (columnName = "libelle", canBeNull = false)
	private String libelle;

	@DatabaseField (columnName = "nb_calories", canBeNull = false)
	private double nbCalories;

	@DatabaseField (columnName = "type_mesure", canBeNull = false)
	private String typeMesure;

	/**
	 * Construct
	 */
	public Aliment() {}

	public Aliment(String libelle, double nbCalories, String typeMesure) {
		this.libelle = libelle;
		this.nbCalories = nbCalories;
		this.typeMesure = typeMesure;
	}

	/**
	 * GET / SET
	 */
	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getNbCalories() {
		return nbCalories;
	}

	public void setNbCalories(double nbCalories) {
		this.nbCalories = nbCalories;
	}

	public String getTypeMesure() {
		return typeMesure;
	}

	public void setTypeMesure(String typeMesure) {
		this.typeMesure = typeMesure;
	}

	/**
	 * toString()
	 */
	@Override
	public String toString() {
		return this.getLibelle()
				+" : "
				+this.getNbCalories()
				+" par "
				+this.getTypeMesure();
	}
}
