package com.blackbirds.shakil.imagesliding.Fragments.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import com.blackbirds.shakil.imagesliding.R;

import java.util.Arrays;
import java.util.List;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;
    AppCompatButton btnProspectiveBuyer, btnExistingClient;

    RelativeLayout layoutProspectBuyer, layoutExistingClient;

    AppCompatSpinner propertyTypeSpinner, locationSpinner, sizeSpinner, problemTypeSpinner;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        btnProspectiveBuyer = rootView.findViewById(R.id.btnProspectiveBuyer);
        btnExistingClient = rootView.findViewById(R.id.btnExistingClient);
        layoutProspectBuyer = rootView.findViewById(R.id.layoutProspectBuyer);
        layoutExistingClient = rootView.findViewById(R.id.layoutExistingClient);
        propertyTypeSpinner = rootView.findViewById(R.id.propertyTypeSpinner);
        locationSpinner = rootView.findViewById(R.id.locationSpinner);
        sizeSpinner = rootView.findViewById(R.id.sizeSpinner);
        problemTypeSpinner = rootView.findViewById(R.id.problemTypeSpinner);

        List<String> propertySpinnerItem = Arrays.asList("Residential", "Commercial");
        ArrayAdapter propertyArrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, propertySpinnerItem);
        propertyArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propertyTypeSpinner.setAdapter(propertyArrayAdapter);

        List<String> locationSpinnerItem = Arrays.asList("Gulshan 1", "Gulshan 2", "Baridhara", "Banani", "Dhanmondi", "Uttara", "Other");
        ArrayAdapter locationArrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, locationSpinnerItem);
        locationArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationArrayAdapter);

        List<String> sizeSpinnerItem = Arrays.asList("2500-3000", "3000-3500", "3500-4000", "4000-4500", "4500-Above");
        ArrayAdapter sizeArrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, sizeSpinnerItem);
        sizeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(sizeArrayAdapter);

        List<String> typeOfProblemSpinnerItem = Arrays.asList("Civil works", "Electrical", "ID", "Special", "Other");
        ArrayAdapter typeOfProblemArrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, typeOfProblemSpinnerItem);
        typeOfProblemArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        problemTypeSpinner.setAdapter(typeOfProblemArrayAdapter);

        btnProspectiveBuyer.setOnClickListener(v -> {
            btnProspectiveBuyer.setBackgroundResource(R.drawable.online_button_bg);
            btnProspectiveBuyer.setTextColor(Color.parseColor("#FF000000"));
            btnExistingClient.setBackgroundResource(R.drawable.offline_button_bg);
            btnExistingClient.setTextColor(Color.parseColor("#cccccc"));
            layoutProspectBuyer.setVisibility(View.VISIBLE);
            layoutExistingClient.setVisibility(View.GONE);
        });

        btnExistingClient.setOnClickListener(v -> {
            btnProspectiveBuyer.setBackgroundResource(R.drawable.offline_button_bg);
            btnProspectiveBuyer.setTextColor(Color.parseColor("#cccccc"));
            btnExistingClient.setBackgroundResource(R.drawable.online_button_bg);
            btnExistingClient.setTextColor(Color.parseColor("#FF000000"));
            layoutProspectBuyer.setVisibility(View.GONE);
            layoutExistingClient.setVisibility(View.VISIBLE);
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}