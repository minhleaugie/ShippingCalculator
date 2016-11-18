package cornez.com.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends AppCompatActivity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TASK 1: SET ACTIVITY CONTENT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //TASk 2: CREATE A DATA MODEL FOR STORING AN ITEM TO BE SHIPPED
        shipItem = new ShipItem();

        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT
        weightET = (EditText) findViewById(R.id.editText1);

        //TASk 4: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView)findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //TASK 5: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT
        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                shipItem.setWeight(0);
            }
            displayShipping();

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        baseCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        totalCostTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));

    }


}
