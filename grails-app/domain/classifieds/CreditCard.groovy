package classifieds

class CreditCard {
    String number
    String ccv
    String type

    static transients = ['number', 'ccv', 'formula']

    static constraints = {
        type(nullable: false, inList: ['visa', 'mastercard'])
    }
    
    String getFormula() {
        'random value'
    }
}
