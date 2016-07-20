package com.example.androidbaseproject.licenses;

import android.net.Uri;

/**
 * Represents a single data item in the "View Open Source Licenses" list
 */
public class LicenseItem {
    private String projectName;
    private Uri licenseUrl;

    public LicenseItem(String projectName, Uri licenseUrl) {
        this.projectName = projectName;
        this.licenseUrl = licenseUrl;
    }

    public String getProjectName() {
        return projectName;
    }

    public Uri getLicenseUrl() {
        return licenseUrl;
    }
}
