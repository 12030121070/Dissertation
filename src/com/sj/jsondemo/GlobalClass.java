package com.sj.jsondemo;

import android.app.Application;

	public class GlobalClass extends Application{
		
		
		public String server_addr="http://10.10.25.34:8888";
		private long prn;
	    private String username;
	    private String password;
	    private String name;
	    
	    private String program;
	    private int p_id;
	    private int b_id;
	    private String batch;
	    
	    public long getPrn() {
	        return prn;
	    }
	    public void setPrn(long uid) {
	        this.prn = uid;
	    }
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getProgram() {
	        return program;
	    }
	    public void setProgram(String pname) {
	        this.program = pname;
	    }
	    public String getBatch() {
	        return batch;
	    }
	    public void setBatch(String bname) {
	        this.batch = bname;
	    }
	    public int getPid() {
	        return p_id;
	    }
	    public void setPid(int p) {
	        this.p_id = p;
	    }
	    public int getBid() {
	        return b_id;
	    }
	    public void setBid(int b) {
	        this.b_id = b;
	    }

	}

