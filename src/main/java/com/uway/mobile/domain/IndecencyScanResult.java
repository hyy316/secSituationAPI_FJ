package com.uway.mobile.domain;

import java.io.Serializable;
import java.util.Date;

public class IndecencyScanResult implements Serializable {
    private Integer id;

	private Integer assertinfoid;
    
	private Integer notify;
	
    private String ip;

    private String port;

    private String department;    

    private String oriurl;

    private String url;

    private Date scantime;

    private String title;

    private String sensitype;

    private String occurence;

    private String esid;

    private String htmlcontent;
    
    private static final long serialVersionUID = 1L;

    
    public IndecencyScanResult(Integer notify,Integer assertinfoid, String ip, String port, String department, String oriurl,
			String url, Date scantime, String title, String sensitype, String occurence, String esid,
			String htmlcontent) {
		super();
		this.notify = notify;
		this.assertinfoid = assertinfoid;
		this.ip = ip;
		this.port = port;
		this.department = department;
		this.oriurl = oriurl;
		this.url = url;
		this.scantime = scantime;
		this.title = title;
		this.sensitype = sensitype;
		this.occurence = occurence;
		this.esid = esid;
		this.htmlcontent = htmlcontent;
	}
    
    public Integer getNotify() {
		return notify; 
	}
    
    public void setNotify(Integer notify) {
		this.notify=notify;
	}
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssertinfoid() {
        return assertinfoid;
    }

    public void setAssertinfoid(Integer assertinfoid) {
        this.assertinfoid = assertinfoid;
    }

    
    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOriurl() {
        return oriurl;
    }

    public void setOriurl(String oriurl) {
        this.oriurl = oriurl == null ? null : oriurl.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getScantime() {
        return scantime;
    }

    public void setScantime(Date scantime) {
        this.scantime = scantime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSensitype() {
        return sensitype;
    }

    public void setSensitype(String sensitype) {
        this.sensitype = sensitype == null ? null : sensitype.trim();
    }

    public String getOccurence() {
        return occurence;
    }

    public void setOccurence(String occurence) {
        this.occurence = occurence == null ? null : occurence.trim();
    }

    public String getEsid() {
        return esid;
    }

    public void setEsid(String esid) {
        this.esid = esid == null ? null : esid.trim();
    }
    
    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent == null ? null : htmlcontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", notify").append(notify);
        sb.append(", assertinfoid=").append(assertinfoid);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", department=").append(department);
        sb.append(", oriurl=").append(oriurl);
        sb.append(", url=").append(url);
        sb.append(", scantime=").append(scantime);
        sb.append(", title=").append(title);
        sb.append(", sensitype=").append(sensitype);
        sb.append(", occurence=").append(occurence);
        sb.append(", esid=").append(esid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}