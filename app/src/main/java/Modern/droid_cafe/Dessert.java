package Modern.droid_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Dessert extends AppCompatActivity implements View.OnClickListener {

    Button addDonut, addIcecreme, addFroyo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        addDonut = findViewById(R.id.donutAdd);
        addDonut.setOnClickListener(this);
        addIcecreme = findViewById(R.id.ice_creamAdd);
        addIcecreme.setOnClickListener(this);
        addFroyo = findViewById(R.id.froyoAdd);
        addFroyo.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.donutAdd) {
            startActivity(new Intent(Dessert.this, Donut.class));
            Dessert.this.finish();
        }    if (id == R.id.ice_creamAdd) {
            startActivity(new Intent(Dessert.this, Ice_Cream.class));
            Dessert.this.finish();
        }

        if (id == R.id.froyoAdd) {
            startActivity(new Intent(Dessert.this, Froyo.class));
            Dessert.this.finish();
        }
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
                Intent intent = new Intent(Dessert.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(Dessert.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(Dessert.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(Dessert.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}

}