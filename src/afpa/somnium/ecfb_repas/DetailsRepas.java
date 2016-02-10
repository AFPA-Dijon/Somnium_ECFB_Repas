package afpa.somnium.ecfb_repas;

import afpa.somnium.ecfb_repas.model.Aliment;
import afpa.somnium.ecfb_repas.model.Constituer;
import afpa.somnium.ecfb_repas.model.Repas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by 21011-23-04 on 09/02/2016
 * @AFPA
 */
public class DetailsRepas extends DatabaseHelperFragment implements View.OnClickListener {

	private ArrayAdapter<Constituer> alimentArrayAdapter;
	private ListView listViewAliments;
	private TextView tvNbCalories;
	private Repas repasCourant;
	private int nbCalories;
	private Button boutonSauvegarder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.details_repas_layout, container, false);

		this.boutonSauvegarder = (Button) view.findViewById(R.id.save_button);
		this.boutonSauvegarder.setOnClickListener(this);

		this.tvNbCalories = (TextView) view.findViewById(R.id.calories_counter);
		this.listViewAliments = (ListView) view.findViewById(R.id.list_aLiments_select);
		this.alimentArrayAdapter = new ArrayAdapter<Constituer>(
				getActivity(),
				android.R.layout.simple_list_item_1
		);
		this.listViewAliments.setAdapter(this.alimentArrayAdapter);
		this.repasCourant = new Repas(new Date());
		this.nbCalories = 0;

		return view;
	}

	public void AjouterAliment(Aliment nouvelAliment, int quantite){
		this.alimentArrayAdapter.add(new Constituer(nouvelAliment, quantite));
		this.majNbCalories(nouvelAliment, quantite);
	}

	private void majNbCalories(Aliment nouvelAliment, int quantite) {
		this.nbCalories += nouvelAliment.getNbCalories() * quantite;
		this.tvNbCalories.setText(""+this.nbCalories);
	}

	public void onClick(View v) {
		try {
			getDatabaseHelper().getDaoRepas().create(this.repasCourant);
			for (int i = 0; i<this.alimentArrayAdapter.getCount(); i++){
				Constituer c = this.alimentArrayAdapter.getItem(i);
				c.setRepas(this.repasCourant);
				getDatabaseHelper().getDaoConstituer().create(c);
			}
			reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void reset(){
		this.repasCourant = new Repas(new Date());
		this.alimentArrayAdapter.clear();
		this.tvNbCalories.setText("0");
		this.nbCalories = 0;
	}
}
