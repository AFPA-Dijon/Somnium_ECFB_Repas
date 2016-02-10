package afpa.somnium.ecfb_repas;

import afpa.somnium.ecfb_repas.model.Aliment;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

/**
 * Created by 21011-23-04 on 09/02/2016.
 */
public class ListeAliments extends DatabaseHelperFragment implements AdapterView.OnItemClickListener{

	private ListeAlimentsListener listener;
	private ArrayAdapter<Aliment> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.liste_aliments_layout, container, false);

		try {
			Dao<Aliment, Integer> daoAliment = getDatabaseHelper().getDaoAliment();
			this.adapter = new ArrayAdapter<Aliment>(
					getActivity(),
					android.R.layout.simple_list_item_1,
					daoAliment.queryForAll()
			);
			ListView listView = (ListView) view.findViewById(R.id.listViewALiments);
			listView.setAdapter(this.adapter);

			// Surveillance click
			listView.setOnItemClickListener(this);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return view;
	}

	// Gestion Click -> Renvoi de l'object vers this.listener / mainActivity.class
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		this.listener.OnAlimentClick(this.adapter.getItem(position));
	}

	// Interface de surveillance pour mainActivity.class
	public interface ListeAlimentsListener {
		void OnAlimentClick(Aliment choix);
	}

	// Gestion implémentation Interface + attribution this.listener
	@Override
	public void onAttach(Activity activity) {
		if(activity instanceof ListeAlimentsListener){
			this.listener = (ListeAlimentsListener) activity;
		} else {
			throw new ClassCastException(
					"L'activité : "+activity.getClass().getSimpleName()
							+ "doit implémenter l'interface ListeAliments.ListeAlimentsListener"
			);
		}
		super.onAttach(activity);
	}
}