Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

Encapsulation is the binding of data and functionality in a way that protects it from misuse and outside interference, or wrapping the data and any code acting on the data together as a single unit. In a Java class, this is seen as all instance variables being private and only the methods within that class being able to manipulate those variables, as well as having public getter and setter methods on the class to modify and view the variable values. An example of this would be having a menu system that makes calls on methods for an object whose attributes are marked for private access.

********************
2. Inheritance

Inheritance enables new classes to build on the properties of existing classes. There are several ways inheritance can be implemented in Java (single, multi-level, and hierarchical). In single level inheritance, the child class inherits the behavior from the parent class; in multi-level inheritance, the relation of grandparent to parent to child is followed; and finally, in hierarchical inheritance, multiple children inherit from the same parent class. While multi-level inheritance is allowed in Java, multiple inheritances are not allowed; in other words a class can't extend more than one class.

As an example of inheritance, a Vehicle class could have properties such as engine and doors that are inherited by Car class, where the car class also has properties specific to itself such as wheels. In this example there could also be another sub-class such as CompactCar that further inherits from the Vehicle class.

********************
3. Abstraction

Abstraction in OOP is limiting information to what the user is concerned with, which handles complexity by hiding the unnecessary details from the user. This is generally accomplished through abstract classes and interfaces in Java. As an example, in a ride share app the user simply touches to enter a pickup point, they are not concerned with how the map is opened or how it finds your location; these details are abstracted away.

********************
4. Polymorphism
   
Polymorphism in OOP is the ability to redefine methods for derived classes. All Java objects can be considered polymorphic in the sense that they are all of their own type and instances of the Object class. Polymorphism takes two forms in Java - method overloading and method overriding. Method overloading happens when multiple methods with the same name are used in a class, and they are called based on the number, order, and type of their parameters. Method overriding is when the child class overrides the method of its parent class.

As an example of overriding, given a method on the Vehicle class called run() that returns a string "I am running", a child class called Car could have an overridden method that gets the original string from the parent class with a call to super.run() that then adds " smoothly" to the end to return "I am running smoothly" when called.





Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



