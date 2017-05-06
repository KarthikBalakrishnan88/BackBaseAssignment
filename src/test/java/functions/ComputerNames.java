package functions;

import java.util.HashSet;
import java.util.Set;

public class ComputerNames {
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	public String computerName;
	final java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is
	// being used or not
	final Set<String> identifiers = new HashSet<String>();

	public String randomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		computerName = builder.toString();
		return builder.toString();

	}
}
