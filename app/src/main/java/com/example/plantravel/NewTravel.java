package com.example.plantravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewTravel extends AppCompatActivity {

    private Button btnLoc;
    private EditText edtLocal;
    private TextView txtEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_travel);

        edtLocal = findViewById(R.id.edtLoc);
        txtEnd = findViewById(R.id.endereco);
        btnLoc = findViewById(R.id.btnLoc);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String endereco = edtLocal.getText().toString();
                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAdress(endereco, getApplicationContext(), new GeoHandler());
            }
        });

    }

    private class GeoHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            String endereco;
            switch(msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    endereco = bundle.getString("endereco");
                    break;
                    default:
                        endereco = null;
            }

            txtEnd.setText(endereco);
        }
    }
}
