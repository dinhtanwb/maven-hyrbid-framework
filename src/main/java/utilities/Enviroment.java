package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environmentConfig/${env}.properties"})
//@Sources({"classpath:dev.properties"})

public interface Enviroment extends Config{
	String url();
	
	@Key("db.url")
	String dbUrl();
	
	@Key("db.username")
	String dbUserName();
	
	@Key("db.password")
	String dbPassword();
}
