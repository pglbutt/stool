package com.rackspace.sonar.plugin;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

/**
 * Created by dimi5963 on 8/14/15.
 */
public class StoolSensor implements Sensor {

    private final Settings settings;

    public StoolSensor(Settings settings) {
        this.settings = settings;
    }

    @Override
    public void analyse(Project project, SensorContext sensorContext) {
        try {
            GlobalSummary summary = getGlobalSummary(project);
            if (summary != null) {
                StoolDAO.saveSummaryAsMetrics(summary, sensorContext);
            }
        } catch (Exception e) {

        }
    }

    public GlobalSummary getGlobalSummary(Project project) {
        String filePath = settings.getString(StoolPluginConst.LOCAL_RESULTS_PATH_PROPERTY);
        GlobalSummary summary = new GlobalSummary();
        summary.setRequestResponseTimeAvg(123.456);
        return summary;
    }

    @Override
    public boolean shouldExecuteOnProject(Project project) {
        return true;
    }
}
