package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Taehui on 4/1/16.
 */
public class SearchFragment extends Fragment{
    Spinner mOption;
    Spinner mPrice;
    Spinner mDistance;

    EditText mSearch;

    Button mSearchButton;
    Button mMapButton;

    Button mOrder1;
    Button mOrder2;
    Button mOrder3;

    OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
        public void onButtonClicked4(View v);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnButtonClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        mSearchButton = (Button)v.findViewById(R.id.search_button);
        mMapButton = (Button)v.findViewById(R.id.map_button);
        mOrder1 = (Button)v.findViewById(R.id.order_1);
        mOrder2 = (Button)v.findViewById(R.id.order_2);
        mOrder3 = (Button)v.findViewById(R.id.order_3);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener(v);
            }
        };

        mSearchButton.setOnClickListener(listener);
        mMapButton.setOnClickListener(listener);
        mOrder1.setOnClickListener(listener);
        mOrder2.setOnClickListener(listener);
        mOrder3.setOnClickListener(listener);

        return v;
    }

    public void ButtonClickedListener(View v) {
        /*switch (v.getId()) {
            case R.id.search_button:
                break;
            case R.id.map_button:
                break;
        }*/

        mListener.onButtonClicked4(v);

    }

}
