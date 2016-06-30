package com.devdrunk.chiangraicalling.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devdrunk.chiangraicalling.R;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class OfflinePlanceListItem extends BaseCustomViewGroup {

    TextView tvName,tvTel,tvAmphurName;
    ImageView imgProfile;

    public OfflinePlanceListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public OfflinePlanceListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public OfflinePlanceListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public OfflinePlanceListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.list_item_plance, this);
    }

    private void initInstances() {
        // findViewById here
        tvName = (TextView) findViewById(R.id.tvName);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvAmphurName = (TextView) findViewById(R.id.tvAmphurName);
        imgProfile = (ImageView) findViewById(R.id.imvProfile);

        imgProfile.setVisibility(ImageView.GONE);

        tvName.setPadding(10,0,0,0);




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

    public void setNameText (String text){
        tvName.setText(text);
    }

    public void setTelText (String text){
        tvTel.setText(text);
    }
    public void setImgProfile (String text){
        //Todo set images
        //imgProfile.setImageResource(R.drawable.logo_app);
    }
    public void setTextAmpureName (String text,String typeId){
        int id = Integer.parseInt(typeId);
        if(id == 6) {
            tvAmphurName.setText("อำเภอเมือง เชียงราย");
            tvAmphurName.setVisibility(View.VISIBLE);
        }
        Log.e("== = = = = = ",""+id);

    }



}
