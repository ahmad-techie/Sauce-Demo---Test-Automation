package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    public static ExtentReports createReportsObject(){
        ExtentReports extentReports;
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/regression_report.html");
        reporter.config().setReportName("Regression test suite");
        reporter.config().setReportName("Masoud");
        reporter.config().setDocumentTitle("Test Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
