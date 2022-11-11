package Models;

import Enum.EFrom;

public class FileProcessor {
    public String File64;
    public String TrackID;
    public EFrom From;
    public String UserId;

    public FileProcessor(String file64, String trackID, EFrom from, String userId) {
        File64 = file64;
        TrackID = trackID;
        From = from;
        UserId = userId;
    }



}
