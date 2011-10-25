package us.burningbush.android.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Convert extends Activity {
	private EditText text;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText) findViewById(R.id.editText1);
        
        text.addTextChangedListener(new CalculatingTextWatcher(this));
    }
    
    public void process() {
		if( text.getText().length() == 0 ) {
			return;
		}
		float inputValue;
		try {
			inputValue = Float.parseFloat(text.getText().toString());
		} catch( NumberFormatException ex) {
			return;
		}
		doCalculation(inputValue);
    }
    
    private void doCalculation(Float input) {
    	String tempInC = String.format( getString(R.string.tempInC), input, fToC(input));
    	String tempInF = String.format( getString(R.string.tempInF), input, cToF(input));
    	
    	((TextView) findViewById(R.id.celciusLabel)).setText(tempInC);
    	((TextView) findViewById(R.id.fahrenheitLabel)).setText(tempInF);
    }
    
    private float cToF(Float input) {
    	return ((input - 32) * 5 / 9);
    }
    
    private float fToC(Float input) {
    	return ((input * 9) / 5) + 32;
    }
}