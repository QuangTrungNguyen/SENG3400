/**
 * MyBMIServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.MyBMIServer_jws;

public interface MyBMIServer extends java.rmi.Remote {
    public java.lang.String listRanges() throws java.rmi.RemoteException;
    public java.lang.String calcBMI(java.lang.String weight, java.lang.String height) throws java.rmi.RemoteException;
    public java.lang.String listWeights(java.lang.String height) throws java.rmi.RemoteException;
}
