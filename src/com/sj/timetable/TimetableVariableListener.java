package com.sj.timetable;

import java.util.List;

public interface TimetableVariableListener {
	
	public void onFetchComplete(List<TimetableVariables> data);
    public void onFetchFailure(String msg);

}
