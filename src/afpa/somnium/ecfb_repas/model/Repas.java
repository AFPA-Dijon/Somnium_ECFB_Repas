package afpa.somnium.ecfb_repas.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by 21011-23-04 on 09/02/2016.
 */
@DatabaseTable (tableName = "repas")
public class Repas {

	@DatabaseField (generatedId = true)
	private int id;

	@DatabaseField (columnName = "date", canBeNull = false)
	private Date date;

	/**
	 * Construct
	 */

	public Repas() {}

	public Repas(Date date) {
		this.date = date;
	}

	/**
	 * GET / SET
	 */

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
