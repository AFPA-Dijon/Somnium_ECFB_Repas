package afpa.somnium.ecfb_repas;

import afpa.somnium.ecfb_repas.model.Aliment;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;

/**
 * 15h45 : Fini model et ListeAliments.class
 * par gain de temps j'utilise peu de constantes et de values/strings
 * 16h30 : Fini AlertDialog, données envoyées à DetailsRepas.class
 * Envoi sur DropBox à 16h55, reprise maison
 */

// TODO dialogue modal http://developer.android.com/guide/topics/ui/dialogs.html

public class MainActivity extends Activity implements ListeAliments.ListeAlimentsListener{

	private int quantity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public void OnAlimentClick(Aliment choix) {

		// AlertDialog
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		String message = getResources().getString(R.string.enter_quantity_label)+choix.getTypeMesure();
		builder.setMessage(message);
		EditText input = new EditText(this);
		input.setInputType(InputType.TYPE_CLASS_NUMBER);
		builder.setView(input);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				quantity = Integer.parseInt(input.getText().toString());

				DetailsRepas detailsRepas =
						(DetailsRepas) getFragmentManager().findFragmentById(R.id.DetailsRepas);
				detailsRepas.AjouterAliment(choix, quantity);
			}
		});
		builder.show();
	}
}