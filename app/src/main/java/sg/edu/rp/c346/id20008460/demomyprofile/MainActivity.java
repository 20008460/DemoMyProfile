package sg.edu.rp.c346.id20008460.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String gpa = etGPA.getText().toString();
        float fgpa = 0f;

        if (gpa.length() > 0) {
            fgpa = Float.parseFloat(gpa);
        }

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefeditor = prefs.edit();

        prefeditor.putString("name" , etName.getText().toString());
        prefeditor.putFloat("gpa" , fgpa);
        prefeditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa", 0f) ;
        etName.setText(name);
        etGPA.setText(gpa + ""); // will convert to a string instantly
    }
}