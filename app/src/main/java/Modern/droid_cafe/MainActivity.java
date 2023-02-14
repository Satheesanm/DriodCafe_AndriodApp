package Modern.droid_cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{


    FusedLocationProviderClient fusedLocationClient;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        findViewById(R.id.menu_bakedgood).setOnClickListener(this);
        findViewById(R.id.menu_hot_beverage).setOnClickListener(this);
        findViewById(R.id.menu_cold_beverage).setOnClickListener(this);
        findViewById(R.id.menu_dessert).setOnClickListener(this);
        findViewById(R.id.popular_bakedgood).setOnClickListener(this);
        findViewById(R.id.popular_hot_beverage).setOnClickListener(this);
        findViewById(R.id.popular_cold_beverage).setOnClickListener(this);
        findViewById(R.id.popular_dessert).setOnClickListener(this);




        ActivityCompat.requestPermissions( MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.menu_bakedgood) {
            startActivity(new Intent(MainActivity.this, Baked_Goods.class));
            MainActivity.this.finish();
        } else if (id == R.id.menu_hot_beverage) {
            startActivity(new Intent(MainActivity.this, Hot_Beverage.class));
            MainActivity.this.finish();
        } else if (id == R.id.menu_dessert) {
            startActivity(new Intent(MainActivity.this, Dessert.class));
        } else if (id == R.id.menu_cold_beverage) {
            startActivity(new Intent(MainActivity.this, Cold_Beverage.class));
        }else if (id == R.id.popular_dessert) {
            startActivity(new Intent(MainActivity.this, Froyo.class));
            MainActivity.this.finish();

        }else if (id == R.id.popular_cold_beverage) {
            startActivity(new Intent(MainActivity.this, Ice_Coffee.class));
            MainActivity.this.finish();

        }
        else if (id == R.id.popular_hot_beverage) {
            startActivity(new Intent(MainActivity.this, Brewed_Coffee.class));
            MainActivity.this.finish();

        }
        else if (id == R.id.popular_bakedgood) {
            startActivity(new Intent(MainActivity.this, Muffin.class));
            MainActivity.this.finish();

        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }




    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.hotbeveragemenu:
                Intent intent = new Intent(MainActivity.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(MainActivity.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(MainActivity.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(MainActivity.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}
}

