# Facebuk

Facebook done CS210x style.

We decided to create two additional classes on top of the required classes -- Account and Page. We added the account class because \n
we realized that the Person and Pet class had a lot of attributes and methods in common. Also within the Moment class Pet and Person \n
are treated as practically the same object, we used polymorphism in order to store Pet and Person in the same ArrayList. We also \n
noticed that all the classes shared the common attributes Name and Image and the common method equals, so we created the abstract \n
class Page in order to avoid redundancy within every single class.