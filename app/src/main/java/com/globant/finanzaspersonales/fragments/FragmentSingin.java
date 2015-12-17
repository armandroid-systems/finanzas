package com.globant.finanzaspersonales.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globant.finanazaspersonales.R;
import com.globant.finanzaspersonales.activities.MainActivity;

import org.w3c.dom.Text;

/**
 * Created by armando.dominguez on 17/12/2015.
 */
public class FragmentSingin extends BaseFragment implements View.OnClickListener {
    private final static String TAG = FragmentSingin.class.getSimpleName();

    private TextView skip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View singInView = inflater.inflate(R.layout.fragment_singin,container,false);

        skip = (TextView)singInView.findViewById(R.id.skipAuth);

        skip.setOnClickListener(this);
        return singInView;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.skipAuth:
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;
            case R.id.singInButton:
                break;
            default:
                break;
        }
    }
}
