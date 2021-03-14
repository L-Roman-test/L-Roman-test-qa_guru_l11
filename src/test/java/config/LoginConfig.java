package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:authorization.properties"
})
public interface LoginConfig extends Config {

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();
}
