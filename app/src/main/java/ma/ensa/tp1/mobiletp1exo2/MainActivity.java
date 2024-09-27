package ma.ensa.tp1.mobiletp1exo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView   impotBaseTxt , impotSupTxt , totalTxt;
    private EditText surface , nbrPiece;
    private CheckBox piscine ;
    private Button calculer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        surface = findViewById(R.id.surfaceInput);
        nbrPiece = findViewById(R.id.nbrPieceInput);
        piscine = findViewById(R.id.piscine);
        impotBaseTxt = findViewById(R.id.impotBase);
        impotSupTxt = findViewById(R.id.impotSup);
        totalTxt = findViewById(R.id.total);
        calculer = findViewById(R.id.calculer);

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double base ,sup , total ;
                int surfaceInt = Integer.parseInt(surface.getText().toString());
                int nbrPieceInt = Integer.parseInt(nbrPiece.getText().toString());

                base = 2*surfaceInt ;
                sup = 50*nbrPieceInt;

                if( piscine.isChecked()){
                    sup+=100;
                }

                total = sup + base ;
                impotBaseTxt.setText("Impot de Base : "+String.valueOf(base));
                impotSupTxt.setText("Impot Suplémentaire : "+sup);
                totalTxt.setText("Total : "+total);

            }
        });
    }

//    public void onclickCalculer(View view) {
//        double impotBase , impotSup , total ;
//
////        nom = findViewById(R.id.nom);
////        adresse = findViewById(R.id.adresse);
//        surface = findViewById(R.id.surfaceInput);
//        nbrPiece = findViewById(R.id.nbrPieceInput);
//        piscine = findViewById(R.id.piscine);
//        impotBaseTxt = findViewById(R.id.impotBase);
//        impotSupTxt = findViewById(R.id.impotSup);
//        totalTxt = findViewById(R.id.total);
//
//        int surfaceInt = Integer.parseInt(nom.getText().toString());
//        int nbrPieceInt = Integer.parseInt(nbrPiece.getText().toString());
//
//        impotBase = 2*surfaceInt ;
//        impotSup = 50*nbrPieceInt;
//
//        if( piscine.isChecked()){
//            impotSup+=100;
//        }

//        total = impotSup + impotBase ;
//
//        impotBaseTxt.setText("Impot de Base : "+impotBase);
//        impotBaseTxt.setText("Impot Supplimentaire : "+impotSup);
//        impotBaseTxt.setText("Total : "+total);
//
//
//
//    }
}