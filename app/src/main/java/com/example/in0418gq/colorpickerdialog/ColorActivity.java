package com.example.in0418gq.colorpickerdialog;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ColorActivity extends AppCompatActivity implements ColorPickerDialogFragment.ColorDialogSelectionListener {

    int mBackroundColor;
    Button mChooseBackgroundColor;
    RelativeLayout mBackround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mBackround = (RelativeLayout) findViewById(R.id.background);
        mChooseBackgroundColor = (Button) findViewById(R.id.show_color_dialog_button);

        mChooseBackgroundColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ColorPickerDialogFragment dialog = ColorPickerDialogFragment.newInstance();
                dialog.show(getFragmentManager(),"Color Dialog");
            }
        });
    }

    @Override
    public void colorSelected(int color) {
        mBackround.setBackgroundColor(color);
    }
}
