package org.goodev.shadowediter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	
	TextView mText;
	EditText mEtText;
	EditText mEtTextSize;
	EditText mEtColor;
	EditText mEtBgColor;
	EditText mEtDx;
	EditText mEtDy;
	EditText mEtRadius;
	EditText mEtShadowColor;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.text);
        mEtText = (EditText) findViewById(R.id.editText);
        mEtTextSize = (EditText) findViewById(R.id.editTextSize);
        mEtColor = (EditText) findViewById(R.id.editTextColor);
        mEtBgColor = (EditText) findViewById(R.id.editTextBgColor);
        mEtDx = (EditText) findViewById(R.id.editTextDX);
        mEtDy = (EditText) findViewById(R.id.editTextDY);
        mEtRadius = (EditText) findViewById(R.id.editTextRadius);
        mEtShadowColor = (EditText) findViewById(R.id.editTextShadowColor);
        findViewById(R.id.set).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setText();
			}
		});
    }

    protected void setText() {
    	String text = mEtText.getEditableText().toString();
    	String textSize = mEtTextSize.getEditableText().toString();
    	String textColor = mEtColor.getEditableText().toString();//#AAff0000
    	String bgColor = mEtBgColor.getEditableText().toString();
    	String dx = mEtDx.getEditableText().toString();
    	String dy = mEtDy.getEditableText().toString();
    	String radius = mEtRadius.getEditableText().toString();
    	String shadowColor = mEtShadowColor.getEditableText().toString();
    	
    	final TextView view = mText;
    	try {
			view.setText(text);
			view.setTextSize(TypedValue.COMPLEX_UNIT_SP,Float.valueOf(textSize));
			view.setTextColor(Color.parseColor(textColor));
			view.setBackgroundColor(Color.parseColor(bgColor));
			view.setShadowLayer(Float.parseFloat(radius), Float.parseFloat(dx), Float.parseFloat(dy), Color.parseColor(shadowColor));
		} catch (Exception e) {
			Toast t = Toast.makeText(getApplicationContext(), R.string.input_error, Toast.LENGTH_LONG);
			t.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 60);
			t.show();
		}
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
