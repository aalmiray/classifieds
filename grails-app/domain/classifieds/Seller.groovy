package classifieds

class Seller {
    String name
    String email
    Address address

    static embedded = ['address']
    static hasMany = [ads: Ad]

    static constraints = {
        name(nullable: false, blank: false)
        email(nullable: false, blank: false, email: true)
    }
}
