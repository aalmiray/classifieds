package classifieds

class Buyer {
    String name
    String email
    Address address

    static embedded = ['address']

    static constraints = {
        name(nullable: false, blank: false)
        email(nullable: false, blank: false, email: true)
    }
}

class Address {
    String street
    String city
    String country
    
    static constrains = {
        street(nullable: false, blank: false)
        city(nullable: false, blank: false)
        country(nullable: false, blank: false)
    }
}