/**
 * Interface for a linked list structure of Tweet
 */
interface TweetList {

  /**
   * Filter the tweets according to the query passed in.
   *
   * @param q an abstract query for filtering tweets
   * @return a TweetList that has all the qualified tweets according to the query
   */
  TweetList filter(IQuery q);

  /**
   * Count the number of qualified tweets according to the query passed in.
   *
   * @param q an abstract query for filtering tweets
   * @return an int that represents the number of qualified tweets
   */
  int count(IQuery q);

  /**
   * Provide the HTML for all tweets in the list.
   *
   * @return a string that represents all HTML for all tweets
   */
  String toHTML();

  /**
   * Return the length of the list.
   *
   * @return an int that represents the length of the tweet list
   */
  int length();
}

// You will implement the methods above in each of the two classes below

class TLLink implements TweetList{

  ATweet tweet;
  TweetList rest;

  /**
   * Constructor for TLLink that initializes all fields
   *
   * @param tweet
   * @param rest
   */
  TLLink(ATweet tweet, TweetList rest){
    this.tweet = tweet;
    this.rest=rest;
  }

  /**
   * Returns a new TweetList with only the tweets matching the given query.
   * Should optionally check and include the value field in the resulting
   * list, along with recursively checking the rest of the list.
   *
   * @param q an IQuery
   * @return TweetList
   */
  TweetList filter(IQuery q) {
    //blah
  }

  /**
   * Returns the number of tweets matching the given query
   *
   * @param q
   * @return int
   */
  int count(IQuery q) {
    //blah
  }

  /**
   * Returns the number of tweets in the list
   *
   * @param none
   * @return string
   */
  int length() {
    //blah
  }

}

class TLEmpty implements TweetList{
  TLEmpty(){ }
}
