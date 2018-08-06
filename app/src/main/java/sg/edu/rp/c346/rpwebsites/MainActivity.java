package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);
        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:

                        alNumbers.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.RPcategory);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setAdapter(aaNumbers);
                        break;
                    case 1:
                        alNumbers.clear();
                        String[] strONumbers = getResources().getStringArray(R.array.SubCategory);
                        alNumbers.addAll(Arrays.asList(strONumbers));
                        spn2.setAdapter(aaNumbers);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spn1.getSelectedItemPosition();
                int subpos = spn2.getSelectedItemPosition();
                String[][] sites = {
                        {
                                "https://www.rp.edu.sg/",
                                "https://www.rp.edu.sg/student-life"
                        },
                        {
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                        }
                };
                Intent intent = new Intent(getBaseContext(), WebViewActivity.class);

                String url = sites[pos][subpos];

                intent.putExtra("url", url);
                startActivity(intent);
            }
                });

            }
}
