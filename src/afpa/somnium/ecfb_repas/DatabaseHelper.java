package afpa.somnium.ecfb_repas;

import afpa.somnium.ecfb_repas.model.Aliment;
import afpa.somnium.ecfb_repas.model.Constituer;
import afpa.somnium.ecfb_repas.model.Mesure;
import afpa.somnium.ecfb_repas.model.Repas;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by 21011-23-04 on 09/02/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	public static final String DATABASE_NAME = "ecf_repas";
	public static final int VERSION = 2;

	private Dao<Repas, Integer> daoRepas;
	private Dao<Aliment, Integer> daoAliment;
	private Dao<Constituer, Integer> daoConstituer;


	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Repas.class);
			TableUtils.createTable(connectionSource, Aliment.class);
			TableUtils.createTable(connectionSource, Constituer.class);

			insertData();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertData() throws SQLException {
		/*
		// Repas.class
		this.daoRepas = getDaoRepas();
		Repas r1 = new Repas(new Date());
		Repas r2 = new Repas(new Date());
		Repas r3 = new Repas(new Date());
		this.daoRepas.create(r1);
		this.daoRepas.create(r2);
		this.daoRepas.create(r3);
		*/

		// Aliment.class
		this.daoAliment = getDaoAliment();
		Aliment a1 = new Aliment("Oeuf", 100, Mesure.UNITE);
		Aliment a2 = new Aliment("Viande", 215, Mesure.GRAMMES);
		Aliment a3 = new Aliment("Kiwi", 60, Mesure.UNITE);
		Aliment a4 = new Aliment("Pizza", 300, Mesure.PART);
		Aliment a5 = new Aliment("Poire", 100, Mesure.UNITE);
		Aliment a6 = new Aliment("Pain", 75, Mesure.TRANCHE);
		Aliment a7 = new Aliment("Bière", 225, Mesure.VERRE);
		this.daoAliment.create(a1);
		this.daoAliment.create(a2);
		this.daoAliment.create(a3);
		this.daoAliment.create(a4);
		this.daoAliment.create(a5);
		this.daoAliment.create(a6);
		this.daoAliment.create(a7);

		/*
		// Constituer.class
		this.daoConstituer = getDaoConstituer();
		// Repas.class r1
		Constituer c1 = new Constituer(r1, a1, 2);
		Constituer c2 = new Constituer(r1, a2, 1);
		Constituer c3 = new Constituer(r1, a6, 1);
		// Repas.class r2
		Constituer c4 = new Constituer(r2, a4, 1);
		Constituer c5 = new Constituer(r2, a5, 2);
		// Repas.class r3
		Constituer c6 = new Constituer(r3, a1, 3);

		this.daoConstituer.create(c1);
		this.daoConstituer.create(c2);
		this.daoConstituer.create(c3);
		this.daoConstituer.create(c4);
		this.daoConstituer.create(c5);
		this.daoConstituer.create(c6);
		*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

	}

	public Dao<Repas, Integer> getDaoRepas() throws SQLException {
		if(this.daoRepas == null){
			daoRepas = getDao(Repas.class);
		}
		return this.daoRepas;
	}

	public Dao<Aliment, Integer> getDaoAliment() throws SQLException {
		if(this.daoAliment == null){
			daoAliment = getDao(Aliment.class);
		}
		return this.daoAliment;
	}

	public Dao<Constituer, Integer> getDaoConstituer() throws SQLException {
		if(this.daoConstituer == null){
			daoConstituer = getDao(Constituer.class);
		}
		return this.daoConstituer;
	}

	public void release(){
		OpenHelperManager.releaseHelper();
	}

}