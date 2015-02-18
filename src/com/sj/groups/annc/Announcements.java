package com.sj.groups.annc;

public class Announcements {

	private int gid;
    private String heading;
    
    Announcements(){
    	
    }
    
    public int getGroupId() {
        return gid;
    }
    public void setGroupId(int gid) {
        this.gid = gid;
        //globalVariable.setName(this.name);
    }
    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }
}
