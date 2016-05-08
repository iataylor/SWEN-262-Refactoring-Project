/* BowlerFile.java
 *
 *  Version:
 *  		$Id$
 * 
 *  Revisions:
 * 		$Log: BowlerFile.java,v $
 * 		Revision 1.5  2003/02/02 17:36:45  ???
 * 		Updated comments to match javadoc format.
 * 		
 * 		Revision 1.4  2003/02/02 16:29:52  ???
 * 		Added ControlDeskEvent and ControlDeskObserver. Updated Queue to allow access to Vector so that contents could be viewed without destroying. Implemented observer model for most of ControlDesk.
 * 		
 * 
 */

/**
 * Class for interfacing with Bowler database
 *
 */

import java.io.*;
import java.util.Vector;

class BowlerFile {

	/** The location of the bowelr database */
	private static String BOWLER_DAT = System.getProperty("user.dir") + "\\BOWLER_DAT";

    /**
     * Retrieves bowler information from the database and returns a Bowler objects with populated fields.
     *
     * @param nickName	the nickName of the bolwer to retrieve
     *
     * @return a Bowler object
     * 
     */

	public static Bowler getBowlerInfo(String nickName){
		//throws IOException, FileNotFoundException {
		try {
			File file = new File(BOWLER_DAT);
			if (!file.exists())
				file.createNewFile();

			BufferedReader in = new BufferedReader(new FileReader(file));
			String data;
			while ((data = in.readLine()) != null) {
				// File format is nick\tfname\te-mail
				String[] bowler = data.split("\t");
				if (nickName.equals(bowler[0])) {
					System.out.println(
							"Nick: "
									+ bowler[0]
									+ " Full: "
									+ bowler[1]
									+ " email: "
									+ bowler[2]);
					return (new Bowler(bowler[0], bowler[1], bowler[2]));
				}
			}
			System.out.println("Nick not found...");
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

    /**
     * Stores a Bowler in the database
     *
     * @param nickName	the NickName of the Bowler
     * @param fullName	the FullName of the Bowler
     * @param email	the E-mail Address of the Bowler
     *
     */

	public static void putBowlerInfo(
		String nickName,
		String fullName,
		String email)
		throws IOException {

		String data = nickName + "\t" + fullName + "\t" + email + "\n";

		RandomAccessFile out = new RandomAccessFile(BOWLER_DAT, "rw");
		out.skipBytes((int) out.length());
		out.writeBytes(data);
		out.close();
	}

    /**
     * Retrieves a list of nicknames in the bowler database
     *
     * @return a Vector of Strings
     * 
     */

	public static Vector getBowlers(){
		//throws IOException, FileNotFoundException {
		Vector allBowlers = new Vector();
		try {
			System.out.println(BOWLER_DAT);
			File file = new File(BOWLER_DAT);
			if (!file.exists())
				file.createNewFile();

			BufferedReader in = new BufferedReader(new FileReader(file));
			String data;
			while ((data = in.readLine()) != null) {
				// File format is nick\tfname\te-mail
				String[] bowler = data.split("\t");
				//"Nick: bowler[0] Full: bowler[1] email: bowler[2]
				allBowlers.add(bowler[0]);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return allBowlers;
	}

}