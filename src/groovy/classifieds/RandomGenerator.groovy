package classifieds

import org.apache.commons.lang.math.RandomUtils

class RandomGenerator {
    int nextDecimal() {
        RandomUtils.nextInt() % 10
    }
}
