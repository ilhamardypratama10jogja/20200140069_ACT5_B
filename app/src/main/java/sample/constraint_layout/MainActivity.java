package sample.constraint_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //deklarasi variable untuk button
    Button btnLogin;

    //deklarasi variable untuk EditText
    EditText edemail, edpassword;

    //deklarasi variable untuk  menyimpan email dan password
    String nama, password;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //menghubungkan variabel edemail dengan componen button pada layout
        edemail = findViewById(R.id.edEmail);

        //menghubungkan variabel edpassword dengan componen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnlogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                String email = "admin@mail.com";

                String pass = "123";

                //cek apakah mengisi email dan password

                if (nama.isEmpty() && password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email dan password harus diisi!!",
                            Toast.LENGTH_LONG);
                    t.show();
                } else {

                    //cek email dan password sudah sama
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        t.show();
                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukan value dari variabel nama dengan kata kunci "a"
                        //dan dimasukkan kedalam bundle

                        b.putString("a", nama.trim());

                        //memasukan value dari variabel password dengan kata kunci "b"
                        //dan dimasukkan kedalam bundle

                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke Home_Activity

                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke activityHasil
                        i.putExtras(b);

                        //berpindah ke activityhasil
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toat dan menampilkan pesan login gagal

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}









