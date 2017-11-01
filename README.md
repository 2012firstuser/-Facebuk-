# Facebuk

#### Akash Shaji, Bryson Tang, Ankur Gupta

We decided to create two additional classes on top of the required classes -- Account and Page. 

### Page
All of the objects in this project each have a

* Name
* Image
* equals()
* Getters & Setters for name & image

in their object. Therefore, it would be redundant to rewrite these in every single class, so this one master
class would ensure minimal repetition. Additionally, because all of the objects need to override the default
Object's `equals()` method, when we compare 2 objects we just had to see if they were downcasts of `Page`, in order
to implement our special method of comparision. This makes our method a lot cleaner, because then we don't have a 
switch making sure that the object that we are comparing actually contains a `name` attribute.

### Account
We realized that the Person and Pet class had a lot of attributes and methods in common, such as

* Friends
* Moments
* getFriendWithWhomIAmHappiest()
* getOverallHappiestMoment()
* findMaximumCliqueOfFriends()
* isClique()
* Getters & Setters for all attributes
 
Additionally,within the Moment class Pet and Person are treated as practically the same object. In fact, we used 
polymorphism in order to store Pet and Person in the same ArrayList. 