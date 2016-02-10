package afpa.somnium.ecfb_repas;

import android.app.Fragment;

/**
 * Created by 21011-23-04 on 10/02/2016.
 */
public class DatabaseHelperFragment extends Fragment {

	private static DatabaseHelper databaseHelper;

	public DatabaseHelper getDatabaseHelper(){
		if(databaseHelper == null) {
			databaseHelper = new DatabaseHelper(getActivity());
		}
		return databaseHelper;
	}

	@Override
	public void onDestroyView() {
		if(databaseHelper != null){
			databaseHelper.release();
			databaseHelper = null;
		}
		super.onDestroyView();
	}
}