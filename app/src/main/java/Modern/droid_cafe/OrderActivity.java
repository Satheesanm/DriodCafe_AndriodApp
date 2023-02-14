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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.NumberFormat;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    RadioButton sameDay, nextDay, pickUp;
    Spinner spinner;
    TextView msg;
    FloatingActionButton flot;

    EditText name,address,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        sameDay = findViewById(R.id.option_SameDay);
        sameDay.setOnClickListener(this);
        nextDay = findViewById(R.id.option_NextDay);
        nextDay.setOnClickListener(this);
        pickUp = findViewById(R.id.option_pickup);
              pickUp.setOnClickListener(this);


        spinner = findViewById(R.id.simpleSpinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.labels_array,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        Intent intent = getIntent();
        //intent.getStringExtra("Message");
          //  msg.setText(intent.getStringExtra("Message"));

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button confirmation = findViewById(R.id.confimredorder);
        confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int id = v.getId();
                if (id == R.id.confimredorder) {
                    name = findViewById(R.id.eName);
                    address = findViewById(R.id.eAddress);
                    phone = findViewById(R.id.ePhone);

                    Intent intent = new Intent(OrderActivity.this, OrderConfirmation.class);
                    Bundle extras = new Bundle();
                    extras.putString("name",name.getText().toString());
                    extras.putString("address", address.getText().toString());
                    extras.putString("phone",phone.getText().toString());
                    intent.putExtras(extras);
                    startActivity(intent);

                }}
        });


     }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.option_SameDay:
                Toast.makeText(getApplicationContext(), "Same Day Messenger Service is Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.option_NextDay:
                Toast.makeText(getApplicationContext(), "Next Day ground Delivery is Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.option_pickup:
                Toast.makeText(getApplicationContext(), "Pick up is Selected", Toast.LENGTH_SHORT).show();
                break;

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
                Intent intent = new Intent(OrderActivity.this, Hot_Beverage.class);
                startActivity(intent);
                return true;
            case R.id.coldbeveragemenu:
                Intent intent2 = new Intent(OrderActivity.this, Cold_Beverage.class);
                startActivity(intent2);
                return true;
            case R.id.bakedgoodsmenu:
                Intent intent3 = new Intent(OrderActivity.this, Baked_Goods.class);
                startActivity(intent3);
                return true;
            case R.id.desertmenu:
                Intent intent4 = new Intent(OrderActivity.this, Dessert.class);
                startActivity(intent4);
                return true;
            default:  return super.onOptionsItemSelected(item);
        }}
}

