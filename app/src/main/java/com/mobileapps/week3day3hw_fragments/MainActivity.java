package com.mobileapps.week3day3hw_fragments;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mobileapps.week3day3hw_fragments.Fragments.DataEntryFragment;
import com.mobileapps.week3day3hw_fragments.Fragments.ListingFragment;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnFragmentInteractionListener /*, ListingFragment.OnFragmentInteractionListener */ {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tvMain;

    FragmentManager fm;
    ListingFragment listingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        //    tvMain = findViewById(R.id.tvMain);
        listingFragment = ListingFragment.newInstance();
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.flDataEntry,
                        DataEntryFragment.newInstance(), DataEntryFragment.SEND_FRAG_TAG)
                .addToBackStack(DataEntryFragment.SEND_FRAG_TAG)
                .commit();
        fm.beginTransaction()
                .add(R.id.flListing,
                        listingFragment, ListingFragment.RECV_FRAG_TAG)
                .addToBackStack(ListingFragment.RECV_FRAG_TAG)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String data) {

    }

    @Override
    public void sendDataToList(String firstName, String lastName, String phoneNumber, String emailAddress, String skypeID) {
        listingFragment.receiveMessage(firstName, lastName, phoneNumber, emailAddress, skypeID);
    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop: ");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy: ");
//    }
//
//
//    @Override
//    public void onFragmentInteraction(String data) {
//        tvMain.setText(data);
//    }
//
//    private void addListFragment(String firstName, String lastName, String phoneNumber, String emailAddress, String skypeID){
//        fm.beginTransaction()
//                .add(R.id.fragmentHolder,
//                        ListingFragment.newInstance(firstName,lastName,phoneNumber,emailAddress,skypeID), ListingFragment.TAG)
//                .addToBackStack(ListingFragment.TAG)
//                .commit();
//    }
//
//    @Override
//    public void sendDataToList(String firstName, String lastName, String phoneNumber, String emailAddress, String skypeID) {
//        ListingFragment listingFragment = (ListingFragment) fm.findFragmentById(R.id.fragmentHolder);
//        if (listingFragment == null) addListFragment(firstName,lastName,phoneNumber,emailAddress,skypeID);
//       // TODO else listingFragment.
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

}
