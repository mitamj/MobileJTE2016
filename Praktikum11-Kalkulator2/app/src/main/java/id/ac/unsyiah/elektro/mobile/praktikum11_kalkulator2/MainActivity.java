package id.ac.unsyiah.elektro.mobile.praktikum11_kalkulator2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickBtnSamaDengan(View view) {
        EditText numAngka1 = (EditText) findViewById(R.id.numAngka1);
        String angka1Str = numAngka1.getText().toString();
        long angka1 = Long.valueOf(angka1Str);

        EditText numAngka2 = (EditText) findViewById(R.id.numAngka2);
        String angka2Str = numAngka2.getText().toString();
        long angka2 = Long.valueOf(angka2Str);

        Spinner spr = (Spinner) findViewById(R.id.operasi);
        TextView lblHasil = (TextView) findViewById(R.id.lblHasil);

        String selectedItem = (String) spr.getSelectedItem();
        if (selectedItem.trim().equals("x")) {
            long result = Long.valueOf(numAngka1.getText().toString()) * Long.valueOf(numAngka2.getText().toString());
            lblHasil.setText(Long.toString(result));
        } else if (selectedItem.trim().equals("/")) {
            float result = Float.parseFloat(numAngka1.getText().toString()) / Float.parseFloat(numAngka2.getText().toString());
            lblHasil.setText(Float.toString(result));
        } else if (selectedItem.trim().equals("+")) {
            long result = Long.valueOf(numAngka1.getText().toString()) + Long.valueOf(numAngka2.getText().toString());
            lblHasil.setText(Long.toString(result));
        } else if (selectedItem.trim().equals("-")) {
            long result = Long.valueOf(numAngka1.getText().toString()) - Long.valueOf(numAngka2.getText().toString());
            lblHasil.setText(Long.toString(result));
        }

    }
}
