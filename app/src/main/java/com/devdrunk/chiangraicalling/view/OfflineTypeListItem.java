package com.devdrunk.chiangraicalling.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.devdrunk.chiangraicalling.R;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class OfflineTypeListItem extends BaseCustomViewGroup {

    TextView txtId,txtName;
    ImageView imgProfile;

    public OfflineTypeListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public OfflineTypeListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public OfflineTypeListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public OfflineTypeListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_ampure, this);
    }

    private void initInstances() {
        // findViewById here
        txtId = (TextView) findViewById(R.id.txtId);
        txtName = (TextView) findViewById(R.id.txtName);
        imgProfile = (ImageView) findViewById(R.id.imvProfile);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public void setName(String text){
        txtName.setText(text);
    }
    public void setId(String text){
        txtId.setText(text);
    }
    public void setImgProfile(int id){
        switch (id){
            case 1 :
                imgProfile.setImageResource(R.drawable.telfast);
                break;
            case 2 :
                imgProfile.setImageResource(R.drawable.passport);
                break;
            case 3 :
                imgProfile.setImageResource(R.drawable.travle);
                break;
            case 4 :
                imgProfile.setImageResource(R.drawable.polic);
                break;
            case 5 :
                imgProfile.setImageResource(R.drawable.hospital);
                break;
            case 6 :
                imgProfile.setImageResource(R.drawable.clinic);
                break;
            case 7 :
                imgProfile.setImageResource(R.drawable.box);
                break;
            case 8 :
                imgProfile.setImageResource(R.drawable.bus);
                break;
            case 9 :
                imgProfile.setImageResource(R.drawable.airport);
                break;
            case 10 :
                imgProfile.setImageResource(R.drawable.bangkok_bank);
                break;
            case 11 :
                imgProfile.setImageResource(R.drawable.kongsai_bank);
                break;
            case 12 :
                imgProfile.setImageResource(R.drawable.thai_bank);
                break;
            case 13 :
                imgProfile.setImageResource(R.drawable.kasikorn_bank);
                break;
            case 14 :
                imgProfile.setImageResource(R.drawable.thaipanit_bank);
                break;
            default:
                imgProfile.setImageResource(R.drawable.mony);
                break;
        }
    }

}
