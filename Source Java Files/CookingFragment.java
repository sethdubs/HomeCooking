package edu.auburn.eng.csse.comp3710;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class CookingFragment extends Fragment {
    private Button mSubmitButton;

    //upload a picture?
    private EditText mDishName;
    private EditText mPrice;
    private EditText mCookingTime;
    private EditText mAvailableTime;
    private User user;

    OnButtonClickedListener2 mListener;

    public interface OnButtonClickedListener2 {
        public void onButtonClicked2(View v);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonClickedListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnButtonClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cooking, container, false);

        user = User.getUser();
        user.setCookId(user.getCurrentId(), user.getCurrentId());
        /* Submit Button */
        mSubmitButton = (Button)v.findViewById(R.id.cooking_submit_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener2(v);
            }
        };

        mSubmitButton.setOnClickListener(listener);

        /* When text is edited */
        mDishName = (EditText)v.findViewById(R.id.dish_name);
        mDishName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    user.setFoodItem(s.toString(), user.getCurrentId());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This too
            }
        });

        mPrice = (EditText)v.findViewById(R.id.price);
        mPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    String p = s.toString();
                    double price = Double.parseDouble(p);
                    user.setPrice(price, user.getCurrentId() - 1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This too
            }
        });

        mCookingTime = (EditText)v.findViewById(R.id.cooking_time);
        mCookingTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    int t = Integer.parseInt(s.toString());
                    user.setTime(t, user.getCurrentId() - 1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This too
            }
        });

        mAvailableTime = (EditText)v.findViewById(R.id.available_time);
        mAvailableTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() != true){
                    Date date = new Date(s.toString());
                    user.setDate(date , user.getCurrentId() - 1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This too
            }
        });

        return v;
    }

    public void ButtonClickedListener2(View v) {
        switch (v.getId()) {
            case R.id.cooking_submit_button:
                // send to database???
                break;
        }

        mListener.onButtonClicked2(v);

    }

}
