package Modern.droid_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Hot_Beverage extends AppCompatActivity implements View.OnClickListener {

     Button addCoffee, addExpresso, addGreenTea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_beverage);
        addCoffee = findViewById(R.id.brewedCoffAdd);
        addCoffee.setOnClickListener(this);
        addExpresso = findViewById(R.id.expressoAdd);
        addExpresso.setOnClickListener(this);
        addGreenTea = findViewById(R.id.greenTeaAdd);
        addGreenTea.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.brewedCoffAdd) {
            startActivity(new Intent(Hot_Beverage.this, Brewed_Coffee.class));
            Hot_Beverage.this.finish();
        }    if (id == R.id.expressoAdd) {
            startActivity(new Intent(Hot_Beverage.this, Expresso.class));
            Hot_Beverage.this.finish();
        }

        if (id == R.id.greenTeaAdd) {
            startActivity(new Intent(Hot_Beverage.this, Green_Tea.class));
            Hot_Beverage.this.finish();
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
                Intent intent = new Intent(Hot_Beverage.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(Hot_Beverage.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(Hot_Beverage.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(Hot_Beverage.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}
}