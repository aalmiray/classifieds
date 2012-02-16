package classifieds

@Mixin(CommonActions)
class AdController {
    static defaultAction = "create"

    def referenceMakerService

    def caller() {
        common()
    }
    
    def create() {
        [bean: new CreateAdCommand()]
    }

    def submit(CreateAdCommand command) {
        if (command.hasErrors()) {
            render(view: 'create', model: [bean: command])
            return
        }

        Seller s = Seller.findByEmail(command.email)
        if (!s) {
            command.errors.rejectValue('email', 'You are not registered!')
            render(view: 'create', model: [bean: command])
            return
        }

        Ad ad = new Ad(params)
        ad.with {
            seller = s
            reference = referenceMakerService.newReference()
        }

        if (!ad.save()) {
            flash.message = "500 Internal server error"
            render(view: 'create', model: [bean: ad])
        }

        [ad: ad]
    }
}

class CreateAdCommand {
    String heading
    String description
    BigDecimal askingPrice
    String email

    static constraints = {
        heading(nullable: false, blank: false, minSize: 5, maxSize: 40)
        description(nullable: false, blank: false, maxSize: 5000)
        askingPrice(min: 0.0, max: 1000000.0)
        email(nullable: false, blank: false, email: true)
    }
}
