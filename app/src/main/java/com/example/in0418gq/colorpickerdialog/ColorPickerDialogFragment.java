package com.example.in0418gq.colorpickerdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by in0418gq on 9/27/16.
 */
public class ColorPickerDialogFragment extends DialogFragment {
    final  CharSequence[] COLOR_CHOICES={"Red","Green","Blue"};
    final int [] COLOR_VALUES={Color.RED,Color.GREEN,Color.BLUE};
    interface ColorDialogSelectionListener{
        void colorSelected(int color);
    }
    private ColorDialogSelectionListener mListener;
    public  static  ColorPickerDialogFragment newInstance(){
        ColorPickerDialogFragment fragment = new ColorPickerDialogFragment();
        return fragment;
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof  ColorDialogSelectionListener){
            mListener= (ColorDialogSelectionListener) activity;
        }else {
            throw new  RuntimeException(activity.toString()+ "must implement ColorDialogS");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInsanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a background color")
                .setItems(COLOR_CHOICES, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        mListener.colorSelected(COLOR_VALUES[which]);
                    }
                });
        return builder.create();
    }
}
