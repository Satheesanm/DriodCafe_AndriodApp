package Modern.droid_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class Ice_Cream extends AppCompatActivity implements  View.OnClickListener {

    int quantity=0;
    String nameOfItem;
    String quantityOfItem;
    String totalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecream_details);
        Button order  = findViewById(R.id.order);
        order.setOnClickListener(this);
        TextView names=findViewById(R.id.nameCoff);
        nameOfItem= names.getText().toString();
        TextView quantityOfItems=findViewById(R.id.ice_cream_text_view);
        quantityOfItem= quantityOfItems.getText().toString();
        TextView totalPrices=findViewById(R.id.price_text_view);
        totalPrice= totalPrices.getText().toString();
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
    }





    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.order) {

            displayPrice(quantity*2.26);
            Intent intent = new Intent(Ice_Cream.this, OrderSummary.class);
            Bundle extras = new Bundle();
            extras.putString("nameOfItem",nameOfItem);
            extras.putString("quantityOfItem",NumberFormat.getNumberInstance().format(quantity));
            extras.putString("totalPrice",NumberFormat.getCurrencyInstance().format(quantity*2.26));
            intent.putExtras(extras);
            startActivity(intent);






        }}


    public void increment(View view){
        quantity=quantity+1;
        display(quantity);

    }


    public void decrement(View view){
        quantity=quantity-1;
        display(quantity);

    }

    private void displayPrice(double number){
        TextView priceTextView=(TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));


    }


    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.ice_cream_text_view);
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
                Intent intent = new Intent(Ice_Cream.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(Ice_Cream.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(Ice_Cream.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(Ice_Cream.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}


}