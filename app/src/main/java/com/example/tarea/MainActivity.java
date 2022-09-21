package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4;
    Button boto1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edtcodigo);
        edt2 = findViewById(R.id.edtnombre);
        edt3 = findViewById(R.id.edtprecio);
        edt4 = findViewById(R.id.edtcantidad);
        boto1 = findViewById(R.id.btnregistrar);
    }


    public void guardarProductos(View view){
        SharedPreferences preferences = getSharedPreferences(edt1.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("codigo", edt1.getText().toString());
        editor.putString("producto", edt2.getText().toString());
        editor.putString("costo", edt3.getText().toString());
        editor.putString("stock", edt4.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(),"Registrado",Toast.LENGTH_LONG).show();
    }

    public void recuperarDatos(View v){
        String codigo=edt1.getText().toString();
        Toast.makeText(this,"No"+codigo, Toast.LENGTH_LONG).show();
        SharedPreferences prefe=getSharedPreferences(codigo, Context.MODE_PRIVATE);
        String producto=prefe.getString("producto", "");
        String costo=prefe.getString("costo", "");
        String stock=prefe.getString("stock", "");
        if (producto.length()==0) {
            Toast.makeText(this,"No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show();
        }
        else {
            edt2.setText(producto);
            edt3.setText(costo);
            edt4.setText(stock);

        }
    }
}