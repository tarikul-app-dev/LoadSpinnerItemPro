package limited.it.planet.loadspinnerprogrammatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spAndroidName,spAPIVersion;
    String[] androidNougatList;
    String[] androidOreoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        spAndroidName = (Spinner)findViewById(R.id.spin_android_version);
        spAPIVersion = (Spinner)findViewById(R.id.spin_api_version);
        androidNougatList =getResources().getStringArray(R.array.nougat_api_version);
        androidOreoList = getResources().getStringArray(R.array.oreo_api_version);


        spAndroidName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String androidName = spAndroidName.getSelectedItem().toString();

                if (androidName.equals("Nougat")){
                    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, androidNougatList);
                    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
                    spAPIVersion.setAdapter(spinnerArrayAdapter);
                }

                if (androidName.equals("Oreo")){
                    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_item, androidOreoList);
                    spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
                    spAPIVersion.setAdapter(spinnerArrayAdapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
