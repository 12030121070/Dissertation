package com.sj.groups;

import android.content.Context;

public class Application {
    private String name;
    private int gid;
    Context c;
    
    Application(){
    	
    }
    
    public String getGroupName() {
        return name;
    }
    public void setGroupName(String name) {
        this.name = name;
        //globalVariable.setName(this.name);
    }
    public int getGroupId()
    {
    	return gid;
    }
    public void setGroupId(int gid) {
        this.gid = gid;
        
    }
    
}
