package us.burningbush.android.temperature;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;

public class CalculatingTextWatcher implements TextWatcher {
	private Convert context;
	
	public CalculatingTextWatcher(Convert ctx) {
		context = ctx;
	}
	
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		context.process();
	}

}
