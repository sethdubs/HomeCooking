package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Taehui on 3/29/16.
 */

public class RegisterFragment extends Fragment{
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mPhone;
    private User user;

    OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
         void onButtonClicked8(View v);
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
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener(v);
            }
        };

        user = User.getUser();
        mFirstName = (EditText)v.findViewById(R.id.first_name_editText);
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    user.setFirstName(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLastName = (EditText)v.findViewById(R.id.last_name_editText);
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    user.setLastName(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPhone = (EditText)v.findViewById(R.id.phone_number_editText);
        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty() != true) {
                    user.setPhoneNum(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    public void ButtonClickedListener(View v) {
        mListener.onButtonClicked8(v);

    }
    
}
