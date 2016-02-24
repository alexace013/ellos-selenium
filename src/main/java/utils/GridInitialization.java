package utils;

public class GridInitialization {

    private String browserName;
    private String browserVersion;
    private String platform;

    public GridInitialization(String browserName, String browserVersion, String platform) {

        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.platform = platform;

    }

    public String getBrowserName() {

        return browserName;

    }

    public void setBrowserName(String browserName) {

        this.browserName = browserName;

    }

    public String getBrowserVersion() {

        return browserVersion;

    }

    public void setBrowserVersion(String browserVersion) {

        this.browserVersion = browserVersion;

    }

    public String getPlatform() {

        return platform;

    }

    public void setPlatform(String platform) {

        this.platform = platform;

    }

    @Override
    public String toString() {

        return "GridInitialization{" +
                "browserName='" + browserName + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", platform='" + platform + '\'' +
                '}';

    }

}
