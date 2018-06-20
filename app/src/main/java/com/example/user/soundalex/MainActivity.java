package com.example.user.soundalex;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.user.soundboardalex.R;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private ArrayList<Sound> mSounds = null;
    private SoundAdapter mAdapter = null;
    static MediaPlayer mMediaPlayer = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSounds = new ArrayList<Sound>();
        Sound s = new Sound();
        s.setDescription("Slap!");
        s.setIconResourceId(R.drawable.heli);
        s.setSoundResourceId(R.raw.loob);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Scream");
        s.setIconResourceId(R.drawable.heli);
        s.setSoundResourceId(R.raw.karjub);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Cyka blyat!");
        s.setIconResourceId(R.drawable.heli);
        s.setSoundResourceId(R.raw.cyka);
        mSounds.add(s);
        mAdapter = new SoundAdapter(this, R.layout.list_row, mSounds);
        setListAdapter(mAdapter);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
        Sound s = (Sound) mSounds.get(position);
        MediaPlayer mp = MediaPlayer.create(this, s.getSoundResourceId());
        mp.start();
    }
}
