package sample.constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama,tvnomor;

    Bundle bundle = getIntent().getExtras();

    String nama = bundle.getString( "a");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        switch (nama)
        {
            case "ilham":
                tvnama.setText("Ilham ardy pratama");
                tvnomor.setText("081329111196");
                break;

            case "ardy":
                tvnama.setText("ilham Ardy pratama");
                tvnomor.setText("081329111196");
                break;

            case "pratama":
                tvnama.setText("ilham ardy Pratama");
                tvnomor.setText("081329111196");
                break;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);


    }
}