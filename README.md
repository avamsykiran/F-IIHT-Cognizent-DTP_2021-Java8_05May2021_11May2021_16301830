https://github.com/avamsykiran/F-IIHT-Cognizent-DTP_2021-Java8_05May2021_11May2021_16301830.git
-----------------------------------------------------------------------------------------------

Java 5  to Java 8
-----------------------------------------------------

    JDK 8
    Eclipse IDE


    Basics
    ----------------------------------------------------

        java.lang
                        Object
                                    hashcode()                                   
                                    equals(Object)
                                    toString()
                                    getClass()

                        System
                                    in      java.io.InputStream
                                    out     java.io.PrintStream
                                    err     java.io.PrintStream

                        Math
                        
                        String
                                    'immutability'

                                    String s1 = "Hello";
                                    String s2 = new String("World");

                                    s1 = s1 + s2;

                        StringBuilder
                        StringBuffer


        Exceptions
            java.lang
                            Throwable
                                |
                            ---------------------
                            |                   |
                        Exception               Error
                            |
                            ------------------------------
                            |                            |
                        RuntimeException                Many Sub classes From Exception
                                |                           CHECKED Exceptions
                                |
                                Many more sub classes
                                    UNCHECKED Exception

                        
                        public double estimateCost(Item item,int quantity){
                            return item.getPrice()*quantity;
                        }

                        Item itm = null;
                        estimatCost(itm,23); 
                                //raise a NullPointerException, here i have to sue try..catch

                        ---------------------------------------------------------------

                        public double estimateCost(Item item,int quantity){
                            double cost=0;
                            if(item!=null){
                                cost = item.getPrice()*quantity;
                            }
                            return cost;
                        }

                        Item itm = null;
                        estimatCost(itm,23); // 0

                        DO NOT HANDLE UNCHECKED EXCEPTION!!!!
                        why?
                            they can be avoided!
                            by srting a logical cosntruct (Defencive Programing)

                        WE CAN NOT AVOID CHEKCED EXCEPTIONS!
                            handle them using throws, try..catch!!
                        

                        class UserDefiendCheckedException extends Exception {
                            public UserDefiendCheckedException(String errMsg){
                                super(errMsg);
                            }
                        }

                        class UserDefiendUnCheckedException extends RuntimeException {
                            public UserDefiendUnCheckedException(String errMsg){
                                super(errMsg);
                            }
                        }

                        throw

                        throws

                        try{
                            ..........
                        }catch(ExceptionType e1){
                            
                        }catch(ExceptionType2 e1){
                            
                        }catch(ExceptionType3 e1){
                            
                        }finally{

                        }

                        try with multicatch 
                        ---------------------------------
                        try{
                            ..........
                        }catch(ExceptionType | ExceptionType2 | ExceptionType3 e1){
                            .........................
                        }finally{
                            //write close() statements
                        }

                        try-with-resources
                        --------------------------------------
                        try(Connection con = DriverManager.getComnnection(url)) {
                            ..................
                        }catch(SQLException exp){
                            ..............
                        }

                            try-with-resources can be used on
                            object os classes that implment Closable.
================================================================================================
Interfaces
            default methods
            static methods

            Functional Interfaces.

java.time           data and time manipulations 

Lambda Expressions
Streams API ------------ Functional Programming

java.util           collection are enhanced.
java.util.function
java.util.stream 
java.util.regex

java.io
java.nio

java.lang           Threads, Concerency API, Thread Pools

java.sql



