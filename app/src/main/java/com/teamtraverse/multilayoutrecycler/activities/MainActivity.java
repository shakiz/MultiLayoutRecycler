package com.teamtraverse.multilayoutrecycler.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.teamtraverse.multilayoutrecycler.R;
import com.teamtraverse.multilayoutrecycler.adapters.MultiViewRecyclerAdapter;
import com.teamtraverse.multilayoutrecycler.models.ContentInfo;
import com.teamtraverse.multilayoutrecycler.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ContentInfo> contentInfoList;
    private RecyclerView contentRecycler;
    private MultiViewRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region init UI and perform all UI interactions
        initUI();
        bindUIWithComponents();
        //endregion
    }

    //region init UI
    private void initUI() {
        contentRecycler = findViewById(R.id.contentRecycler);
        contentInfoList = new ArrayList<>();
    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents() {
        //region set data for recycler
        setRecyclerData();
        //endregion

        //region set adapter
        setRecyclerAdapter();
        //endregion
    }
    //endregion

    //region set data for recycler
    private void setRecyclerData(){
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_DOCUMENTS,1,"Common Interview Questions.pdf"));
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_AUDIO,2,"Hum Tum Audio.mp3","3 minutes",10,
                "10 Nov 2019","13 Aug 2020","PaglaSongs.com","Sukriti and Prakriti Pakkar"));
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_VIDEO,3,"Amar Bangla Boi.mp4","2 minutes",12,
                "12 Sep 2019","09 Dec 2020"));
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_DOCUMENTS,4,"Amder Desh er kahini.pdf"));
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_AUDIO,5,"Baby Girl.mp3","4 minutes",15,
                "10 Nov 2019","13 Aug 2020","PaglaSongs.com","Guru Randhawa"));
        contentInfoList.add(new ContentInfo(Constants.CONTENT_TYPE_VIDEO,6,"Learn English By Practice.mp4","20 minutes",12,
                "12 Sep 2019","09 Dec 2020"));
    }
    //endregion

    //region set adapter
    private void setRecyclerAdapter(){
        recyclerAdapter = new MultiViewRecyclerAdapter(contentInfoList);
        contentRecycler.setLayoutManager(new LinearLayoutManager(this));
        contentRecycler.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }
    //endregion
}