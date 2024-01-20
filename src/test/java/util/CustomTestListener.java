package util;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomTestListener extends TestListenerAdapter {

    private final String recepient = "ahmadhabibzad@gmail.com";

    //TODO screenshot goes here
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println("Printing failed test screenshots");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        EmailManager emailManager = null;
        try {
            emailManager = new EmailManager(recepient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String subject = "Testing Gmail TLS 2";
        String body = "Please find attached the test results";
        List<String> attachments = new ArrayList<>();
        File screenshotsDir = new File("screenshots");
        for (File file : Objects.requireNonNull(screenshotsDir.listFiles())) {
            attachments.add(file.getPath());
        }
        File reports = new File("reports");
        for (File file : Objects.requireNonNull(reports.listFiles())) {
            attachments.add(file.getPath());
        }
        emailManager.sendMail(subject, body, attachments);
    }
}
