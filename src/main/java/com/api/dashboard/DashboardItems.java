package com.api.dashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardItems {

    public final static String REPOS_UPDATE = "Update Repo";

    public final static String VERSION_CONTROL = "Control versions";


    public static List<String> getAllDashboardItems(){
        List<String> dashboardItems = new ArrayList<>();
        dashboardItems.add(VERSION_CONTROL);
        dashboardItems.add(REPOS_UPDATE);
        return dashboardItems;

    }
}
