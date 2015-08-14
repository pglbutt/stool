package com.rackspace.sonar.plugin;

import org.sonar.api.web.*;

@WidgetProperties({
        @WidgetProperty(key = "responsetime",
                description = "Average Response Time ",
                optional = false
        )
})
/**
 * Created by dimi5963 on 8/14/15.
 */
public class StoolDashboardWidget extends AbstractRubyTemplate implements RubyRailsWidget {

    public String getId() {
        return "Stool";
    }

    public String getTitle() {

        return "Stool";
    }

    @Override
    protected String getTemplatePath() {
        return "stoolwidget.html.erb";
    }
}
