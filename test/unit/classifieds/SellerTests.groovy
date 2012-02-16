package classifieds

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Seller)
class SellerTests {
    void testHappyPath() {
        mockForConstraintsTests(Seller)
        
        Seller seller = new Seller(
                name: 'some random name',
                email: 'joe@acme.com',
                address: new Address(
                        street: 'Grensen 5',
                        city: 'Oslo',
                        country: 'Norway'
                )
        )

        assert seller.validate()
    }
    
    void testWrongEmail() {
        mockForConstraintsTests(Seller)

        Seller seller = new Seller(
                name: 'some random name',
                address: new Address(
                        street: 'Grensen 5',
                        city: 'Oslo',
                        country: 'Norway'
                )
        )
        
        assert !seller.validate()
        assert 'nullable' == seller.errors.email

        seller.email = ''
        assert !seller.validate()
        assert 'blank' == seller.errors.email

        seller.email = 'joe@'
        assert !seller.validate()
        assert 'email' == seller.errors.email

        seller.email = '@acme.com'
        assert !seller.validate()
        assert 'email' == seller.errors.email

        seller.email = 'acme.com'
        assert !seller.validate()
        assert 'email' == seller.errors.email

        seller.email = 'joe@acme'
        assert !seller.validate()
        assert 'email' == seller.errors.email

        seller.email = 'joe@acme.com'
        assert seller.validate()
    }
    
    void testRelationships() {
        mockDomain(Seller)
        mockDomain(Ad)

        Seller seller = new Seller(
                name: 'some random name',
                email: 'joe@acme.com',
                address: new Address(
                        street: 'Grensen 5',
                        city: 'Oslo',
                        country: 'Norway'
                )
        )

        Ad ad1 = new Ad(
                heading: '1234567890',
                description: 'abcdefghijk',
                reference: 'AB12',
                askingPrice: 42.0
        )
        Ad ad2 = new Ad(
                heading: '1234567890',
                description: 'abcdefghijk',
                reference: 'ZZ00',
                askingPrice: 42.0
        )

        assert !seller.ads
        
        // seller.ads << ad2 DONT!
        seller.addToAds(ad1)
        assert seller.ads.size() == 1
        assert ad1 in seller.ads
        assert ad1.seller == seller
        
        seller.addToAds(ad2)
        assert seller.ads.size() == 2
        
        seller.removeFromAds(ad1)
        assert seller.ads.size() == 1
        assert !(ad1 in seller.ads)
        assert ad2 in seller.ads
        assert !ad1.seller
        
        assert seller.save()
        seller.delete()
    }
}



































