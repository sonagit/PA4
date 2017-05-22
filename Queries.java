/**
 * An interface that has an abstract description for all queries.
 */
interface IQuery {

  /**
   * Determine whether a tweet is qualified according to the query.
   *
   * @param atweet the ATweet to check
   * @return true if atweet matches the query, false otherwise
   */
  boolean matches(ATweet atweet);
}

/******************************************************************************
 * This class represents a query for tweets containing a given string, which represents the username to search.
 *
 *****************************************************************************/
class UserQuery implements IQuery{
 
 String username;
 
 /**
  * Constructor for UserQuery initializes all fields
  */
  UserQuery(String username) {
   this.username = username;
  }
  
 /**
  * Returns true if the tweet's user has the given username, false otherwise
  *
  * @param atweet the ATweet to check
  * @return true if atweet matches the query, false otherwise
  */
 public boolean matches(ATweet atweet) {
  return this.username.equals(atweet.user.username);
 }
}

/******************************************************************************
 * This class represents a query for tweets no later than a certain date.
 *
 *****************************************************************************/
class BeforeQuery implements IQuery {

 DateTime beforeThis;

 /**
  * Constructor for UserQuery initializes all fields
  */
 BeforeQuery(DateTime beforeThis) {
  this.beforeThis = beforeThis;
 }
 /**
  * Returns true if the tweet's datetime is earlier than beforeThis, false otherwise
  *
  * @param atweet the ATweet to check
  * @return true if atweet matches the query, false otherwise
  */
 public boolean matches(ATweet atweet) {
  return atweet.timestamp.earlierThan(this.beforeThis);
 }
}

/******************************************************************************
 * This class represents a query for tweets whose content contains a particular strin.g
 *
 *****************************************************************************/
class ContainsQuery implements IQuery {

 String toFind;
 
 /**
  * Constructor for UserQuery initializes all fields
  */
 ContainsQuery(String toFind) {
  this.toFind = toFind; //the String to search for in tweets
 }
 
 /**
  * Returns true if the tweet's content contains toFind, false otherwise
  *
  * @param atweet the ATweet to check
  * @return true if atweet matches the query, false otherwise
  */
 public boolean matches(ATweet atweet) {
  return atweet.content.contains(this.toFind);
 }
}



