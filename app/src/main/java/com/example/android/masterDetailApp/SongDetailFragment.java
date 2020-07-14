package com.example.android.masterDetailApp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.masterDetailApp.content.SongUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends Fragment {

    // SongItem includes the song title and detail.
    public SongUtils.Song mSong;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    public static SongDetailFragment newInstance(int selectedSong){
        SongDetailFragment songDetailFragment = new SongDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(SongUtils.SONG_ID_KEY, selectedSong);
        songDetailFragment.setArguments(arguments);

        return songDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(SongUtils.SONG_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mSong = SongUtils.SONG_ITEMS.get(getArguments()
                    .getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.song_detail, container, false);
        //Get the view of TextView
        final TextView textView = rootView.findViewById(R.id.song_detail);
        // Show the detail information in a TextView.
        if (mSong != null) {
            textView.setText(mSong.details);
        }
        return rootView;
    }
}
