package app;

import java.util.List;

/**
 * Interface for all different tools
 * 
 * ---Replace List with Set?
 * 
 * @author akiko
 * @version 1.0 10.01.2022
 *
 */
public interface ITool {
	
	public void startToolService(Rules rules);
	public List<String> returnResults();

}
