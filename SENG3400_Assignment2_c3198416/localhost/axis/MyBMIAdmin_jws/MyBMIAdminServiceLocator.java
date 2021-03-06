/**
 * MyBMIAdminServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.MyBMIAdmin_jws;

public class MyBMIAdminServiceLocator extends org.apache.axis.client.Service implements localhost.axis.MyBMIAdmin_jws.MyBMIAdminService {

    public MyBMIAdminServiceLocator() {
    }


    public MyBMIAdminServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyBMIAdminServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyBMIAdmin
    private java.lang.String MyBMIAdmin_address = "http://localhost:8080/axis/MyBMIAdmin.jws";

    public java.lang.String getMyBMIAdminAddress() {
        return MyBMIAdmin_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyBMIAdminWSDDServiceName = "MyBMIAdmin";

    public java.lang.String getMyBMIAdminWSDDServiceName() {
        return MyBMIAdminWSDDServiceName;
    }

    public void setMyBMIAdminWSDDServiceName(java.lang.String name) {
        MyBMIAdminWSDDServiceName = name;
    }

    public localhost.axis.MyBMIAdmin_jws.MyBMIAdmin getMyBMIAdmin() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyBMIAdmin_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyBMIAdmin(endpoint);
    }

    public localhost.axis.MyBMIAdmin_jws.MyBMIAdmin getMyBMIAdmin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.MyBMIAdmin_jws.MyBMIAdminSoapBindingStub _stub = new localhost.axis.MyBMIAdmin_jws.MyBMIAdminSoapBindingStub(portAddress, this);
            _stub.setPortName(getMyBMIAdminWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyBMIAdminEndpointAddress(java.lang.String address) {
        MyBMIAdmin_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.axis.MyBMIAdmin_jws.MyBMIAdmin.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.MyBMIAdmin_jws.MyBMIAdminSoapBindingStub _stub = new localhost.axis.MyBMIAdmin_jws.MyBMIAdminSoapBindingStub(new java.net.URL(MyBMIAdmin_address), this);
                _stub.setPortName(getMyBMIAdminWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MyBMIAdmin".equals(inputPortName)) {
            return getMyBMIAdmin();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/MyBMIAdmin.jws", "MyBMIAdminService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/MyBMIAdmin.jws", "MyBMIAdmin"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyBMIAdmin".equals(portName)) {
            setMyBMIAdminEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
