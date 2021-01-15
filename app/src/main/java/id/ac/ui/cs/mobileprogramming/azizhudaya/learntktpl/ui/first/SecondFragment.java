package id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.ui.first;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.R;
import id.ac.ui.cs.mobileprogramming.azizhudaya.learntktpl.recycle.DateModelRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    private Button backButton;
    private RecyclerView list;
    private DateModelViewModel mViewModel;

    public SecondFragment() {
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DateModelViewModel.class);
        backButton = getActivity().findViewById(R.id.backButton);
        list = getActivity().findViewById(R.id.list);

        RecyclerView recyclerView = list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mViewModel.getAllDateModel().observe(getViewLifecycleOwner(), datemodel -> {
            recyclerView.setAdapter(new DateModelRecyclerViewAdapter(datemodel));
        });

        backButton.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new FirstFragment());
            fragmentTransaction.commit();
        });
    }


}