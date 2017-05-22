import tester.*;

/**
 * Test out all them fancy methods
 */
class ExampleQueries {
 
  // Create some queries
  UserQuery uq1 = new UserQuery("ghc");
  UserQuery uq2 = new UserQuery("UCSDJacobs");
  UserQuery uq3 = new UserQuery("kobebryant");

  BeforeQuery bq1 = new BeforeQuery(new DateTime(2,2,2020));
  BeforeQuery bq2 = new BeforeQuery(new DateTime(3,3,2015));
  BeforeQuery bq3 = new BeforeQuery(new DateTime(4,4,2016));
  
  ContainsQuery cq1 = new ContainsQuery("Yeezy");
  ContainsQuery cq2 = new ContainsQuery("Anita");
  ContainsQuery cq3 = new ContainsQuery("the");

  // Bring in sample tweets
  SampleTweets stl = new SampleTweets();
  
  // Make a couple lists
  TweetList tle = new TLEmpty();
  TweetList tl1 = new TLLink(stl.textTweet1,tle);
  TweetList tl2 = new TLLink(stl.textTweet2,tl1);
 
 /******************TESTING TESTING 123***************************************/

  // check UserQuery.matches
  boolean testUserMatches(Tester t) {
    return t.checkExpect(uq1.matches(stl.textTweet2), true) &&
            t.checkExpect(uq1.matches(stl.textTweet9), false) &&
            t.checkExpect(uq2.matches(stl.textTweet9), true); // 3
 }

  // check BeforeQuery.matches
  boolean testBeforeMatches(Tester t) {
    return t.checkExpect(bq1.matches(stl.textTweet2), true) &&
            t.checkExpect(bq2.matches(stl.textTweet2), false) &&
            t.checkExpect(bq3.matches(stl.textTweet1), false); // 6
 }

  // check ContainsQuery.matches
  boolean testContainsMatches(Tester t) {
    return t.checkExpect(cq1.matches(stl.textTweet2), false) &&
            t.checkExpect(cq2.matches(stl.textTweet2), true) &&
            t.checkExpect(cq3.matches(stl.textTweet1), true); // 9
 }

  // check TLLink filter
  boolean testTLLinkFilter(Tester t) {
    return t.checkExpect(stl.t.filter(uq3), new TLLink(stl.textTweet4, new TLEmpty())) &&
            t.checkExpect(stl.t.filter(bq1), stl.t) &&
            t.checkExpect(stl.t.filter(cq1), new TLLink(stl.textTweet5, new TLEmpty())); // 12
 }

  // check TLLink count
  boolean testTLLinkCount(Tester t) {
    return t.checkExpect(stl.t.count(uq1), 2) &&
            t.checkExpect(stl.t.count(bq1), stl.t.length()) &&
            t.checkExpect(stl.t.count(cq3), 13); // 15
 }

  // check TLLink length
  boolean testTLLinkLength(Tester t) {
    return t.checkExpect(tl1.length(), 1) &&
            t.checkExpect(tl2.length(), 2) &&
            t.checkExpect(stl.t.length(), 34); // 18
 }

  // check TLEmpty filter
  boolean testTLEmptykFilter(Tester t) {
    return t.checkExpect(tle.filter(uq1), new TLEmpty()) &&
            t.checkExpect(tle.filter(cq1), new TLEmpty()); // 20
 }

  // check TLEmpty count
  boolean testTLEmptyCount(Tester t) {
    return t.checkExpect(tle.count(uq1), 0) &&
            t.checkExpect(tle.count(cq1), 0); // 22
 }

  // check TLEmpty length
  boolean testTLEmptyLength(Tester t) {
    return t.checkExpect(tle.length(), 0) &&
            t.checkExpect(tle.length(), 0); // 24
 }//*/
}
