package com.devdrunk.chiangraicalling.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.devdrunk.chiangraicalling.R;
import com.devdrunk.chiangraicalling.activity.OfflineActivity;
import com.devdrunk.chiangraicalling.activity.OnlineActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class MainFragment extends Fragment {

    ImageButton btnOnline;
    ImageButton btnOffline;
    ImageButton btnCredit;
    ImageButton btnClose;
    RelativeLayout parentCredit;
    LinearLayout parentMenu;

    public MainFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        btnOnline = (ImageButton) rootView.findViewById(R.id.btnOnline);
        btnOffline = (ImageButton) rootView.findViewById(R.id.btnOffLine);
        btnCredit = (ImageButton) rootView.findViewById(R.id.btnCredit);
        btnClose = (ImageButton) rootView.findViewById(R.id.btnClose);

        parentCredit = (RelativeLayout) rootView.findViewById(R.id.parentCredit);
        parentMenu = (LinearLayout) rootView.findViewById(R.id.parentMenu);


        btnCredit.setOnClickListener(onclickcredit);


        btnClose.setOnClickListener(onclickClose);

        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),
                        OnlineActivity.class);
                startActivity(intent);

                /*
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:123456"));
                startActivity(intent);
                */
            }
        });

        btnOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),
                        OfflineActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }


    final View.OnClickListener onclickcredit = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            parentCredit.setVisibility(View.VISIBLE);
            parentMenu.setVisibility(View.GONE);
        }
    };
    final View.OnClickListener onclickClose = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            parentCredit.setVisibility(View.GONE);
            parentMenu.setVisibility(View.VISIBLE);
        }
    };
}
