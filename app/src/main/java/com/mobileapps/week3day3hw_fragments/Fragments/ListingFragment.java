package com.mobileapps.week3day3hw_fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobileapps.week3day3hw_fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = ListingFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String FIRST_NAME_PARAM = "param1";
    public static final String LAST_NAME_PARAM = "param2";
    public static final String PHONE_NUMBER_PARAM = "param3";
    public static final String EMAIL_ADDRESS_PARAM = "param4";
    public static final String SKYPE_ID_PARAM = "param5";

    // TODO: Rename and change types of parameters
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String skypeID;

    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvPhoneNumber;
    private TextView tvEmailAddress;
    private TextView tvSkypeID;

    public ListingFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ListingFragment.
//     */
    // TODONE: Rename and change types and number of parameters
    public static ListingFragment newInstance(
            String firstName,
            String lastName,
            String phoneNumber,
            String emailAddress,
            String skypeID){
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_NAME_PARAM, firstName);
        args.putString(LAST_NAME_PARAM, lastName);
        args.putString(PHONE_NUMBER_PARAM, phoneNumber);
        args.putString(EMAIL_ADDRESS_PARAM, emailAddress);
        args.putString(SKYPE_ID_PARAM, skypeID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        return inflater.inflate(R.layout.fragment_listing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvEmailAddress = view.findViewById(R.id.tvEmailAddress);
        tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
        tvSkypeID = view.findViewById(R.id.tvSkypeID);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvFirstName.setText(firstName);
        tvLastName.setText(lastName);
        tvPhoneNumber.setText(phoneNumber);
        tvEmailAddress.setText(emailAddress);
        tvSkypeID.setText(skypeID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
