package cl.bootcamp.myapplication61;



import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        buttonValidate = findViewById(R.id.button_validate);

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String choice = selectedRadioButton.getText().toString();
                    showPokemonDialog(choice);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showPokemonDialog(String pokemonName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pokemon, null);
        builder.setView(dialogView);

        TextView nameTextView = dialogView.findViewById(R.id.pokemon_name);
        ImageView iconImageView = dialogView.findViewById(R.id.pokemon_icon);
        Button closeButton = dialogView.findViewById(R.id.button_close);

        nameTextView.setText(pokemonName);

        // Se agrega un icono basado en el nombre del Pokémon
        switch (pokemonName) {
            case "Charmander":
                iconImageView.setImageResource(R.drawable.fire);
                break;
            case "Bulbasaur":
                iconImageView.setImageResource(R.drawable.grass);
                break;
            case "Squirtle":
                iconImageView.setImageResource(R.drawable.water);
                break;
            default:
                iconImageView.setImageResource(R.drawable.ball);
                break;
        }

        builder.setTitle("Pokémon Seleccionado es");
        AlertDialog dialog = builder.create();

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

