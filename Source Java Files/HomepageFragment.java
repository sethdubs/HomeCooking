package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomepageFragment extends Fragment {
    Button mSearchButton;
    Button mCookButton;
    TextView mTextView;

    OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
        public void onButtonClicked(View v);
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
        View v = inflater.inflate(R.layout.fragment_homepage, container, false);
        User user = User.getUser();

        mTextView = (TextView)v.findViewById(R.id.hello);
        mTextView.setText("Welcome to Home Cooking, " + user.getFirstName());

        mSearchButton = (Button)v.findViewById(R.id.search_button);
        mCookButton = (Button)v.findViewById(R.id.cook_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener(v);
            }
        };

        mSearchButton.setOnClickListener(listener);
        mCookButton.setOnClickListener(listener);

        return v;
    }

    public void ButtonClickedListener(View v) {
        switch (v.getId()) {
            case R.id.search_button:
                break;
            case R.id.cook_button:
                break;
        }

        mListener.onButtonClicked(v);

    }

}
