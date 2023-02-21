package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("url")
    String getUrl();

    @Key("app")
    String getApp();

    @Key("device.name")
    String getDeviceName();

    @Key("platform.version")
    String getPlatformVersion();
}
