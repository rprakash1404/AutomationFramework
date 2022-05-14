package org.design.utilities;

import java.io.IOException;
import java.util.Properties;

import com.google.inject.Singleton;

import lombok.Data;

@Singleton
@Data
public class LoadAppConfiguration {

	public Properties getAppConfig() throws IOException {
		Properties appConfigs = new Properties();
		appConfigs.load(this.getClass().getResourceAsStream("/Configurations/appConfig.properties"));
		return appConfigs;
	}

}
