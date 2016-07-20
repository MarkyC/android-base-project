package com.example.androidbaseproject.licenses;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidbaseproject.R;

import java.util.Arrays;
import java.util.List;

/**
 * This Fragment shows the list of open source projects used in the project
 * and allows you to view their Licenses
 */
public class LicenseFragment extends Fragment {

    private static final List<LicenseItem> LICENSES = Arrays.asList(
            new LicenseItem("JUnit", Uri.parse("http://junit.org/junit4/license.html")),
            new LicenseItem("Crashlytics", Uri.parse("https://try.crashlytics.com/terms/")),
            new LicenseItem("Android Support Libraries", Uri.parse("http://www.apache.org/licenses/LICENSE-2.0")),
            new LicenseItem("Retrofit", Uri.parse("https://raw.githubusercontent.com/square/retrofit/master/LICENSE.txt")),
            new LicenseItem("Picasso", Uri.parse("https://raw.githubusercontent.com/square/picasso/master/LICENSE.txt"))
    );

    /**
     * Opens the License URL when a list item is clicked
     */
    private final OnListFragmentInteractionListener
            SHOW_LICENSE_LISTENER = new OnListFragmentInteractionListener() {
        @Override
        public void showLicense(LicenseItem item) {
            startActivity(new Intent(Intent.ACTION_VIEW, item.getLicenseUrl()));
        }
    };

    public LicenseFragment() {
        // Mandatory empty constructor
    }

    public static LicenseFragment newInstance() {
        return new LicenseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_license_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new LicenseRecyclerViewAdapter(LICENSES, SHOW_LICENSE_LISTENER));
        }
        return view;
    }

    public interface OnListFragmentInteractionListener {
        void showLicense(LicenseItem item);
    }
}
