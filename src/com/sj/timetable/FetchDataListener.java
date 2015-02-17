package com.sj.timetable;

import java.util.List;

public interface FetchDataListener {
    public void onFetchComplete(List<ClassInfo> data);
    public void onFetchFailure(String msg);
}
