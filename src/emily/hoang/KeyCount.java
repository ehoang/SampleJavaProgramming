package emily.hoang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class KeyCount {

	/**
	 * Sums up keys in the text file with the file name specified. The file
	 * should have the format of "key,count" where key is a string and count is
	 * an integer. Each line will only contain one key-count pair. The output
	 * should contain each key occurring in the file along with the sum of the
	 * count for all occurrences of a given key. For Example:
	 * 
	 * John,2 
	 * Jane,3 
	 * John,4 
	 * Jane,5
	 * 
	 * Would result in the output:
	 * "The total for John is 6. The total for Jane is 8."
	 * 
	 * Note that the key is case sensitive. If there is more than one
	 * "key,count" pair on one line, they will be ignored.
	 * 
	 * If the file does not exist or could not be process, <code>null</code>
	 * will be returned.
	 * 
	 * @param fileName
	 *            name of the text file containing the "key,count" information.
	 * @return the sum of the count for all occurrences of a given key. empty
	 *         string if the file is empty. <code>null</code> if the file does
	 *         not exist or could not be process.
	 */
	public static String countFromFile(String fileName) {
		StringBuilder result = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// check parameter
		if ((fileName == null) || (fileName.isEmpty())) {
			return null;
		}

		// error checking on file
		File file = new File(fileName);
		if (!(file.exists() && file.isFile() && file.canRead())) {
			return null;
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] tokens = line.split(",");

					// not enough tokens
					if (tokens.length < 2) {
						System.err.println("Key or value is not present. Continue parsing...");
						continue;
					}

					if ((tokens[0] == null) || (tokens[0].trim().isEmpty())) {
						System.err.println("Could not parse key. Continue parsing...");
						continue;
					}
					
					// parse value
					Integer count;
					try {
						count = Integer.valueOf(tokens[1]);
					} catch (NumberFormatException e) {
						System.err.println("Could not parse value '"
								+ tokens[1] + "' for " + tokens[0]
								+ ". Continue parsing...");
						continue;
					}

					if (map.containsKey(tokens[0])) {
						// sum up value
						count += map.get(tokens[0]);
					}

					map.put(tokens[0], count);
				}
			} finally {
				reader.close();
			}

		} catch (IOException ex) {
			System.err.println("Could not process file " + fileName + ". Exiting...");
			return null;
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			result.append(String.format("The total for %1$s is %2$s. ",
					entry.getKey(), entry.getValue()));
		}

		return result.toString();
	}
}
