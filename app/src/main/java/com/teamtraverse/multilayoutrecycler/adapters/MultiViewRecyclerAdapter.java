package com.teamtraverse.multilayoutrecycler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.teamtraverse.multilayoutrecycler.R;
import com.teamtraverse.multilayoutrecycler.models.ContentInfo;
import java.util.ArrayList;
import static com.teamtraverse.multilayoutrecycler.utils.Constants.CONTENT_TYPE_AUDIO;
import static com.teamtraverse.multilayoutrecycler.utils.Constants.CONTENT_TYPE_DOCUMENTS;
import static com.teamtraverse.multilayoutrecycler.utils.Constants.CONTENT_TYPE_VIDEO;

public class MultiViewRecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<ContentInfo> contentInfoList;

    public MultiViewRecyclerAdapter(ArrayList<ContentInfo> contentInfoList) {
        this.contentInfoList = contentInfoList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (contentInfoList.get(position).getViewTypeId()){
            case 1:
                return CONTENT_TYPE_AUDIO;
            case 2:
                return CONTENT_TYPE_VIDEO;
            case 3:
                return CONTENT_TYPE_DOCUMENTS;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case CONTENT_TYPE_AUDIO:
                View audioView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_audio,parent,false);
                return new AudioViewHolder(audioView);
            case CONTENT_TYPE_VIDEO:
                View videoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_video,parent,false);
                return new VideoViewHolder(videoView);
            case CONTENT_TYPE_DOCUMENTS:
                View documentsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_documents,parent,false);
                return new DocumentsViewHolder(documentsView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContentInfo contentInfo = contentInfoList.get(position);
        switch (contentInfo.getViewTypeId()){
            case CONTENT_TYPE_AUDIO:
                ((AudioViewHolder)holder).setData(contentInfo);
                break;
            case CONTENT_TYPE_VIDEO:
                ((VideoViewHolder)holder).setData(contentInfo);
                break;
            case CONTENT_TYPE_DOCUMENTS:
                ((DocumentsViewHolder)holder).setData(contentInfo);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return contentInfoList.size();
    }

    //region viewHolder for audio
    public class AudioViewHolder extends RecyclerView.ViewHolder{
        TextView ContentTitle, ContentDuration, ContentProgress, Genre, Artist, LastSeen;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);
            ContentTitle = itemView.findViewById(R.id.ContentTitle);
            ContentDuration = itemView.findViewById(R.id.ContentDuration);
            ContentProgress = itemView.findViewById(R.id.ContentProgress);
            Genre = itemView.findViewById(R.id.Genre);
            Artist = itemView.findViewById(R.id.Artist);
            LastSeen = itemView.findViewById(R.id.LastSeen);
        }

        public void setData(ContentInfo contentInfo){
            ContentTitle.setText(contentInfo.getContentTitle());
            ContentDuration.setText(contentInfo.getContentDuration());
            ContentProgress.setText(""+contentInfo.getContentProgress());
            Genre.setText(contentInfo.getGenre());
            Artist.setText(contentInfo.getArtist());
            LastSeen.setText(contentInfo.getLastSeen());
        }
    }
    //endregion

    //region viewHolder for video
    public class VideoViewHolder extends RecyclerView.ViewHolder{
        TextView ContentTitle, ContentDuration, ContentProgress, LastSeen;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            ContentTitle = itemView.findViewById(R.id.ContentTitle);
            ContentDuration = itemView.findViewById(R.id.ContentDuration);
            ContentProgress = itemView.findViewById(R.id.ContentProgress);
            LastSeen = itemView.findViewById(R.id.LastSeen);
        }

        public void setData(ContentInfo contentInfo){
            ContentTitle.setText(contentInfo.getContentTitle());
            ContentDuration.setText(contentInfo.getContentDuration());
            ContentProgress.setText(""+contentInfo.getContentProgress());
            LastSeen.setText(contentInfo.getLastSeen());
        }
    }
    //endregion

    //region viewHolder for documents
    public class DocumentsViewHolder extends RecyclerView.ViewHolder{
        TextView ContentTitle;

        public DocumentsViewHolder(@NonNull View itemView) {
            super(itemView);
            ContentTitle = itemView.findViewById(R.id.ContentTitle);
        }

        public void setData(ContentInfo contentInfo){
            ContentTitle.setText(contentInfo.getContentTitle());
        }
    }
    //endregion
}
