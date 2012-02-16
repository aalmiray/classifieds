package classifieds

class ReferenceMakerService {
    static transactional = false
    def randomGen

    String newReference() {
        'AA' + randomGen.nextDecimal() + randomGen.nextDecimal()
    }
}
