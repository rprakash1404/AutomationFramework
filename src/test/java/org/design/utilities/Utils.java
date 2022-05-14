package org.design.utilities;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import lombok.Data;

@Data
@Singleton
public class Utils {

	@Inject
	FileUtil fileUtil;
	
	
	
}
