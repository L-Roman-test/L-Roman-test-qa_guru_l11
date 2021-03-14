package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${environment}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("remote.url")
    String getRemoteURL();

    @Key("video.storage")
    String getVideoStorage();
}
