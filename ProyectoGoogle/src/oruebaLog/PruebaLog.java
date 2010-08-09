package oruebaLog;

import org.apache.log4j.Logger;

public class PruebaLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger log=(Logger)Logger.getLogger(PruebaLog.class);
		log.info("Prueba Log");
	}

}
