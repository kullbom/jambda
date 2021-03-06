package com.agical.jambda.demo;

import com.agical.jambda.Functions;
import com.agical.jambda.Functions.Fn0;
import com.agical.jambda.Functions.Fn1;
import com.agical.jambda.Functions.Fn2;

public class DemoFunctions {
        
    public static final Fn1<Greeting, String> greetingToString = 
        new Fn1<Greeting, String>() {
            public String apply(Greeting greeting) {
                return greeting.getGreeting();
            }
        };
    
    public static Fn1<Integer, String> personalGreeting =
        new Fn1<Integer, String>() {
            public String apply(Integer nr) {
                return "Hello, nr " + nr + "!";
            }
        };
    
    public static Fn1<User, Greeting> typedPersonalGreeting = 
        new Fn1<User, Greeting>() {
            public Greeting apply(User user) {
                return new Greeting("Hello, " + user.getName() + "!");
            }
        };
    
    public static Fn0<Greeting> typedAnonymousGreeting = 
    	Functions.<Greeting>constantly(new Greeting("Hello!"));
    
    public static Fn1<String, User> userCreator =
        new Fn1<String, User>() {
            public User apply(String name) {
                return new User(name);
            }
        };
    
    public static Fn1<Exception, Greeting> exceptionGreeting =
        new Fn1<Exception, Greeting>() {
            public Greeting apply(Exception exception) {
                return new Greeting("There was an Exception: "
                        + exception.getMessage());
            }
        };
    
    public static Fn1<String, Boolean> acceptStringsStartingWithJ =
        new Fn1<String, Boolean>() {
            public Boolean apply(String string) {
                return string.indexOf("J")==0;
            }
        };

    public static Fn2<String, String, String> aggregateStrings = 
        new Fn2<String, String, String>() {
            public String apply(String string, String accumulation) {
                return "(" + accumulation + string + ")";
            }
        };
    
}
