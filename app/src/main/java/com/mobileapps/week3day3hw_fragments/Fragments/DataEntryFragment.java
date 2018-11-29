package com.mobileapps.week3day3hw_fragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobileapps.week3day3hw_fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = DataEntryFragment.class.getSimpleName();

    private OnFragmentInteractionListener mListener;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String FIRST_NAME_PARAM = "param1";
    public static final String LAST_NAME_PARAM = "param2";
    public static final String PHONE_NUMBER_PARAM = "param3";
    public static final String EMAIL_ADDRESS_PARAM = "param4";
    public static final String SKYPE_ID_PARAM = "param5";

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String skypeID;

    private TextView tvDisplayStatus;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhoneNumber;
    private EditText etEmailAddress;
    private EditText etSkypeID;
    private Button btnAddUser;

    public DataEntryFragment() {
        // Required empty public constructor
    }

    public static DataEntryFragment newInstance(
            String firstName,
            String lastName,
            String phoneNumber,
            String emailAddress,
            String skypeID){
        DataEntryFragment fragment = new DataEntryFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_NAME_PARAM, firstName);
        args.putString(LAST_NAME_PARAM, lastName);
        args.putString(PHONE_NUMBER_PARAM, phoneNumber);
        args.putString(EMAIL_ADDRESS_PARAM, emailAddress);
        args.putString(SKYPE_ID_PARAM, skypeID);
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);
        void sendDataToList(String firstName, String lastName, String phoneNumber, String emailAddress, String skypeID);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + this.toString());

        //avoid a fragment from getting desroyed
        setRetainInstance(true);

        if(getArguments() != null){
            firstName = getArguments().getString(FIRST_NAME_PARAM);
            lastName = getArguments().getString(LAST_NAME_PARAM);
            phoneNumber = getArguments().getString(PHONE_NUMBER_PARAM);
            emailAddress= getArguments().getString(EMAIL_ADDRESS_PARAM);
            skypeID = getArguments().getString(SKYPE_ID_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_entry, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDisplayStatus = view.findViewById(R.id.tvDisplayStatus);
        etFirstName = view.findViewById(R.id.etFirstName);
        etLastName = view.findViewById(R.id.etLastName);
        etPhoneNumber = view.findViewById(R.id.etPhoneNumber);
        etEmailAddress = view.findViewById(R.id.etEmailAddress);
        etSkypeID = view.findViewById(R.id.etSkypeID);
        btnAddUser.setOnClickListener(this);

    }

    //TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data){
        if(mListener != null){
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        etFirstName.setText(firstName);
        etLastName.setText(lastName);
        etPhoneNumber.setText(phoneNumber);
        etEmailAddress.setText(emailAddress);
        etSkypeID.setText(skypeID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteraionListener");
        }
    }

    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: " + this.toString());
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        mListener.sendDataToList(etFirstName.getText().toString(),etLastName.getText().toString(),etPhoneNumber.getText().toString(),etEmailAddress.getText().toString(),etSkypeID.getText().toString());
    }

}
