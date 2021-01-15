package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.recycle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.R;
import id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first.DateModel;

import java.util.List;

public class DateModelRecyclerViewAdapter extends RecyclerView.Adapter<DateModelRecyclerViewAdapter.ViewHolder> {

    private final List<DateModel> mValues;

    public DateModelRecyclerViewAdapter(List<DateModel> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        long milliseconds = mValues.get(position).getTimeRecorded();
        int mili = (int) milliseconds % 1000 ;
        int seconds = (int) (milliseconds / 1000) % 60 ;
        int minutes = (int) ((milliseconds / (1000*60)) % 60);
        int hours   = (int) ((milliseconds / (1000*60*60)) % 24);

        holder.mItem = mValues.get(position);
        holder.mTanggal.setText(mValues.get(position).getTimeCreated());
        holder.mWaktu.setText(String.format("%d hours, %d min, %d sec, %d mili", hours,minutes,seconds,mili));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTanggal;
        public final TextView mWaktu;
        public DateModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTanggal = (TextView) view.findViewById(R.id.tanggal);
            mWaktu = (TextView) view.findViewById(R.id.waktu);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mWaktu.getText() + "'";
        }
    }
}