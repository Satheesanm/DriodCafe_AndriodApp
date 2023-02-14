package Modern.droid_cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderConfirmation extends AppCompatActivity implements View.OnClickListener{
    RadioButton sameDay, nextDay, pickUp;
    Spinner spinner;
  TextView msg,  msg1;
    FloatingActionButton flot;
    Button deliver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

          msg = findViewById(R.id.confirm);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name =intent.getStringExtra("name");
        String address =intent.getStringExtra("address");
        String phone =intent.getStringExtra("phone");

           msg.setText("Mr./Mrs. "+name+ ", Thanks for choosing Droid cafe, you order has been placed. Your food will be delivered to " + address );

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     }


    @Override
    public void onClick(View v) {

    }
}

