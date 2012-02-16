package classifieds

import org.joda.time.LocalDate

class Ad {
    String heading
    String description
    String reference
    BigDecimal askingPrice
    Seller seller
    Date dateCreated
    Date lastUpdated
    LocalDate published
    boolean sold

    static belongsTo = Seller

    static constraints = {
        heading(nullable: false, blank: false, minSize: 5, maxSize: 40)
        description(nullable: false, blank: false, maxSize: 5000)
        reference(nullable: false, blank: false, unique: true,
                matches: /[A-Z]{2}[0-9]{2}/)
        askingPrice(min: 0.0, max: 1000000.0)
        published(nullable: true, validator: { val ->
            val <= LocalDate.now()
        })
    }
}
