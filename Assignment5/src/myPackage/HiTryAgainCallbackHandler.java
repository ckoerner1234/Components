
/**
 * HiTryAgainCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package myPackage;

    /**
     *  HiTryAgainCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HiTryAgainCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HiTryAgainCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HiTryAgainCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for helloWorld3 method
            * override this method for handling normal response from helloWorld3 operation
            */
           public void receiveResulthelloWorld3(
                    myPackage.HiTryAgainStub.HelloWorld3Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from helloWorld3 operation
           */
            public void receiveErrorhelloWorld3(java.lang.Exception e) {
            }
                


    }
    