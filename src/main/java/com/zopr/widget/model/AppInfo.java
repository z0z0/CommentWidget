package com.zopr.widget.model;

/**
 * Created by zorana on 2/20/16.
 */
public class AppInfo {

    private String status;
    private String connectionString;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }


    @Override
    public String toString() {
        return "AppInfo{" +
                "status='" + status + '\'' +
                ", connectionString='" + connectionString + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppInfo appInfo = (AppInfo) o;

        if (connectionString != null ? !connectionString.equals(appInfo.connectionString) : appInfo.connectionString != null)
            return false;
        if (status != null ? !status.equals(appInfo.status) : appInfo.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (connectionString != null ? connectionString.hashCode() : 0);
        return result;
    }
}
