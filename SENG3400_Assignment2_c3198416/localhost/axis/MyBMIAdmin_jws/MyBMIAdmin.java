/**
 * MyBMIAdmin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.MyBMIAdmin_jws;

public interface MyBMIAdmin extends java.rmi.Remote {
    public boolean setName(java.lang.String user, java.lang.String pwd, java.lang.String oldName, java.lang.String newName) throws java.rmi.RemoteException;
    public boolean addRange(java.lang.String user, java.lang.String pwd, java.lang.String lower, java.lang.String upper, java.lang.String name, boolean normal) throws java.rmi.RemoteException;
    public int callCount(java.lang.String user, java.lang.String pwd) throws java.rmi.RemoteException;
    public void addCallCount() throws java.rmi.RemoteException;
    public boolean deleteRange(java.lang.String user, java.lang.String pwd, java.lang.String name) throws java.rmi.RemoteException;
}
