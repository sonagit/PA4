public class FilterTweets {
	/**
	* Constructor for main
	*
	* @param args command line arguments
	*/
	public static void main(String[] args) {
		
		TweetList t = new SampleTweets().t;
		
		// For starting and ending HTML string output
		String htmlStart = "<html>\n<head>\n<meta charset='utf8'>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"tweetstyle.css\">\n</head>\n<body>\n";
		String htmlEnd = "\n</body>\n</html>\n";

		// Ignore calls without options
		if(args.length == 0) {
			System.out.println("Please provide a command: \n");
			System.out.println("java FilterTweets <command> <criterion> <value>\n");
		}

/*****************************************************************************/
		// Print out HTML
		else if( args.length > 0 && args[0].equals("html") ) {
			// Print starting HTML
			System.out.println(htmlStart);
			
			// User queries
			if( args[1].equals("user") ) {
				UserQuery uq = new UserQuery(args[2]);
				System.out.println(t.filter(uq).toHTML());
			}

			// Before queries
			if( args[1].equals("before") ) {
				
				// Parse date string to ints
				String[] dt = args[2].split("/");
				int d = Integer.parseInt(dt[0]);
				int m = Integer.parseInt(dt[1]);
				int y = Integer.parseInt(dt[2]);
				
				BeforeQuery bq = new BeforeQuery(new DateTime(d,m,y));
				System.out.println(t.filter(bq).toHTML());
			}

			// Contains queries
			if(args[1].equals("contains")) {
				ContainsQuery cq = new ContainsQuery(args[2]);
				System.out.println(t.filter(cq).toHTML());
			}

			// Print end HTML
			System.out.println(htmlEnd);
		}
		
/**************************************************************************/
		// Print out number
		else if(args.length > 0 && args[0].equals("count")) {
			
			// User queries
			if( args[1].equals("user") ) {
				UserQuery uq = new UserQuery(args[2]);
				System.out.println(t.count(uq));
			}
			
			// Before queries
			if( args[1].equals("before") ) {
				
				// Parse date string to ints
				String[] dt = args[2].split("/");
				int d = Integer.parseInt(dt[0]);
				int m = Integer.parseInt(dt[1]);
				int y = Integer.parseInt(dt[2]);

				BeforeQuery bq = new BeforeQuery(new DateTime(d,m,y));
				System.out.println(t.count(bq));
				
			}
			
			// Contains queries
			if( args[1].equals("contains") ) {
				ContainsQuery cq = new ContainsQuery(args[2]);
				System.out.println(t.count(cq));
			}
		}
		
		// capture typos
		else {
			System.out.println("Incorrect command. Please use the following syntax: \n");
			System.out.println("java FilterTweets <command> <criterion> <value>\n");
		}
	}
}
