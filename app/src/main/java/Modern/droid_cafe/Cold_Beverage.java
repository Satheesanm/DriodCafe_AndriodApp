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

public class Cold_Beverage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_beverage);
        Button IceCoffeAdd = findViewById(R.id.IceCoffeAdd);
        IceCoffeAdd.setOnClickListener(this);
        Button LemonideAdd = findViewById(R.id.LemonideAdd);
        LemonideAdd.setOnClickListener(this);
        Button VanillaIceCafeAdd = findViewById(R.id.VanillaIceCafeAdd);
        VanillaIceCafeAdd.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.IceCoffeAdd) {
            startActivity(new Intent(Cold_Beverage.this, Ice_Coffee.class));
            Cold_Beverage.this.finish();
        }    if (id == R.id.VanillaIceCafeAdd) {
            startActivity(new Intent(Cold_Beverage.this, IceCafe_Detail.class));
            Cold_Beverage.this.finish();
        }
        if (id == R.id.LemonideAdd) {
            startActivity(new Intent(Cold_Beverage.this, Lemonade.class));
            Cold_Beverage.this.finish();
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
                Intent intent = new Intent(Cold_Beverage.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(Cold_Beverage.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(Cold_Beverage.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(Cold_Beverage.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}
}