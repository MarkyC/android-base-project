package com.example.androidbaseproject.licenses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidbaseproject.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LicenseItem} and makes a call to the
 * specified {@link LicenseFragment.OnListFragmentInteractionListener} when a LicenseItem is clicked
 */
public class LicenseRecyclerViewAdapter extends RecyclerView.Adapter<LicenseRecyclerViewAdapter.ViewHolder> {

    private final List<LicenseItem> items;
    private final LicenseFragment.OnListFragmentInteractionListener listener;

    public LicenseRecyclerViewAdapter(List<LicenseItem> items, LicenseFragment.OnListFragmentInteractionListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_license_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = items.get(position);
        holder.mContentView.setText(items.get(position).getProjectName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.showLicense(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public LicenseItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}
