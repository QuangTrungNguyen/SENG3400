/**
 * MyBMIServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.MyBMIServer_jws;

public class MyBMIServerServiceLocator extends org.apache.axis.client.Service implements localhost.axis.MyBMIServer_jws.MyBMIServerService {

    public MyBMIServerServiceLocator() {
    }


    public MyBMIServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MyBMIServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MyBMIServer
    private java.lang.String MyBMIServer_address = "http://localhost:8080/axis/MyBMIServer.jws";

    public java.lang.String getMyBMIServerAddress() {
        return MyBMIServer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MyBMIServerWSDDServiceName = "MyBMIServer";

    public java.lang.String getMyBMIServerWSDDServiceName() {
        return MyBMIServerWSDDServiceName;
    }

    public void setMyBMIServerWSDDServiceName(java.lang.String name) {
        MyBMIServerWSDDServiceName = name;
    }

    public localhost.axis.MyBMIServer_jws.MyBMIServer getMyBMIServer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MyBMIServer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMyBMIServer(endpoint);
    }

    public localhost.axis.MyBMIServer_jws.MyBMIServer getMyBMIServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.MyBMIServer_jws.MyBMIServerSoapBindingStub _stub = new localhost.axis.MyBMIServer_jws.MyBMIServerSoapBindingStub(portAddress, this);
            _stub.setPortName(getMyBMIServerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMyBMIServerEndpointAddress(java.lang.String address) {
        MyBMIServer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.axis.MyBMIServer_jws.MyBMIServer.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.MyBMIServer_jws.MyBMIServerSoapBindingStub _stub = new localhost.axis.MyBMIServer_jws.MyBMIServerSoapBindingStub(new java.net.URL(MyBMIServer_address), this);
                _stub.setPortName(getMyBMIServerWSDDServiceName());
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
        if ("MyBMIServer".equals(inputPortName)) {
            return getMyBMIServer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/MyBMIServer.jws", "MyBMIServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/MyBMIServer.jws", "MyBMIServer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MyBMIServer".equals(portName)) {
            setMyBMIServerEndpointAddress(address);
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
