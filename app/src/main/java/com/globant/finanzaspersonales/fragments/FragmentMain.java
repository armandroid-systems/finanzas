package com.globant.finanzaspersonales.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.utils.Constants;

/**
 * Created by armando.dominguez on 17/12/2015.
 */
public class FragmentMain extends BaseFragment implements View.OnClickListener{
    private final static String TAG = FragmentMain.class.getSimpleName();

    private RelativeLayout rl;
    private Button buttonBudget;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_main,container,false);

        rl = (RelativeLayout) mainView.findViewById(R.id.graphPlaceHolder);
        buttonBudget = (Button) mainView.findViewById(R.id.buttonBudget);

        if(mParam != null){
            rl.setVisibility(RelativeLayout.VISIBLE);
            buttonBudget.setVisibility(Button.GONE);
        }

        return mainView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            default:
                break;
        }

    }
}
