
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Coviddatabase_QNAME = new QName("http://services/", "coviddatabase");
    private final static QName _FindAllCovid_QNAME = new QName("http://services/", "findAllCovid");
    private final static QName _InsertCovid_QNAME = new QName("http://services/", "insertCovid");
    private final static QName _FindAllCovidResponse_QNAME = new QName("http://services/", "findAllCovidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Coviddatabase }
     * 
     */
    public Coviddatabase createCoviddatabase() {
        return new Coviddatabase();
    }

    /**
     * Create an instance of {@link FindAllCovid }
     * 
     */
    public FindAllCovid createFindAllCovid() {
        return new FindAllCovid();
    }

    /**
     * Create an instance of {@link InsertCovid }
     * 
     */
    public InsertCovid createInsertCovid() {
        return new InsertCovid();
    }

    /**
     * Create an instance of {@link FindAllCovidResponse }
     * 
     */
    public FindAllCovidResponse createFindAllCovidResponse() {
        return new FindAllCovidResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Coviddatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "coviddatabase")
    public JAXBElement<Coviddatabase> createCoviddatabase(Coviddatabase value) {
        return new JAXBElement<Coviddatabase>(_Coviddatabase_QNAME, Coviddatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCovid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "findAllCovid")
    public JAXBElement<FindAllCovid> createFindAllCovid(FindAllCovid value) {
        return new JAXBElement<FindAllCovid>(_FindAllCovid_QNAME, FindAllCovid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCovid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertCovid")
    public JAXBElement<InsertCovid> createInsertCovid(InsertCovid value) {
        return new JAXBElement<InsertCovid>(_InsertCovid_QNAME, InsertCovid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCovidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "findAllCovidResponse")
    public JAXBElement<FindAllCovidResponse> createFindAllCovidResponse(FindAllCovidResponse value) {
        return new JAXBElement<FindAllCovidResponse>(_FindAllCovidResponse_QNAME, FindAllCovidResponse.class, null, value);
    }

}
