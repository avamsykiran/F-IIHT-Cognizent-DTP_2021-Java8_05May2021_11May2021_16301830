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

java.time           data and time manipulations 
--------------------------------------------------------------------


        LocalDate
        LocalTime
        LocalDateTime
                            Factory Methods
                            ------------------------
                            now()
                            of(...)

        ZonedDateTime

                             Factory Methods
                            ------------------------
                            now(ZoneId)
                            


        Period          in months,day....
        Duration        int day,hours...etc

                        between(start,end)

        DateTiemFormatter

                        ofPattern("");

                        d,dd
                        M,MM,MMM,MMMM
                        yy,yyyy

                        h,hh
                        H,HH
                        m,mm
                        s,ss
                        a


Functional Interfaces & Lambda Expressions
---------------------------------------------------------------------------------------------------

    is any interface that has one and only one abstract method.

    @FunctionalInterface
    interface Computable {
        int compute(int x,int y);
    }

        class Computator implements Computable{
            @Override
            public int compute(int a,int b){
                return x+y;
            }
        }


        public class LambdaExpressionDemoApp{
            public static void main(String a[]){
                Computator cpt = new Computator();
                System.out.println(cpt.compute(12,22));

                Computable cpt2 = new Computable(){
                    @Override
                    public int compute(int a,int b){
                        return x*y;
                    }
                };
                System.out.println(cpt2.compute(12,22));

                Computable cpt3 = (n1,n2) -> n1>n2?n1:n2 ;
                System.out.println(cpt3.compute(12,22));
            }
        }

Types of FunctionalInterfaces
----------------------------------------------------------------------------

    Suppliers           that return a value but has no params..

    Consumers           that does not return but has params..

    Predicates          that returns a boolean and may or may not have params....

    Operators           that return a value and accepts params, 
                        but params and return value must be of the same datatype.

    Functionals         that return a value and accepts params




java.util           collection are enhanced.
java.util.function


Streams API ------------ Functional Programming
------------------------------------------------------------------------------------
java.util.stream    

            stream means a flow of [ water/air /] DATA.

            stream is originated from a source of data (Collection/array)

            Stream s1 = Stream.of(array);

            Stream s2 = list.stream();

            Stream s3 = set.stream();

                    Stream Operators
                    ---------------------------------

                        Terminal Operators
                        operator        accepts         returns         does
                        ------------------------------------------------------------------------
                        forEach         a consumer      nothing         execues the consumer on each 
                                                                        ele in the stream
                        collect         a Collector     a Collections   gather all ele in the 
                                                                        stream into a collection

                                            Collectors.toList()
                                            Collectors.toSet()
                                            Collectors.toMap()

                        reduce          bianryOperator  java.util       execute the bianryOperator on each pai of ele
                                                            .Optional       in the stream.


                                        Stream s = Stream.of(new int[]{1,2,3,4,5,6});
                                        s.reduce((x,y) -> x+y);
                                                                //(((((1+2)+3)+4)+5)+6)
                        
                        Intermidiate Operators
                        operator        accepts         returns         does
                        ------------------------------------------------------------------------
                      
                        map             trasformer      new Stream      the transformer function is applied on
                                                                        each ele olf the current stream and
                                                                        the tranformed ele's will be passed
                                                                        out through the new stream.

                                        Stream s = Stream.of(new int[]{1,2,3,4,5,6});
                                        Stream s2 =s.map(x -> x*x); //the new stream contians 1,2,9,16,35,36
                                                      

                        filter          predicate       new Stream      the predicate has to return              
                                                                        true for an ele in the current 
                                                                        stream to be delivered in the new stream.
                                        
                                        Stream s = Stream.of(new int[]{1,2,3,4,5,6});
                                        Stream s2 =s.filter(x->x%3==0) //the new stream contians 3,6
                                        
                        flatMap         transformer     new stream      it flattens the nested contianers into
                                                                         a single container.

