import classifieds.Address
import classifieds.Seller
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        Environment.executeForEnvironment(Environment.DEVELOPMENT) {
            Seller seller = new Seller(
                    name: 'lucky one',
                    email: 'joe@acme.com',
                    address: new Address(
                            street: 'Grensen 5',
                            city: 'Oslo',
                            country: 'Norway'
                    )
            )
            seller.save()
        }
    }
    def destroy = {
    }
}
