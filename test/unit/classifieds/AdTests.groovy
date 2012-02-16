package classifieds

import grails.test.mixin.TestFor
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Ad)
class AdTests {
    void testHappyPath() {
        mockForConstraintsTests(Ad)

        Ad ad = new Ad(
                heading: '1234567890',
                description: 'abcdefghijk',
                reference: 'AB12',
                askingPrice: 42.0,
                seller: new Seller(
                        name: 'random name'
                )
        )

        assert ad.validate()
    }

    void testWrongReference() {
        mockForConstraintsTests(Ad)

        Ad ad = new Ad(
                heading: '1234567890',
                description: 'abcdefghijk',
                askingPrice: 42.0,
                seller: new Seller(
                        name: 'random name'
                )
        )

        assert !ad.validate()
        assert 'nullable' == ad.errors['reference']

        ad.reference = ''
        assert !ad.validate()
        assert 'blank' == ad.errors['reference']

        ad.reference = 'AAA'
        assert !ad.validate()
        assert 'matches' == ad.errors['reference']

        ad.reference = '123'
        assert !ad.validate()
        assert 'matches' == ad.errors['reference']

        ad.reference = 'AZ09'
        assert ad.validate()
    }

    void testReferenceIsUnique() {
        Ad initialAd = new Ad(
                heading: '1234567890',
                description: 'abcdefghijk',
                reference: 'AB12',
                askingPrice: 42.0,
                seller: new Seller(
                        name: 'random name'
                )
        )
        mockDomain(Ad, [initialAd])

        Ad ad = new Ad(
                heading: 'not so random',
                description: 'not so random',
                reference: 'AB12',
                askingPrice: 42.0,
                seller: new Seller(
                        name: 'random name'
                )
        )

        assert !ad.validate()
        assert 'reference' == ad.errors.fieldError.field
        assert 'unique' == ad.errors.fieldError.code

        ad.reference = 'PQ34'
        assert ad.validate()
    }
    
    void testPublishedProperty() {
        mockForConstraintsTests(Ad)
        Ad ad = new Ad(
                heading: 'not so random',
                description: 'not so random',
                reference: 'AB12',
                askingPrice: 42.0,
                seller: new Seller(
                        name: 'random name'
                )
        )
        
        LocalDate tomorrow = LocalDate.now().plusDays(1)
        ad.published = tomorrow
        
        assert !ad.validate()
        assert 'validator' == ad.errors.published
        
        ad.published = LocalDate.now()
        assert ad.validate()
        
        ad.published = LocalDate.now().minusDays(1)
        assert ad.validate()
    }
}


























