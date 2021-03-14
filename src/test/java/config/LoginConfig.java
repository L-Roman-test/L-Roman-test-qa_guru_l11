package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:authorization.properties", "system:properties"})
public interface LoginConfig extends Config {

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();
}
