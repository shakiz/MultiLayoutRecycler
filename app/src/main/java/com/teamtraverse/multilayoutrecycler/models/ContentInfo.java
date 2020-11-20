package com.teamtraverse.multilayoutrecycler.models;

public class ContentInfo {
    public int ContentId;
    public String ContentTitle;
    public String ContentDuration;
    public int ContentProgress;
    public String UploadDate;
    public String LastSeen;
    public String Genre;
    public String Artist;
    public int ViewTypeId;

    //region constructor for documents
    public ContentInfo(int viewTypeId, int contentId, String contentTitle) {
        this.ViewTypeId = viewTypeId;
        ContentId = contentId;
        ContentTitle = contentTitle;
    }
    //endregion

    //region constructor for audio
    public ContentInfo(int viewTypeId, int contentId, String contentTitle, String contentDuration, int contentProgress, String uploadDate, String lastSeen, String genre, String artist) {
        this.ViewTypeId = viewTypeId;
        ContentId = contentId;
        ContentTitle = contentTitle;
        ContentDuration = contentDuration;
        ContentProgress = contentProgress;
        UploadDate = uploadDate;
        LastSeen = lastSeen;
        Genre = genre;
        Artist = artist;
    }
    //endregion

    //region constructor for video
    public ContentInfo(int viewTypeId, int contentId, String contentTitle, String contentDuration, int contentProgress, String uploadDate, String lastSeen) {
        this.ViewTypeId = viewTypeId;
        ContentId = contentId;
        ContentTitle = contentTitle;
        ContentDuration = contentDuration;
        ContentProgress = contentProgress;
        UploadDate = uploadDate;
        LastSeen = lastSeen;
    }
    //endregion


    public int getContentId() {
        return ContentId;
    }

    public void setContentId(int contentId) {
        ContentId = contentId;
    }

    public String getContentTitle() {
        return ContentTitle;
    }

    public void setContentTitle(String contentTitle) {
        ContentTitle = contentTitle;
    }

    public String getContentDuration() {
        return ContentDuration;
    }

    public void setContentDuration(String contentDuration) {
        ContentDuration = contentDuration;
    }

    public int getContentProgress() {
        return ContentProgress;
    }

    public void setContentProgress(int contentProgress) {
        ContentProgress = contentProgress;
    }

    public String getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(String uploadDate) {
        UploadDate = uploadDate;
    }

    public String getLastSeen() {
        return LastSeen;
    }

    public void setLastSeen(String lastSeen) {
        LastSeen = lastSeen;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public int getViewTypeId() {
        return ViewTypeId;
    }

    public void setViewTypeId(int viewTypeId) {
        ViewTypeId = viewTypeId;
    }
}
