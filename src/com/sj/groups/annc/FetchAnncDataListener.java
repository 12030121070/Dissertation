package com.sj.groups.annc;

import java.util.List;

public interface FetchAnncDataListener {
	public void onFetchComplete(List<Announcements> data);
    public void onFetchFailure(String msg);

}