java.util.regex
-------------------------------------------------------------------------------------

        java.lang.String
                            matches("");

        
        Pattern
                    .compile("");
                    .matcher("");

        Matcher
                    .matches()
                    .find()


java.lang           Threads, Concerency API, Thread Pools
--------------------------------------------------------------------------------------

    Threads
                        Runnable
                            |       public void run()
                        Thread
                                    Thread()
                                    Thread(String name)
                                    Thread(Runnable)
                                    Thread(Runnable,String)

                                    start();
                                    getName()
                                    setName(String)
                                    getPriority();
                                    setPriority(int); 1 to 10, default is 5.

                                    currentThread(); //static
                                    sleep(long); //static

                        Thread Life Cycle
                                Iniation
                                Queued/Ready
                                Running/Execution
                                Paused
                                Terminated
   
                                | new Thread() 
                                Iniation
                                |
                                |start()
                                |
                                Queued/Ready ---CPU and other res's are available -- Running
                                    | wakes up / notify()                                |
                                Paused <---- sleep()/wait()<-----------------------------|
                                                                        (job is compelet)|
                                                                                         |
                         class Job {                                                   Terminated
                            public void doSomething(Object object) {
                                ................
                                synchronized (object){
                                    ...
                                }
                                .............
                            }

                            public synchronized void doSomethingElse(){
                                ..........//the current 'this'
                            }

                            public synchronized static void staticMethod(){

                            }// Job.class
                         }

java.io --------------- IO Streams
--------------------------------------------------------------------------------------
                    stream is a flow of 'data' from an input or an output device.

            BinaryStreams (data can written or read as 'bytes')

                                java.io.OutputStream
                    Program -----------> File
                            -----------> Console
                            -----------> Another Program on the network ..

                                java.io.InputStream
                    Program <----------- File
                            <----------- KB/Mouse
                            <----------- another Prog on network
            
            TextStreams (data can written or read as character/strings)

                               java.io.Writer       java.io.OutputStream
                    Program ----Text---->    bytes  -----------> File
                            ----Text---->    bytes  -----------> Console
                            ----Text---->    bytes  -----------> Another Program on the network ..

                             java.io.Reader    java.io.InputStream
                    Program <-Text------ bytes <----------- File
                            <-Text------ bytes <----------- KB/Mouse
                            <-Text------ bytes <----------- another Prog on network

                    java.io.InputStream
                                FileInputStream
                                ObjectInputStream   //deserialization
                    
                    java.io.OutputStream
                                FileOutputStream
                                ObjkectOutputStream //serialization
                                PrintStream

                    java.io.Reader
                                InputStreamReader
                                BufferedReader
                                FileReader

                    java.io.Writer
                                FileWriter
                    
                    File
                    IOException
                    FileNotFoundException

java.sql                JDBC
-------------------------------------------------------(JDBC 4)

                    step1           Loading Driver  (Automatic)

                                    Class.forName("fullyQualifiedDriverClassname");
                                    DriverManager.registerDriver(driverObject);


                                    the drive class if is available 
                                    on the claspath, it is laoded automatically.

                    step2           Opening a connection

                                        try(Connection con = DriverManager.getConnection(dbUrl,uid,pwd)){

                                        }catch(SQLException exp){
                                            ........................
                                        }

                    step3
                            a.     Retrive detaisl about the database

                                            DatabaseMetaData md = con.getMetaData();

                                            md.getDatabaseProductName();
                                            md.getDriverName();

                            b.     Execute DRl/DML/DDL

                                        Statement st = con.createStatement();

                                        st.execute(ddl);        //true or false is returned.
                                        st.executeUpdate(dml);  //no of records effected
                                        st.executeQuery(drl);   //a ResultSet

                                        PreparedStatement st = con.prepareStatement(ddlOrDmlOrDrlQry);

                                        st.execute();        //true or false is returned.
                                        st.executeUpdate();  //no of records effected
                                        st.executeQuery();   //a ResultSet

                            c.     Call Proc/.Func 

                                        CallableStatement cb = con.prepareCall(procFunCall);


