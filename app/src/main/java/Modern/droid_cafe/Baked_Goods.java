package Modern.droid_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Baked_Goods extends AppCompatActivity  implements View.OnClickListener {


    Button addmuffin, addCroissant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baked_goods);
        addmuffin = findViewById(R.id.muffinAdd);
        addmuffin.setOnClickListener(this);
        addCroissant = findViewById(R.id.croissantAdd);
        addCroissant.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.muffinAdd) {
            startActivity(new Intent(Baked_Goods.this, Muffin.class));
            Baked_Goods.this.finish();
        }    if (id == R.id.croissantAdd) {
            startActivity(new Intent(Baked_Goods.this, Croissant.class));
            Baked_Goods.this.finish();
        }

    }


    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.coffee_text_view);
        quantityTextView.setText("" + numbers);

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
                Intent intent = new Intent(Baked_Goods.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(Baked_Goods.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(Baked_Goods.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(Baked_Goods.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}

}