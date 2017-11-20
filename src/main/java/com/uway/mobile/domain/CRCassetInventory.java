package com.uway.mobile.domain;

import java.io.Serializable;
import java.util.Date;

public class CRCassetInventory implements Serializable {
    private Integer id;

    /**
     * 公司
     */
    private String department;

    private String ip;

    private String port;

    /**
     * 域名
     */
    private String domain;

    /**
     * 网站
     */
    private String web;

    /**
     * 主类
     */
    private String mainclass;

    /**
     * 子类
     */
    private String childclass;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public String getMainclass() {
        return mainclass;
    }

    public void setMainclass(String mainclass) {
        this.mainclass = mainclass == null ? null : mainclass.trim();
    }

    public String getChildclass() {
        return childclass;
    }

    public void setChildclass(String childclass) {
        this.childclass = childclass == null ? null : childclass.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", department=").append(department);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append(", domain=").append(domain);
        sb.append(", web=").append(web);
        sb.append(", mainclass=").append(mainclass);
        sb.append(", childclass=").append(childclass);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}