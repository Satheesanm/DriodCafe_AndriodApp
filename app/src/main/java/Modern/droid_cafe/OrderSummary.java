package Modern.droid_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.NumberFormat;

public class OrderSummary extends AppCompatActivity implements View.OnClickListener{
    RadioButton sameDay, nextDay, pickUp;
    Spinner spinner;
  TextView msg,  msg1;
    FloatingActionButton flot;
    Button deliver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);


        deliver = findViewById(R.id.deliver);
        deliver.setOnClickListener(this);


msg = findViewById(R.id.itemName);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String itemName =intent.getStringExtra("nameOfItem");
        String itemprice =intent.getStringExtra("totalPrice");
        String itemquantity =intent.getStringExtra("quantityOfItem");

           msg.setText("Item Name  : " + "" + itemName+ "\n\nItem Quantity  : " + "" +itemquantity + "\n\nItem Price (13% HST)  :" + "" + itemprice +" \n\n" );

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


     }



    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.deliver) {

            Intent intent = new Intent(OrderSummary.this, OrderActivity.class);
            startActivity(intent);

        }}


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.hotbeveragemenu:
                Intent intent = new Intent(OrderSummary.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(OrderSummary.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(OrderSummary.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(OrderSummary.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}
}

