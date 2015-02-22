package com.sj.noticeboard;

import java.util.List;

public interface FetchNoticesListener {
	public void onFetchComplete(List<Notices> data);
    public void onFetchFailure(String msg);

}
